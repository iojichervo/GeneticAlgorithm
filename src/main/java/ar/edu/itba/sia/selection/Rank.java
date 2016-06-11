package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.Collections;
import java.util.List;

public class Rank implements Selection {

    private int i;

    @Override
    public List<Warrior> select(int amount, List<Warrior> population) {
        if (amount < 0 || amount > population.size()) throw new IllegalArgumentException();
        Collections.sort(population, (a, b) -> (int) (a.fitness() - b.fitness())); // Order by fitness, worst to best

        i = 1;
        float populationSize = population.size();
        population.stream().forEach(c -> c.setRankingFitness(i++ / populationSize)); // Assign new fitness

        Roulette roulette = new Roulette();
        List<Warrior> result = roulette.select(amount, population);
        result.stream().forEach(c -> c.resetRankingFitness());
        return result;
    }
}
