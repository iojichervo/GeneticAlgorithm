package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.LinkedList;
import java.util.List;

public class Structure implements Cut {

    private double percentageNotChanging;
    private List<Warrior> lastGeneration;

    public Structure(Double percentageNotChanging) {
        this.percentageNotChanging = percentageNotChanging;
    }

    public Structure() {
        this(0.8);
    }

    @Override
    public boolean cut(int generationNumber, List<Warrior> population) {
        if (lastGeneration == null) {
            lastGeneration = duplicateList(population);
            return false;
        }

        int n = population.size();
        double presents = 0;
        for (Warrior w : population) {
            if (lastGeneration.contains(w)) presents++;
            if (Double.compare(presents / n, percentageNotChanging) >= 0) return true;
        }
        lastGeneration = duplicateList(population);
        return false;
    }

    private List<Warrior> duplicateList(List<Warrior> warriors) {
        List<Warrior> dup = new LinkedList<>();
        warriors.stream().forEach(w -> dup.add(w.duplicate()));
        return dup;
    }
}
