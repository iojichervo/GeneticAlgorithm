package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.Collections;
import java.util.List;

public class Elitism implements Selection {

    @Override
    public List<? extends Chromosome> select(int amount, List<? extends Chromosome> population) {
        if (amount < 0 || amount > population.size()) throw new IllegalArgumentException();
        Collections.sort(population, (a, b) -> (int) (b.fitness() - a.fitness()));
        return population.subList(0, amount);
    }
}
