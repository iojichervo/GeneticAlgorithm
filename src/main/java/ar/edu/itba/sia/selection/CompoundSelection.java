package ar.edu.itba.sia.selection;

import ar.edu.itba.sia.model.Warrior;

import java.util.List;

public class CompoundSelection implements Selection {

    private double percentageFirstSelection;
    private Selection selection1;
    private Selection selection2;

    public CompoundSelection(double percentageFirstSelection, Selection selection1, Selection selection2) {
        if (percentageFirstSelection < 0 || percentageFirstSelection > 1) throw new IllegalArgumentException();
        this.percentageFirstSelection = percentageFirstSelection;
        this.selection1 = selection1;
        this.selection2 = selection2;
    }

    @Override
    public List<Warrior> select(int amount, List<Warrior> population) {
        int amount1 = (int) (amount * percentageFirstSelection);
        int amount2 = amount - amount1;
        List<Warrior> warriors1 = selection1.select(amount1, population);
        List<Warrior> warriors2 = selection2.select(amount2, population);
        warriors1.addAll(warriors2);
        return warriors1;
    }
}
