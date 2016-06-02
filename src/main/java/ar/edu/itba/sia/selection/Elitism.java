package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.Collections;
import java.util.List;

public class Elitism implements Selection {

    @Override
    public List<Chromosome> select(int amount, List<Chromosome> population) {
        Collections.sort(population, (a, b) -> a.fitness() - b.fitness());
        return population.subList(0, amount);
    }
}
