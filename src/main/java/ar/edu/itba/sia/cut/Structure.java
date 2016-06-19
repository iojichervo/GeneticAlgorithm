package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class Structure implements Cut {

    private double percentageNotChanging;
    private List<Warrior> lastGeneration;

    public Structure(double percentageNotChanging) {
        this.percentageNotChanging = percentageNotChanging;
    }

    public Structure() {
        this(0.8);
    }

    @Override
    public boolean cut(int generationNumber, List<Warrior> population) {
        if (lastGeneration == null) {
            lastGeneration = population;
            return false;
        }

        int n = population.size();
        double presents = 0;
        for (Warrior w : population) {
            if (lastGeneration.contains(w)) presents++;
            if (Double.compare(presents / n, percentageNotChanging) == 0) return true;
        }
        lastGeneration = population;
        return false;
    }
}
