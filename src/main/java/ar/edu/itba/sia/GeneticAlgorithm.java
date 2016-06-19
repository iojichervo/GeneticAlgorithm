package ar.edu.itba.sia;

import ar.edu.itba.sia.crossover.AnnularCrossover;
import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.cut.Cut;
import ar.edu.itba.sia.cut.MaxGeneration;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.mutation.NonUniformMutation;
import ar.edu.itba.sia.replacement.MethodTwoReplacement;
import ar.edu.itba.sia.replacement.Replacement;
import ar.edu.itba.sia.selection.*;
import ar.edu.itba.sia.util.FitnessCalculator;
import ar.edu.itba.sia.util.WarriorsGenerator;

import java.util.List;

public class GeneticAlgorithm {

    public static void run() {
        // Initial Population
        List<Warrior> warriors = WarriorsGenerator.generateWarriors(50);

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

        Selection selection = new CompoundSelection(0.75, new Elitism(), new Roulette());
        Crossover crossover = new AnnularCrossover(0.8);
        Mutation mutation = new NonUniformMutation(0.005);
        Selection rep = new CompoundSelection(0.50, new Elitism(), new DeterministicTournament());
        Replacement replacement = new MethodTwoReplacement();
        Cut cut = new MaxGeneration(10);

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
