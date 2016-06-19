package ar.edu.itba.sia;

import ar.edu.itba.sia.crossover.*;
import ar.edu.itba.sia.model.Height;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.util.ItemsManager;
import ar.edu.itba.sia.util.ItemsParser;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class CrossoverTest extends TestCase {

    private Warrior x1; // Fitness: 10.10272683875461
    private Warrior x2; // Fitness: 8.708314153297573
    private List<Warrior> parents;

    private void init() {
        try {
            ItemsParser.parse();
            x1 = new Warrior(new Height(1.610005824275423), ItemsManager.getWeapon(121), ItemsManager.getBoots(15),
                    ItemsManager.getHelmet(180), ItemsManager.getGloves(97), ItemsManager.getCuirass(166));
            x2 = new Warrior(new Height(1.3502598023670913), ItemsManager.getWeapon(159), ItemsManager.getBoots(102),
                    ItemsManager.getHelmet(13), ItemsManager.getGloves(173), ItemsManager.getCuirass(55));
            parents = new LinkedList<>();
            parents.add(x1);
            parents.add(x2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testOnePointCrossover() {
        init();
        Crossover crossover = new OnePointCrossover(0.0);
        List<Warrior> children = crossover.cross(parents);
        assertTrue(children.containsAll(parents));

        crossover = new OnePointCrossover(1.0);
        children = crossover.cross(parents);
        System.out.println(parents);
        System.out.println();
        System.out.println(children);
        assertFalse(children.contains(x1));
        assertFalse(children.contains(x2));
    }

    public void testTwoPointsCrossover() {
        init();
        Crossover crossover = new TwoPointsCrossover(0.0);
        List<Warrior> children = crossover.cross(parents);
        assertTrue(children.containsAll(parents));

        crossover = new TwoPointsCrossover(1.0);
        children = crossover.cross(parents);
        System.out.println(parents);
        System.out.println();
        System.out.println(children);
        assertFalse(children.contains(x1));
        assertFalse(children.contains(x2));
    }

    public void testAnnularCrossover() {
        init();
        Crossover crossover = new AnnularCrossover(0.0);
        List<Warrior> children = crossover.cross(parents);
        assertTrue(children.containsAll(parents));

        crossover = new TwoPointsCrossover(1.0);
        children = crossover.cross(parents);
        System.out.println(parents);
        System.out.println();
        System.out.println(children);
        assertFalse(children.contains(x1));
        assertFalse(children.contains(x2));
    }

    public void testUniformCrossover() {
        init();
        Crossover crossover = new UniformCrossover(0.0);
        List<Warrior> children = crossover.cross(parents);
        assertTrue(children.containsAll(parents));

        crossover = new TwoPointsCrossover(1.0);
        children = crossover.cross(parents);
        System.out.println(parents);
        System.out.println();
        System.out.println(children);
    }
}
