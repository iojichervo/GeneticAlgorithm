package ar.edu.itba.sia.cut;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class MaxGeneration implements Cut {

    private int maxGeneration;

    public MaxGeneration(Integer maxGeneration) {
        this.maxGeneration = maxGeneration;
    }

    @Override
    public boolean cut(int generationNumber, List<Warrior> population) {
        return maxGeneration == generationNumber;
    }
}
