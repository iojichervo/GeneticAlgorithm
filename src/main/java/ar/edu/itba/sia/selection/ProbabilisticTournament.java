package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Chromosome;

import java.util.LinkedList;
import java.util.List;

public class ProbabilisticTournament implements Selection {

    @Override
    public List<? extends Chromosome> select(int k, List<? extends Chromosome> population) {
        List<Chromosome> selected = new LinkedList<>();
        while (k-- > 0) {
            RandomSelection randomSelection = new RandomSelection();
            List<Chromosome> tournament = (List<Chromosome>) randomSelection.select(2, population);

            Chromosome highFitness = tournament.stream().max((a, b) ->(int) (b.fitness() - a.fitness())).get();
            Chromosome lowFitness = tournament.stream().min((a, b) -> (int) (b.fitness() - a.fitness())).get();

            Chromosome champion = Math.random() < 0.75 ? highFitness : lowFitness;
            selected.add(champion);
        }
        return selected;
    }
}
