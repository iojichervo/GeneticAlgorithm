package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.LinkedList;
import java.util.List;

public class ProbabilisticTournament implements Selection {

    @Override
    public List<Warrior> select(int k, List<Warrior> population) {
        List<Warrior> selected = new LinkedList<>();
        while (k-- > 0) {
            RandomSelection randomSelection = new RandomSelection();
            List<Warrior> tournament = randomSelection.select(2, population);

            Warrior highFitness = tournament.stream().max((a, b) -> (int) (b.fitness() - a.fitness())).get();
            Warrior lowFitness = tournament.stream().min((a, b) -> (int) (b.fitness() - a.fitness())).get();

            Warrior champion = Math.random() < 0.75 ? highFitness : lowFitness;
            selected.add(champion);
        }
        return selected;
    }
}
