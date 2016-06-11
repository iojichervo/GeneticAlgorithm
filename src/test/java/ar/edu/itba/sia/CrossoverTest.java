package ar.edu.itba.sia;

import ar.edu.itba.sia.model.Height;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.util.ItemsManager;
import ar.edu.itba.sia.util.ItemsParser;
import junit.framework.TestCase;

public class CrossoverTest extends TestCase {

    private Warrior x1; // Fitness: 10.10272683875461
    private Warrior x2; // Fitness: 8.708314153297573

    private void init() {
        try {
            ItemsParser.parse();
            x1 = new Warrior(new Height(1.610005824275423), ItemsManager.getWeapon(121), ItemsManager.getBoots(15),
                    ItemsManager.getHelmet(180), ItemsManager.getGloves(97), ItemsManager.getCuirass(166));
            x2 = new Warrior(new Height(1.3502598023670913), ItemsManager.getWeapon(159), ItemsManager.getBoots(102),
                    ItemsManager.getHelmet(13), ItemsManager.getGloves(173), ItemsManager.getCuirass(55));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testOnePointCrossover() {
        init();
    }
}
