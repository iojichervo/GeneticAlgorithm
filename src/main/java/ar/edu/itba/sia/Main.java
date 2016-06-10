package ar.edu.itba.sia;

import ar.edu.itba.sia.util.ItemsParser;

public class Main {

    public static void main(String args[]) {
        try {
            ItemsParser.parse();
            GeneticAlgorithm.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
