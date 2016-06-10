package ar.edu.itba.sia.util;

import ar.edu.itba.sia.model.Item;
import ar.edu.itba.sia.model.Weapon;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class ItemsParser {

    public static void parse() throws InvocationTargetException, FileNotFoundException,
            InstantiationException, IllegalAccessException, NoSuchMethodException {
        parse("weapon.tsv", Weapon.class, ItemsManager.getWeapon());
        parse("boots.tsv", Weapon.class, ItemsManager.getBoots());
        parse("helmet.tsv", Weapon.class, ItemsManager.getHelmet());
        parse("gloves.tsv", Weapon.class, ItemsManager.getGloves());
        parse("cuirass.tsv", Weapon.class, ItemsManager.getCuirass());
    }

    public static void parse(String filename, Class<? extends Item> itemClass, Map<Integer, Item> map)
            throws FileNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        File file = new File("src/main/resources/" + filename);
        Scanner input = new Scanner(file);

        input.nextLine(); // Skip headers
        while (input.hasNext()) {
            int id = Integer.valueOf(input.next());
            double strength = Double.valueOf(input.next());
            double agility = Double.valueOf(input.next());
            double expertise = Double.valueOf(input.next());
            double resistence = Double.valueOf(input.next());
            double life = Double.valueOf(input.next());
            Item item = itemClass.getConstructor(Integer.class, Double.class, Double.class, Double.class, Double.class,
                    Double.class).newInstance(id, strength, agility, expertise, resistence, life);
            map.put(id, item);
            input.nextLine();
        }
        input.close();
    }
}
