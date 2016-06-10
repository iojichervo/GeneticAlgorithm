package ar.edu.itba.sia.model;

public class Warrior implements Chromosome {

    private static final double STRENGTH_MODIFIER = 1.2;
    private static final double AGILITY_MODIFIER = 0.6;
    private static final double EXPERTISE_MODIFIER = 0.3;
    private static final double RESISTENCE_MODIFIER = 1.0;
    private static final double LIFE_MODIFIER = 0.9;

    private Height height;
    private Weapon weapon;
    private Boots boots;
    private Helmet helmet;
    private Gloves gloves;
    private Cuirass cuirass;

    @Override
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
        return 100 * Math.tanh(0.01 * lifeItems * LIFE_MODIFIER );
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

    @Override
    public double relativeFitness() {
        return 0;
    }

    @Override
    public void setTotalFitness(double totalFitness) {

    }

    @Override
    public void setRankingFitness(double newFitness) {

    }

    @Override
    public void resetRankingFitness() {

    }
}
