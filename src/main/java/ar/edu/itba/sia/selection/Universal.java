package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Universal implements Selection {

    double accumulatedFitness = 0;

    @Override
    public List<Chromosome> select(int k, List<Chromosome> population) {
        List<Chromosome> selected = new LinkedList<>();
        double r = Math.random();
        int j = 0;
        while (j++ < k) {
            double random = (r + j - 1) / k;
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
