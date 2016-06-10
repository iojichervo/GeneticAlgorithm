package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.List;

public interface Selection {

    List<? extends Chromosome> select(int amount, List<? extends Chromosome> population);
}
