package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomSelection implements Selection {

    @Override
    public List<Warrior> select(int amount, List<Warrior> population) {
        Collections.shuffle(population);
        List<Warrior> selected = new LinkedList<>();
        selected.addAll(population.subList(0, amount));
        return selected;
    }
}
