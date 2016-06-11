package ar.edu.itba.sia.model;

public class Warrior {

    // Constants
    private static final double STRENGTH_MODIFIER = 1.2;
    private static final double AGILITY_MODIFIER = 0.6;
    private static final double EXPERTISE_MODIFIER = 0.3;
    private static final double RESISTENCE_MODIFIER = 1.0;
    private static final double LIFE_MODIFIER = 0.9;

    // Equipment
    private Height height;
    private Weapon weapon;
    private Boots boots;
    private Helmet helmet;
    private Gloves gloves;
    private Cuirass cuirass;

    public Warrior(Height height, Weapon weapon, Boots boots, Helmet helmet, Gloves gloves, Cuirass cuirass) {
        this.height = height;
        this.weapon = weapon;
        this.boots = boots;
        this.helmet = helmet;
        this.gloves = gloves;
        this.cuirass = cuirass;
    }

    public double fitness() {
        return 0.6 * attack() + 0.4 * defense();
    }

    private double attack() {
        return (agility() + expertise()) * strength() * attackModifier();
    }

    private double defense() {
        return (resistence() + expertise()) * life() * defenseModifier();
    }

    private double strength() {
        double strengthItems = weapon.getStrength() + boots.getStrength() + helmet.getStrength() + gloves.getStrength()
                + cuirass.getStrength();
        return 100 * Math.tanh(0.01 * strengthItems * STRENGTH_MODIFIER);
    }

    private double agility() {
        double agilityItems = weapon.getAgility() + boots.getAgility() + helmet.getAgility() + gloves.getAgility()
                + cuirass.getAgility();
        return Math.tanh(0.01 * agilityItems * AGILITY_MODIFIER);
    }

    private double expertise() {
        double expertiseItems = weapon.getExpertise() + boots.getExpertise() + helmet.getExpertise()
                + gloves.getExpertise() + cuirass.getExpertise();
        return 0.6 * Math.tanh(0.01 * expertiseItems * EXPERTISE_MODIFIER);
    }

    private double resistence() {
        double resistenceItems = weapon.getResistence() + boots.getResistence() + helmet.getResistence()
                + gloves.getResistence() + cuirass.getResistence();
        return Math.tanh(0.01 * resistenceItems * RESISTENCE_MODIFIER);
    }

    private double life() {
        double lifeItems = weapon.getLife() + boots.getLife() + helmet.getLife()
                + gloves.getLife() + cuirass.getLife();
        return 100 * Math.tanh(0.01 * lifeItems * LIFE_MODIFIER);
    }

    private double attackModifier() {
        double h = height.getHeight();
        return 0.5 - Math.pow(3 * h - 5, 4) + Math.pow(3 * h - 5, 2) + (h / 2);
    }

    private double defenseModifier() {
        double h = height.getHeight();
        return 2 + Math.pow(3 * h - 5, 4) - Math.pow(3 * h - 5, 2) - (h / 2);
    }

    public Height getHeight() {
        return height;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Boots getBoots() {
        return boots;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public Gloves getGloves() {
        return gloves;
    }

    public Cuirass getCuirass() {
        return cuirass;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setGloves(Gloves gloves) {
        this.gloves = gloves;
    }

    public void setCuirass(Cuirass cuirass) {
        this.cuirass = cuirass;
    }

    public Warrior duplicate() {
        return new Warrior(height, weapon, boots, helmet, gloves, cuirass);
    }

    public double relativeFitness() {
        return 0;
    }

    public void setTotalFitness(double totalFitness) {

    }

    public void setRankingFitness(double newFitness) {

    }

    public void resetRankingFitness() {

    }

    @Override
    public String toString() {
        return "Warrior{" +
                "height=" + height +
                ", weapon=" + weapon.getId() +
                ", boots=" + boots.getId() +
                ", helmet=" + helmet.getId() +
                ", gloves=" + gloves.getId() +
                ", cuirass=" + cuirass.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warrior warrior = (Warrior) o;

        if (!height.equals(warrior.height)) return false;
        if (!weapon.equals(warrior.weapon)) return false;
        if (!boots.equals(warrior.boots)) return false;
        if (!helmet.equals(warrior.helmet)) return false;
        if (!gloves.equals(warrior.gloves)) return false;
        return cuirass.equals(warrior.cuirass);
    }

    @Override
    public int hashCode() {
        int result = height.hashCode();
        result = 31 * result + weapon.hashCode();
        result = 31 * result + boots.hashCode();
        result = 31 * result + helmet.hashCode();
        result = 31 * result + gloves.hashCode();
        result = 31 * result + cuirass.hashCode();
        return result;
    }
}
