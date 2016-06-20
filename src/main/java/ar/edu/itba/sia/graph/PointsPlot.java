package ar.edu.itba.sia.graph;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.ui.InteractivePanel;

import javax.swing.*;
import java.awt.*;

public class PointsPlot extends JFrame {

    private DataTable avg;
    private DataTable best;
    private DataTable worst;

    public PointsPlot() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        avg = new DataTable(Double.class, Double.class);
        best = new DataTable(Double.class, Double.class);
        worst = new DataTable(Double.class, Double.class);
        XYPlot plot = new XYPlot(avg, best, worst);
        getContentPane().add(new InteractivePanel(plot));
        plot.getPointRenderers(avg).get(0).setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
        plot.getPointRenderers(best).get(0).setColor(new Color(1.0f, 0.0f, 0.0f, 1.0f));
        plot.getPointRenderers(worst).get(0).setColor(new Color(0.0f, 0.0f, 1.0f, 1.0f));

        // Join dots
//        LineRenderer lines = new DefaultLineRenderer2D();
//        plot.setLineRenderers(avg, lines);
    }

    public void addAvg(double x, double y) {
        avg.add(x, y);
    }

    public void addBest(double x, double y) {
        best.add(x, y);
    }

    public void addWorst(double x, double y) {
        worst.add(x, y);
    }
}
