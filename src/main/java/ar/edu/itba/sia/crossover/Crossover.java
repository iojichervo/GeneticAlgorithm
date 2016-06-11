package ar.edu.itba.sia.crossover;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public abstract class Crossover {
    double crossoverProbability;

    public Crossover(double crossoverProbability) {
        this.crossoverProbability = crossoverProbability;
    }

    // Receives parents, returns children
    public abstract List<Warrior> cross(List<Warrior> parents);
}
