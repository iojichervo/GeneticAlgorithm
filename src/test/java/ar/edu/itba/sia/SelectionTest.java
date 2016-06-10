package ar.edu.itba.sia;

import ar.edu.itba.sia.model.Chromosome;
import ar.edu.itba.sia.selection.*;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class SelectionTest extends TestCase {

    public void testElitism() {
        IntegerChromosome x1 = new IntegerChromosome(3);
        IntegerChromosome x2 = new IntegerChromosome(6);
        IntegerChromosome x3 = new IntegerChromosome(11);
        IntegerChromosome x4 = new IntegerChromosome(14);
        IntegerChromosome x5 = new IntegerChromosome(1);
        List<Chromosome> population = new LinkedList<>();
        population.add(x1);
        population.add(x2);
        population.add(x3);
        population.add(x4);
        population.add(x5);

        Selection selection = new Elitism();
        population = (List<Chromosome>) selection.select(2, population);
        assertTrue(population.size() == 2);
        assertFalse(population.contains(x1));
        assertFalse(population.contains(x2));
        assertTrue(population.contains(x3));
        assertTrue(population.contains(x4));
        assertFalse(population.contains(x5));
    }

    public void testRoulette() {
        IntegerChromosome x1 = new IntegerChromosome(3);
        IntegerChromosome x2 = new IntegerChromosome(6);
        IntegerChromosome x3 = new IntegerChromosome(11);
        IntegerChromosome x4 = new IntegerChromosome(14);
        IntegerChromosome x5 = new IntegerChromosome(1);
        List<Chromosome> population = new LinkedList<>();
        population.add(x1);
        population.add(x2);
        population.add(x3);
        population.add(x4);
        population.add(x5);

        Selection selection = new Roulette();
        population = (List<Chromosome>) selection.select(3, population);
        assertTrue(population.size() == 3);
    }

    public void testUniversal() {
        IntegerChromosome x1 = new IntegerChromosome(3);
        IntegerChromosome x2 = new IntegerChromosome(6);
        IntegerChromosome x3 = new IntegerChromosome(11);
        IntegerChromosome x4 = new IntegerChromosome(14);
        IntegerChromosome x5 = new IntegerChromosome(1);
        List<Chromosome> population = new LinkedList<>();
        population.add(x1);
        population.add(x2);
        population.add(x3);
        population.add(x4);
        population.add(x5);

        Selection selection = new Universal();
        population = (List<Chromosome>) selection.select(3, population);
        assertTrue(population.size() == 3);
    }

    public void testRanking() {
        IntegerChromosome x1 = new IntegerChromosome(3);
        IntegerChromosome x2 = new IntegerChromosome(6);
        IntegerChromosome x3 = new IntegerChromosome(11);
        IntegerChromosome x4 = new IntegerChromosome(14);
        IntegerChromosome x5 = new IntegerChromosome(1);
        List<Chromosome> population = new LinkedList<>();
        population.add(x1);
        population.add(x2);
        population.add(x3);
        population.add(x4);
        population.add(x5);

        Selection selection = new Rank();
        population = (List<Chromosome>) selection.select(3, population);
        assertTrue(population.size() == 3);
    }

    private static class IntegerChromosome implements Chromosome {

        private static double TOTAL_FITNESS = 35.0;
        private int num;
        private double rankingFitness;

        public IntegerChromosome(int num) {
            this.num = num;
        }

        @Override
        public double fitness() {
            return num;
        }

        @Override
        public double relativeFitness() {
            return rankingFitness == 0 ? num / TOTAL_FITNESS : rankingFitness;
        }

        @Override
        public void setTotalFitness(double totalFitness) {
            TOTAL_FITNESS = totalFitness;
        }

        @Override
        public void setRankingFitness(double newFitness) {
            rankingFitness = newFitness;
        }

        @Override
        public void resetRankingFitness() {
            rankingFitness = 0;
        }

        @Override
        public String toString() {
            return String.valueOf(num);
        }
    }
}
