package ar.edu.itba.sia.model;

public abstract class Item {
    private int id;
    private double strength;
    private double agility;
    private double expertise;
    private double resistence;
    private double life;

    public Item(Integer id, Double strength, Double agility, Double expertise, Double resistence, Double life) {
        this.id = id;
        this.strength = strength;
        this.agility = agility;
        this.expertise = expertise;
        this.resistence = resistence;
        this.life = life;
    }

    public double getStrength() {
        return strength;
    }

    public double getAgility() {
        return agility;
    }

    public double getLife() {
        return life;
    }

    public double getExpertise() {
        return expertise;
    }

    public double getResistence() {
        return resistence;
    }

    @Override
    public String toString() {
        return getClass() + "{" +
                "id=" + id +
                ", strength=" + strength +
                ", agility=" + agility +
                ", expertise=" + expertise +
                ", resistence=" + resistence +
                ", life=" + life +
                '}';
    }

}
