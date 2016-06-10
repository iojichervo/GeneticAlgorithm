package ar.edu.itba.sia.model;

import java.util.concurrent.ThreadLocalRandom;

public class Height {
    private double height; // Between 1.3m and 2.0m

    public Height() {
        mutate();
    }

    public Height(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void mutate() {
        height = ThreadLocalRandom.current().nextDouble(1.3, 2);
    }
}
