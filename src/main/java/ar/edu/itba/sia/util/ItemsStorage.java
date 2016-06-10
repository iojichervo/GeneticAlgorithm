package ar.edu.itba.sia.util;

import ar.edu.itba.sia.model.*;

import java.util.HashMap;
import java.util.Map;

public class ItemsStorage {
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
}
