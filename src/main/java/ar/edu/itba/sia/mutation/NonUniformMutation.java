package ar.edu.itba.sia.mutation;

import ar.edu.itba.sia.model.Warrior;

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
            warrior.getWeapon().mutate();
        }

        if (Math.random() > mutationProbability) {
            warrior.getBoots().mutate();
        }

        if (Math.random() > mutationProbability) {
            warrior.getHelmet().mutate();
        }

        if (Math.random() > mutationProbability) {
            warrior.getGloves().mutate();
        }

        if (Math.random() > mutationProbability) {
            warrior.getCuirass().mutate();
        }
    }
}
