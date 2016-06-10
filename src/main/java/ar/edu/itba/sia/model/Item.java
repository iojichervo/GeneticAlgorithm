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

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double getExpertise() {
        return expertise;
    }

    public void setExpertise(double expertise) {
        this.expertise = expertise;
    }

    public double getResistence() {
        return resistence;
    }

    public void setResistence(double resistence) {
        this.resistence = resistence;
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

    public void mutate() {
        id = (id + 1) % 200;
    }
}
