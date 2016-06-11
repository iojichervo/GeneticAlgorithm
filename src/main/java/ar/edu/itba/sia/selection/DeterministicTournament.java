package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.*;
import java.util.Random;

public class DeterministicTournament implements Selection {

    @Override
    public List<Warrior> select(int k, List<Warrior> population) {
        Random random = new Random();
        PrimitiveIterator.OfInt iterator = random.ints(2, 4).iterator();

        List<Warrior> selected = new LinkedList<>();
        while (k-- > 0) {
            int m = iterator.nextInt();
            RandomSelection randomSelection = new RandomSelection();
            List<Warrior> tournament = randomSelection.select(m, population);
            Warrior champion = tournament.stream().max((a, b) -> (int) (b.fitness() - a.fitness())).get();
            selected.add(champion);
        }
        return selected;
    }
}
