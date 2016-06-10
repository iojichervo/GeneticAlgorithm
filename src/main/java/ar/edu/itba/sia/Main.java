package ar.edu.itba.sia;

import ar.edu.itba.sia.model.Item;
import ar.edu.itba.sia.util.ItemsParser;
import ar.edu.itba.sia.util.ItemsStorage;

public class Main {

    public static void main(String args[]) {
        try {
            ItemsParser.parse();
            Item item = ItemsStorage.getWeapon().get(123);
            System.out.println(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
