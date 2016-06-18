package ar.edu.itba.sia;

import ar.edu.itba.sia.model.Height;
import ar.edu.itba.sia.model.Warrior;
import ar.edu.itba.sia.mutation.ClassicMutation;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.mutation.NonUniformMutation;
import ar.edu.itba.sia.util.ItemsManager;
import ar.edu.itba.sia.util.ItemsParser;
import junit.framework.TestCase;

public class MutationTest extends TestCase {

    private Warrior x1; // Fitness: 10.10272683875461

    private void init() {
        try {
            ItemsParser.parse();
            x1 = new Warrior(new Height(1.610005824275423), ItemsManager.getWeapon(121), ItemsManager.getBoots(15),
                    ItemsManager.getHelmet(180), ItemsManager.getGloves(97), ItemsManager.getCuirass(166));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testClassicMutation() {
        init();
        Mutation mutation = new ClassicMutation(0);
        Warrior copy = x1.duplicate();
        mutation.mutate(copy);
        System.out.println(copy);
        assertTrue(copy.equals(x1));

        mutation = new ClassicMutation(1);
        mutation.mutate(copy);
        System.out.println(copy);
        assertFalse(copy.equals(x1));
    }

    public void testNonUniformMutation() {
        init();
        Mutation mutation = new NonUniformMutation(0);
        Warrior copy = x1.duplicate();
        mutation.mutate(copy);
        System.out.println(copy);
        assertTrue(copy.equals(x1));

        mutation = new NonUniformMutation(1);
        mutation.mutate(copy);
        System.out.println(copy);
        assertFalse(copy.equals(x1));
    }
}
