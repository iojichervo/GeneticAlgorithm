package ar.edu.itba.sia.model;

public interface Chromosome {

    int fitness();

    double relativeFitness();

    void setRankingFitness(float newFitness);

    void resetRankingFitness();
}
