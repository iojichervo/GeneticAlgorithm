package ar.edu.itba.sia.util;

import ar.edu.itba.sia.model.Height;
import ar.edu.itba.sia.model.Warrior;

import java.util.LinkedList;
import java.util.List;

public class WarriorsUtils {

    private static double fitness;

    public static void calculateTotalFitness(List<Warrior> warriors) {
        fitness = 0;
        warriors.stream().forEach(warrior -> fitness += warrior.fitness());
        Warrior.setTotalFitness(fitness);
    }

    public static List<Warrior> generateWarriors(int amount) {
        List<Warrior> warriors = new LinkedList<>();
        double totalFitness = 0;
        while (amount-- > 0) {
            Warrior warrior = new Warrior(new Height(), ItemsManager.randomWeapon(), ItemsManager.randomBoots(),
                    ItemsManager.randomHelmet(), ItemsManager.randomGloves(), ItemsManager.randomCuirass());
            warriors.add(warrior);
            totalFitness += warrior.fitness();
        }
        Warrior.setTotalFitness(totalFitness);
        return warriors;
    }

    public static double averageFitness(List<Warrior> warriors) {
        return Warrior.getTotalFitness() / warriors.size();
    }

    public static double bestFitness(List<Warrior> warriors) {
        return warriors.stream().max((a, b) -> Double.compare(a.fitness(), b.fitness())).get().fitness();
    }

    public static double worstFitness(List<Warrior> warriors) {
        return warriors.stream().min((a, b) -> Double.compare(a.fitness(), b.fitness())).get().fitness();
    }
}
