package ar.edu.itba.sia.util;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class FitnessCalculator {

    private static double fitness;

    public static void calculateTotalFitness(List<Warrior> warriors) {
        fitness = 0;
        warriors.stream().forEach(warrior -> fitness += warrior.fitness());
        Warrior.setTotalFitness(fitness);
    }
}
