package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public interface Cut {

    boolean cut(int generationNumber, List<Warrior> population);
}
