package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.LinkedList;
import java.util.List;

public class Roulette implements Selection {

    double accumulatedFitness = 0;

    @Override
    public List<Chromosome> select(int k, List<Chromosome> population) {
        List<Chromosome> selected = new LinkedList<>();
        while (k-- > 0) {
            double random = Math.random();
            Chromosome c = population.stream()
                    .peek(chrom -> accumulatedFitness += chrom.relativeFitness())
                    .filter(chrom -> accumulatedFitness >= random)
                    .findFirst()
                    .get();
            selected.add(c);
        }
        return selected;
    }
}
