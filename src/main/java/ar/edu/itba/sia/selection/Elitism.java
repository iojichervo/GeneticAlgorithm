package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.Collections;
import java.util.List;

public class Elitism implements Selection {

    @Override
    public List<Warrior> select(int amount, List<Warrior> population) {
        if (amount < 0 || amount > population.size()) throw new IllegalArgumentException();
        Collections.sort(population, (a, b) -> Double.compare(b.fitness(), a.fitness()));
        return population.subList(0, amount);
    }
}
