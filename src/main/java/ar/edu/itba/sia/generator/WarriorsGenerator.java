package ar.edu.itba.sia.generator;

import ar.edu.itba.sia.model.Height;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.util.FitnessCalculator;
import ar.edu.itba.sia.util.ItemsManager;

import java.util.LinkedList;
import java.util.List;

public class WarriorsGenerator {

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
}
