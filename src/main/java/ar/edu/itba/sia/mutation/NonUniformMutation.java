package ar.edu.itba.sia.mutation;

import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.util.ItemsManager;

public class NonUniformMutation extends Mutation {

    public NonUniformMutation(double mutationProbability) {
        super(mutationProbability);
    }

    @Override
    public void mutate(Warrior warrior) {
        if (Math.random() > mutationProbability) {
            warrior.getHeight().mutate();
        }

        if (Math.random() > mutationProbability) {
            warrior.setWeapon(ItemsManager.randomWeapon());
        }

        if (Math.random() > mutationProbability) {
            warrior.setBoots(ItemsManager.randomBoots());
        }

        if (Math.random() > mutationProbability) {
            warrior.setHelmet(ItemsManager.randomHelmet());
        }

        if (Math.random() > mutationProbability) {
            warrior.setGloves(ItemsManager.randomGloves());
        }

        if (Math.random() > mutationProbability) {
            warrior.setCuirass(ItemsManager.randomCuirass());
        }
    }
}
