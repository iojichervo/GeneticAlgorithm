package ar.edu.itba.sia.replacement;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.selection.Selection;

import java.util.List;

public interface Replacement {

    public List<Warrior> replace(int k, List<Warrior> population, Selection selection, Crossover crossover,
                                 Mutation mutation, Selection replacement);
}
