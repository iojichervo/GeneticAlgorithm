package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Roulette implements Selection {

    double accumulatedFitness = 0;

    @Override
    public List<Chromosome> select(int k, List<Chromosome> population) {
        List<Chromosome> selected = new LinkedList<>();
        while (k-- > 0) {
            double random = Math.random();
            accumulatedFitness = 0;
            Optional<Chromosome> c = population.stream()
                    .peek(chrom -> accumulatedFitness += chrom.relativeFitness())
                    .filter(chrom -> accumulatedFitness >= random)
                    .findFirst();
            if (c.isPresent()) selected.add(c.get());
        }
        return selected;
    }
}
