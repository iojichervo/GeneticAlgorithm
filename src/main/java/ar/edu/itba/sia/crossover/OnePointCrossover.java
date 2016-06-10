package ar.edu.itba.sia.crossover;

import ar.edu.itba.sia.model.*;

import java.util.Random;

public class OnePointCrossover extends Crossover {

    public void cross(Warrior w1, Warrior w2) {
        Random r = new Random();
        switch (r.nextInt(6)) {
            case 0:
                Height height1 = w1.getHeight();
                w1.setHeight(w2.getHeight());
                w2.setHeight(height1);
            case 1:
                Weapon weapon1 = w1.getWeapon();
                w1.setWeapon(w2.getWeapon());
                w2.setWeapon(weapon1);
            case 2:
                Boots boots1 = w1.getBoots();
                w1.setBoots(w2.getBoots());
                w2.setBoots(boots1);
            case 3:
                Helmet helmet1 = w1.getHelmet();
                w1.setHelmet(w2.getHelmet());
                w2.setHelmet(helmet1);
            case 4:
                Gloves gloves1 = w1.getGloves();
                w1.setGloves(w2.getGloves());
                w2.setGloves(gloves1);
            case 5:
                Cuirass cuirass1 = w1.getCuirass();
                w1.setCuirass(w2.getCuirass());
                w2.setCuirass(cuirass1);
            default:
                throw new UnknownError();
        }
    }
}
