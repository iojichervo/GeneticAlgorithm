package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.Collections;
import java.util.List;

public class RandomSelection implements Selection {

    @Override
    public List<? extends Chromosome> select(int amount, List<? extends Chromosome> population) {
        Collections.shuffle(population);
        return population.subList(0, amount);
    }
}
