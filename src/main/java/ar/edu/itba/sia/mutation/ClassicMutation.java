package ar.edu.itba.sia.mutation;

import ar.edu.itba.sia.model.Warrior;

import java.util.Random;

public class ClassicMutation extends Mutation {

    public ClassicMutation(double mutationProbability) {
        super(mutationProbability);
    }

    @Override
    public void mutate(Warrior warrior) {
        if (Math.random() > mutationProbability) {
            Random r = new Random();
            switch (r.nextInt(6)) {
                case 0:
                    warrior.getHeight().mutate();
                    break;
                case 1:
                    warrior.getWeapon().mutate();
                    break;
                case 2:
                    warrior.getBoots().mutate();
                    break;
                case 3:
                    warrior.getHelmet().mutate();
                    break;
                case 4:
                    warrior.getGloves().mutate();
                    break;
                case 5:
                    warrior.getCuirass().mutate();
                    break;
                default:
                    throw new UnknownError();
            }
        }
    }
}
