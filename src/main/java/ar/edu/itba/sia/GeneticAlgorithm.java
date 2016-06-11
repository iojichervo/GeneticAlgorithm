package ar.edu.itba.sia;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.crossover.OnePointCrossover;
import ar.edu.itba.sia.generator.WarriorsGenerator;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.ClassicMutation;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.selection.Elitism;
import ar.edu.itba.sia.selection.ProbabilisticTournament;
import ar.edu.itba.sia.selection.Selection;

import java.util.Collections;
import java.util.List;

public class GeneticAlgorithm {

    public static void run() {
        // Initial Population
        List<Warrior> warriors = WarriorsGenerator.generateWarriors(30);

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

        int i = 0;
        while (i++ < 30) { //TODO implement a better break condition
            //Selection
            Selection selection = new Elitism();
            List<Warrior> selected = selection.select(10, warriors);

            //Crossover
            Crossover crossover = new OnePointCrossover();
            Warrior son1 = selected.get(0).duplicate();
            Warrior son2 = selected.get(1).duplicate();
            crossover.cross(son1, son2);

            //Mutation
            Mutation mutation = new ClassicMutation(0.03);
            mutation.mutate(son1);
            mutation.mutate(son2);

            //Replacement
            warriors.add(son1);
            warriors.add(son2);
            Collections.shuffle(warriors);
            warriors = selection.select(30, warriors);
        }

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

    }

}
