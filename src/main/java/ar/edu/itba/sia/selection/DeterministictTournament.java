package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.*;
import java.util.Random;

public class DeterministictTournament implements Selection {

    @Override
    public List<Chromosome> select(int k, List<Chromosome> population) {
        Random random = new Random();
        PrimitiveIterator.OfInt iterator = random.ints(2, 4).iterator();

        List<Chromosome> selected = new LinkedList<>();
        while (k-- > 0) {
            int m = iterator.nextInt();
            RandomSelection randomSelection = new RandomSelection();
            List<Chromosome> tournament = randomSelection.select(m, population);
            Chromosome champion = tournament.stream().max((a, b) -> b.fitness() - a.fitness()).get();
            selected.add(champion);
        }
        return selected;
    }
}
