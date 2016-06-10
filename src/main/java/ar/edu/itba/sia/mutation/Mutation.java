package ar.edu.itba.sia.mutation;

import ar.edu.itba.sia.model.Warrior;

public abstract class Mutation {
    double mutationProbability;

    public Mutation(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public abstract void mutate(Warrior warrior);
}
