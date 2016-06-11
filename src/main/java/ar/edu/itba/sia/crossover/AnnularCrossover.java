package ar.edu.itba.sia.crossover;

import ar.edu.itba.sia.model.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AnnularCrossover extends Crossover {

    private static final int ALLELES_NUMBER = 6;

    public AnnularCrossover(double crossoverProbability) {
        super(crossoverProbability);
    }

    public List<Warrior> cross(List<Warrior> parents) {
        List<Warrior> children = new LinkedList<>();
        Warrior child1, child2;

        Iterator<Warrior> it = parents.iterator();
        while (it.hasNext()) {
            child1 = it.next().duplicate();
            if (it.hasNext()) {
                child2 = it.next().duplicate();
            } else {
                break;
            }

            if (Math.random() < crossoverProbability) {
                Random random = new Random();
                int r = random.nextInt(6);
                switchAlleles(child1, child2, r);
                int l = random.nextInt(ALLELES_NUMBER / 2);
                while (l-- > 0) switchAlleles(child1, child2, ++r % ALLELES_NUMBER);
            }
            children.add(child1);
            children.add(child2);
        }

        return children;
    }

    private void switchAlleles(Warrior child1, Warrior child2, int alleleNumber) {
        switch (alleleNumber) {
            case 0:
                Height height1 = child1.getHeight();
                child1.setHeight(child2.getHeight());
                child2.setHeight(height1);
                break;
            case 1:
                Weapon weapon1 = child1.getWeapon();
                child1.setWeapon(child2.getWeapon());
                child2.setWeapon(weapon1);
                break;
            case 2:
                Boots boots1 = child1.getBoots();
                child1.setBoots(child2.getBoots());
                child2.setBoots(boots1);
                break;
            case 3:
                Helmet helmet1 = child1.getHelmet();
                child1.setHelmet(child2.getHelmet());
                child2.setHelmet(helmet1);
                break;
            case 4:
                Gloves gloves1 = child1.getGloves();
                child1.setGloves(child2.getGloves());
                child2.setGloves(gloves1);
                break;
            case 5:
                Cuirass cuirass1 = child1.getCuirass();
                child1.setCuirass(child2.getCuirass());
                child2.setCuirass(cuirass1);
                break;
            default:
                throw new UnknownError();
        }
    }
}
