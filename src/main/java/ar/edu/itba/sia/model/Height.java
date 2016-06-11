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

    @Override
    public String toString() {
        return String.valueOf(height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Height height1 = (Height) o;

        return Double.compare(height1.height, height) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(height);
        return (int) (temp ^ (temp >>> 32));
    }
}
