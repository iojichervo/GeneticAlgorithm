package ar.edu.itba.sia;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.crossover.OnePointCrossover;
import ar.edu.itba.sia.generator.WarriorsGenerator;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.ClassicMutation;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.selection.Elitism;
import ar.edu.itba.sia.selection.Selection;

import java.util.Collections;
import java.util.List;

public class GeneticAlgorithm {

    public static void run() {
        // Initial Population
        List<Warrior> warriors = WarriorsGenerator.generateWarriors(100);

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

        int i = 0;
        while (i++ < 100) { //TODO implement a better break condition
            //Selection
            Selection selection = new Elitism();
            List<Warrior> parents = selection.select(50, warriors);

            //Crossover
            Crossover crossover = new OnePointCrossover(0.8);
            List<Warrior> children = crossover.cross(parents);

            //Mutation
            Mutation mutation = new ClassicMutation(0.005);
            children.stream().forEach(c -> mutation.mutate(c));

            //Replacement
            warriors.addAll(children);
            Collections.shuffle(warriors);
            warriors = selection.select(100, warriors);
        }

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

    }

}
