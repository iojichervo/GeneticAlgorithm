package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public interface Selection {

    List<Warrior> select(int amount, List<Warrior> population);
}
