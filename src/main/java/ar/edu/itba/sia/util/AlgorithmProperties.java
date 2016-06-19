package ar.edu.itba.sia.util;

import ar.edu.itba.sia.crossover.Crossover;
import ar.edu.itba.sia.cut.Cut;
import ar.edu.itba.sia.cut.MaxGeneration;
import ar.edu.itba.sia.cut.Restrained;
import ar.edu.itba.sia.mutation.Mutation;
import ar.edu.itba.sia.replacement.Replacement;
import ar.edu.itba.sia.selection.Boltzmann;
import ar.edu.itba.sia.selection.Selection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AlgorithmProperties {

    private int n;
    private int k;
    private double a;
    private Selection selection1;
    private Selection selection2;
    private double pc;
    private Crossover crossover;
    private double pm;
    private Mutation mutation;
    private double b;
    private Selection replacement1;
    private Selection replacement2;
    private Replacement replacement;
    private int cutparam;
    private Cut cut;
    private double boltzmanntemp;

    public AlgorithmProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);

            n = Integer.valueOf(prop.getProperty("n"));
            k = Integer.valueOf(prop.getProperty("k"));
            boltzmanntemp = Double.valueOf(prop.getProperty("boltzmanntemp"));
            a = Double.valueOf(prop.getProperty("a"));
            selection1 = instantiateSelection(Class.forName("ar.edu.itba.sia.selection."
                    + prop.getProperty("selection1")));
            selection2 = instantiateSelection(Class.forName("ar.edu.itba.sia.selection."
                    + prop.getProperty("selection2")));
            pc = Double.valueOf(prop.getProperty("pc"));
            crossover = (Crossover) Class.forName("ar.edu.itba.sia.crossover."
                    + prop.getProperty("crossover")).getDeclaredConstructor(Double.class).newInstance(pc);
            pm = Double.valueOf(prop.getProperty("pm"));
            mutation = (Mutation) Class.forName("ar.edu.itba.sia.mutation."
                    + prop.getProperty("mutation")).getDeclaredConstructor(Double.class).newInstance(pm);
            b = Double.valueOf(prop.getProperty("b"));
            replacement1 = instantiateSelection(Class.forName("ar.edu.itba.sia.selection."
                    + prop.getProperty("replacement1")));
            replacement2 = instantiateSelection(Class.forName("ar.edu.itba.sia.selection."
                    + prop.getProperty("replacement2")));
            replacement = (Replacement) Class.forName("ar.edu.itba.sia.replacement."
                    + prop.getProperty("replacement")).newInstance();
            cutparam = Integer.valueOf(prop.getProperty("cutparam"));
            cut = instantiateCut(Class.forName("ar.edu.itba.sia.cut." + prop.getProperty("cut")));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Selection instantiateSelection(Class selectionClass) throws Exception {
        if (selectionClass.equals(Boltzmann.class)) {
            return new Boltzmann(boltzmanntemp);
        }
        return (Selection) selectionClass.newInstance();
    }

    private Cut instantiateCut(Class cutClass) throws Exception {
        if (cutClass.equals(MaxGeneration.class)) return new MaxGeneration(cutparam);
        if (cutClass.equals(Restrained.class)) return new Restrained();
        return (Cut) cutClass.getDeclaredConstructor(Double.class).newInstance(cutparam);
    }

    public int getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public double getA() {
        return a;
    }

    public Selection getSelection1() {
        return selection1;
    }

    public Selection getSelection2() {
        return selection2;
    }

    public Crossover getCrossover() {
        return crossover;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public double getB() {
        return b;
    }

    public Selection getReplacement1() {
        return replacement1;
    }

    public Selection getReplacement2() {
        return replacement2;
    }

    public Replacement getReplacement() {
        return replacement;
    }

    public Cut getCut() {
        return cut;
    }

}
