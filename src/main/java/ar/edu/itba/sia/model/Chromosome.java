package ar.edu.itba.sia.model;

public interface Chromosome {

    int fitness();

    double relativeFitness();

    void setTotalFitness(double totalFitness);

    // Ranking selection methods
    void setRankingFitness(double newFitness);

    void resetRankingFitness();
}
