package ar.edu.itba.sia;

import ar.edu.itba.sia.crossover.*;
import ar.edu.itba.sia.cut.*;
import ar.edu.itba.sia.replacement.MethodThreeReplacement;
import ar.edu.itba.sia.replacement.Replacement;
import ar.edu.itba.sia.selection.Elitism;
import ar.edu.itba.sia.selection.Roulette;
import ar.edu.itba.sia.selection.Universal;
import ar.edu.itba.sia.util.FitnessCalculator;
import ar.edu.itba.sia.util.WarriorsGenerator;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.mutation.NonUniformMutation;
import ar.edu.itba.sia.selection.Selection;

import java.util.List;

public class GeneticAlgorithm {

    public static void run() {
        // Initial Population
        List<Warrior> warriors = WarriorsGenerator.generateWarriors(50);

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

        Selection selection = new Elitism();
        Crossover crossover = new AnnularCrossover(0.8);
        Mutation mutation = new NonUniformMutation(0.005);
        Selection rep = new Elitism();
        Replacement replacement = new MethodThreeReplacement();
        Cut cut = new Optimal(20);

        int generation = 1;
        while (!cut.cut(generation, warriors)) {
            FitnessCalculator.calculateTotalFitness(warriors);
            warriors = replacement.replace(20, warriors, selection, crossover, mutation, rep);
            generation++;
        }

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

    }

}
