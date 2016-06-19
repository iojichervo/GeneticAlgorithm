package ar.edu.itba.sia.replacement;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.selection.Selection;

import java.util.List;

public class MethodTwoReplacement implements Replacement {

    @Override
    public List<Warrior> replace(int k, List<Warrior> population, Selection selection, Crossover crossover,
                                 Mutation mutation, Selection replacement) {
        //Selection
        List<Warrior> parents = selection.select(k, population);

        //Crossover
        List<Warrior> children = crossover.cross(parents);

        //Mutation
        children.stream().forEach(c -> mutation.mutate(c));

        //Replacement
        int n = population.size();
        List<Warrior> nextGeneration = replacement.select(n - k, population);
        nextGeneration.addAll(children);
        return nextGeneration;
    }
}
