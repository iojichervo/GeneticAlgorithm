package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Boltzmann implements Selection {

    private double accumulatedFitness = 0;
    private double denominator = 0;
    private double temperature;

    public Boltzmann(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public List<Warrior> select(int k, List<Warrior> population) {
        denominator = 0;
        population.stream().forEach(w -> denominator += Math.exp(w.fitness() / temperature));
        population.stream().forEach(w -> w.setRelativeFitness(
                Math.exp(w.fitness() / temperature) / denominator)); // Assign new fitness

        List<Warrior> selected = new LinkedList<>();
        while (k-- > 0) {
            double random = Math.random();
            accumulatedFitness = 0;
            Optional<Warrior> c = population.stream()
                    .peek(chrom -> accumulatedFitness += chrom.relativeFitness())
                    .filter(chrom -> accumulatedFitness >= random)
                    .findFirst();
            if (c.isPresent()) selected.add(c.get());
        }

        selected.stream().forEach(c -> c.resetRelativeFitness());
        if (temperature > 1) temperature--;
        return selected;
    }

}
