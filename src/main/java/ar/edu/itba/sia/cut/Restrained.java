package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class Restrained implements Cut {

    private double bestFitnessLastGeneration;
    private int generationsWithBestFitness;
    private int generationsWithBestFitnessGoal;

    public Restrained(Integer generationsWithBestFitnessGoal) {
        this.generationsWithBestFitnessGoal = generationsWithBestFitnessGoal;
    }

    @Override
    public boolean cut(int generationNumber, List<Warrior> population) {
        if (bestFitnessLastGeneration == 0) {
            Warrior w = population.stream().max((a, b) -> Double.compare(b.fitness(), a.fitness())).get();
            bestFitnessLastGeneration = w.fitness();
            generationsWithBestFitness = 0;
            return false;
        }

        Warrior w = population.stream().max((a, b) -> Double.compare(b.fitness(), a.fitness())).get();
        double bestFitness = w.fitness();
        if (Double.compare(bestFitness, bestFitnessLastGeneration) == 0) {
            if (++generationsWithBestFitness == generationsWithBestFitnessGoal) return true;
        }
        if (bestFitness > bestFitnessLastGeneration) {
            bestFitnessLastGeneration = bestFitness;
            generationsWithBestFitness = 0;
        }
        return false;
    }
}
