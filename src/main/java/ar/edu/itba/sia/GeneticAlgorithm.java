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
import ar.edu.itba.sia.util.AlgorithmProperties;
import ar.edu.itba.sia.util.FitnessCalculator;
import ar.edu.itba.sia.util.WarriorsGenerator;

import java.util.List;

public class GeneticAlgorithm {

    public static void run(AlgorithmProperties p) {
        // Initial Population
        List<Warrior> warriors = WarriorsGenerator.generateWarriors(p.getN());

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

        Selection selection = new CompoundSelection(p.getA(), p.getSelection1(), p.getSelection2());
        Crossover crossover = p.getCrossover();
        Mutation mutation = p.getMutation();
        Selection rep = new CompoundSelection(p.getB(), p.getReplacement1(), p.getReplacement2());
        Replacement replacement = p.getReplacement();
        Cut cut = p.getCut();

        int generation = 1;
        while (!cut.cut(generation, warriors)) {
            FitnessCalculator.calculateTotalFitness(warriors);
            warriors = replacement.replace(p.getK(), warriors, selection, crossover, mutation, rep);
            generation++;
        }

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

    }

}
