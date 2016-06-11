package ar.edu.itba.sia.crossover;

import ar.edu.itba.sia.model.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoPointsCrossover extends Crossover {

    public TwoPointsCrossover(double crossoverProbability) {
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
                Random r = new Random();
                int low = r.nextInt(6);
                int high;
                do {
                    high = r.nextInt(6);
                } while (high == low);
                if (low > high) {
                    int aux = high;
                    high = low;
                    low = aux;
                }

                switch (low) {
                    case 0:
                        Height height1 = child1.getHeight();
                        child1.setHeight(child2.getHeight());
                        child2.setHeight(height1);
                        if (high == 0) break;
                    case 1:
                        Weapon weapon1 = child1.getWeapon();
                        child1.setWeapon(child2.getWeapon());
                        child2.setWeapon(weapon1);
                        if (high == 1) break;
                    case 2:
                        Boots boots1 = child1.getBoots();
                        child1.setBoots(child2.getBoots());
                        child2.setBoots(boots1);
                        if (high == 2) break;
                    case 3:
                        Helmet helmet1 = child1.getHelmet();
                        child1.setHelmet(child2.getHelmet());
                        child2.setHelmet(helmet1);
                        if (high == 3) break;
                    case 4:
                        Gloves gloves1 = child1.getGloves();
                        child1.setGloves(child2.getGloves());
                        child2.setGloves(gloves1);
                        if (high == 4) break;
                    case 5:
                        Cuirass cuirass1 = child1.getCuirass();
                        child1.setCuirass(child2.getCuirass());
                        child2.setCuirass(cuirass1);
                        break;
                    default:
                        throw new UnknownError();
                }
            }

            children.add(child1);
            children.add(child2);
        }

        return children;
    }
}
