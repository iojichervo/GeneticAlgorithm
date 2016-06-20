package ar.edu.itba.sia;

import ar.edu.itba.sia.model.Height;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.selection.*;
import ar.edu.itba.sia.util.WarriorsUtils;
import ar.edu.itba.sia.util.ItemsManager;
import ar.edu.itba.sia.util.ItemsParser;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class SelectionTest extends TestCase {

    private Warrior x1; // Fitness: 10.10272683875461
    private Warrior x2; // Fitness: 8.708314153297573
    private Warrior x3; // Fitness: 9.976216888091912
    private Warrior x4; // Fitness: 8.597078833225423
    private Warrior x5; // Fitness: 7.858370937695706
    private List<Warrior> population;

    private void init() {
        try {
            ItemsParser.parse();
            x1 = new Warrior(new Height(1.610005824275423), ItemsManager.getWeapon(121), ItemsManager.getBoots(15),
                    ItemsManager.getHelmet(180), ItemsManager.getGloves(97), ItemsManager.getCuirass(166));
            x2 = new Warrior(new Height(1.3502598023670913), ItemsManager.getWeapon(159), ItemsManager.getBoots(102),
                    ItemsManager.getHelmet(13), ItemsManager.getGloves(173), ItemsManager.getCuirass(55));
            x3 = new Warrior(new Height(1.6792806060324772), ItemsManager.getWeapon(132), ItemsManager.getBoots(16),
                    ItemsManager.getHelmet(72), ItemsManager.getGloves(126), ItemsManager.getCuirass(19));
            x4 = new Warrior(new Height(1.9392411684605464), ItemsManager.getWeapon(50), ItemsManager.getBoots(99),
                    ItemsManager.getHelmet(189), ItemsManager.getGloves(92), ItemsManager.getCuirass(199));
            x5 = new Warrior(new Height(1.3054678973296516), ItemsManager.getWeapon(76), ItemsManager.getBoots(52),
                    ItemsManager.getHelmet(153), ItemsManager.getGloves(104), ItemsManager.getCuirass(106));
            population = new LinkedList<>();
            population.add(x1);
            population.add(x2);
            population.add(x3);
            population.add(x4);
            population.add(x5);
            WarriorsUtils.calculateTotalFitness(population);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testElitism() {
        init();
        Selection selection = new Elitism();
        population = selection.select(2, population);
        assertTrue(population.size() == 2);
        assertTrue(population.contains(x1));
        assertFalse(population.contains(x2));
        assertTrue(population.contains(x3));
        assertFalse(population.contains(x4));
        assertFalse(population.contains(x5));
    }

    public void testRoulette() {
        init();
        Selection selection = new Roulette();
        population = selection.select(2, population);
        assertTrue(population.size() == 2);
        System.out.println(population);
    }

    public void testUniversal() {
        init();
        Selection selection = new Universal();
        population = selection.select(2, population);
        assertTrue(population.size() == 2);
        System.out.println(population);
    }

    public void testDeterministicTournament() {
        init();
        Selection selection = new DeterministicTournament();
        population = selection.select(2, population);
        assertTrue(population.size() == 2);
        System.out.println(population);
    }

    public void testProbabilisticTournament() {
        init();
        Selection selection = new ProbabilisticTournament();
        population = selection.select(2, population);
        assertTrue(population.size() == 2);
        System.out.println(population);
    }

    public void testRank() {
        init();
        Selection selection = new Rank();
        population = selection.select(2, population);
        System.out.println(population);
        assertTrue(population.size() == 2);
    }

    public void testBoltzmann() {
        init();
        Selection selection = new Boltzmann(50.0);
        population = selection.select(2, population);
        System.out.println(population);
        assertTrue(population.size() == 2);
    }
}
