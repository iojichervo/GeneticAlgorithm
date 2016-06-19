package ar.edu.itba.sia.mutation;

import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.util.ItemsManager;

import java.util.Random;

public class ClassicMutation extends Mutation {

    public ClassicMutation(Double mutationProbability) {
        super(mutationProbability);
    }

    @Override
    public void mutate(Warrior warrior) {
        if (Math.random() < mutationProbability) {
            Random r = new Random();
            switch (r.nextInt(6)) {
                case 0:
                    warrior.getHeight().mutate();
                    break;
                case 1:
                    warrior.setWeapon(ItemsManager.randomWeapon());
                    break;
                case 2:
                    warrior.setBoots(ItemsManager.randomBoots());
                    break;
                case 3:
                    warrior.setHelmet(ItemsManager.randomHelmet());
                    break;
                case 4:
                    warrior.setGloves(ItemsManager.randomGloves());
                    break;
                case 5:
                    warrior.setCuirass(ItemsManager.randomCuirass());
                    break;
                default:
                    throw new UnknownError();
            }
        }
    }
}
