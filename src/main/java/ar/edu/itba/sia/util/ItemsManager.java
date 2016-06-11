package ar.edu.itba.sia.util;

import ar.edu.itba.sia.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ItemsManager {
    private static final int ITEMS_AMOUNT = 200;
    private static Map<Integer, Item> weapon = new HashMap<>();
    private static Map<Integer, Item> boots = new HashMap<>();
    private static Map<Integer, Item> helmet = new HashMap<>();
    private static Map<Integer, Item> gloves = new HashMap<>();
    private static Map<Integer, Item> cuirass = new HashMap<>();

    public static Map<Integer, Item> getWeapon() {
        return weapon;
    }

    public static Map<Integer, Item> getBoots() {
        return boots;
    }

    public static Map<Integer, Item> getHelmet() {
        return helmet;
    }

    public static Map<Integer, Item> getGloves() {
        return gloves;
    }

    public static Map<Integer, Item> getCuirass() {
        return cuirass;
    }

    public static Weapon randomWeapon() {
        return (Weapon) weapon.get(new Random().nextInt(ITEMS_AMOUNT));
    }

    public static Boots randomBoots() {
        return (Boots) boots.get(new Random().nextInt(ITEMS_AMOUNT));
    }

    public static Helmet randomHelmet() {
        return (Helmet) helmet.get(new Random().nextInt(ITEMS_AMOUNT));
    }

    public static Gloves randomGloves() {
        return (Gloves) gloves.get(new Random().nextInt(ITEMS_AMOUNT));
    }

    public static Cuirass randomCuirass() {
        return (Cuirass) cuirass.get(new Random().nextInt(ITEMS_AMOUNT));
    }

    public static Weapon getWeapon(int i) {
        return (Weapon) weapon.get(i);
    }

    public static Boots getBoots(int i) {
        return (Boots) boots.get(i);
    }

    public static Helmet getHelmet(int i) {
        return (Helmet) helmet.get(i);
    }

    public static Gloves getGloves(int i) {
        return (Gloves) gloves.get(i);
    }

    public static Cuirass getCuirass(int i) {
        return (Cuirass) cuirass.get(i);
    }
}
