package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class Restrained implements Cut {

    private double bestFitnessLastGeneration;

    @Override
    public boolean cut(int generationNumber, List<Warrior> population) {
        if (bestFitnessLastGeneration == 0) {
            Warrior w = population.stream().max((a, b) -> Double.compare(b.fitness(), a.fitness())).get();
            bestFitnessLastGeneration = w.fitness();
            return false;
        }

        Warrior w = population.stream().max((a, b) -> Double.compare(b.fitness(), a.fitness())).get();
        double bestFitness = w.fitness();
        if (Double.compare(bestFitness, bestFitnessLastGeneration) == 0) return true;
        if (bestFitness > bestFitnessLastGeneration) bestFitnessLastGeneration = bestFitness;
        return false;
    }
}
