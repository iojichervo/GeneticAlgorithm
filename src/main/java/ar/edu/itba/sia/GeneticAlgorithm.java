package ar.edu.itba.sia;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.cut.Cut;
import ar.edu.itba.sia.graph.WarriorsPlot;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.replacement.Replacement;
import ar.edu.itba.sia.selection.CompoundSelection;
import ar.edu.itba.sia.selection.Selection;
import ar.edu.itba.sia.util.AlgorithmProperties;
import ar.edu.itba.sia.util.WarriorsUtils;

import java.util.List;

public class GeneticAlgorithm {

    public static void run(AlgorithmProperties p) {
        // Initial Population
        List<Warrior> warriors = WarriorsUtils.generateWarriors(p.getN());

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

        WarriorsPlot plot = new WarriorsPlot();
        int generation = 1;
        while (!cut.cut(generation, warriors)) {
            WarriorsUtils.calculateTotalFitness(warriors);
            warriors = replacement.replace(p.getK(), warriors, selection, crossover, mutation, rep);

            // Plotting
            plot.addAvg(generation, WarriorsUtils.averageFitness(warriors));
            plot.addBest(generation, WarriorsUtils.bestFitness(warriors));
            plot.addWorst(generation, WarriorsUtils.worstFitness(warriors));

            Warrior bestWarrior = WarriorsUtils.getBestWarrior();
            System.out.println("Best Warrior: " + bestWarrior.fitness() + " - " + bestWarrior);

            generation++;
        }

        for (Warrior warrior : warriors) {
            System.out.println(warrior.fitness() + " - " + warrior);
        }
        System.out.println();

    }

}
