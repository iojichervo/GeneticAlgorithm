package ar.edu.itba.sia.replacement;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.selection.Selection;

import java.util.LinkedList;
import java.util.List;

public class MethodOneReplacement implements Replacement {

    @Override
    public List<Warrior> replace(int k, List<Warrior> population, Selection selection, Crossover crossover,
                                 Mutation mutation, Selection replacement) {
        List<Warrior> nextGeneration = new LinkedList<>();
        int n = population.size();

        while (nextGeneration.size() < n) {
            //Selection
            List<Warrior> parents = selection.select(2, population);

            //Crossover
            List<Warrior> children = crossover.cross(parents);

            //Mutation
            children.stream().forEach(c -> mutation.mutate(c));

            nextGeneration.addAll(children);
        }

        return nextGeneration;
    }
}
