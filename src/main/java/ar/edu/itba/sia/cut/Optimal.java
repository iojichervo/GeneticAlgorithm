package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class Optimal implements Cut {

    private double optimal;

    public Optimal(Double optimal) {
        this.optimal = optimal;
    }

    @Override
    public boolean cut(int generationNumber, List<Warrior> population) {
        Warrior w = population.stream().max((a, b) -> Double.compare(a.fitness(), b.fitness())).get();
        double bestFitness = w.fitness();
        System.out.println(bestFitness + " - " + optimal);
        return bestFitness >= optimal;
    }
}
