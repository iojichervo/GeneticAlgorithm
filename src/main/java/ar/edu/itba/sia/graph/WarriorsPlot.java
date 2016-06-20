package ar.edu.itba.sia.graph;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.graphics.Location;
import de.erichseifert.gral.plots.Plot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.axes.AxisRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

import javax.swing.*;
import java.awt.*;

public class WarriorsPlot extends JFrame {

    private DataTable avg;
    private DataTable best;
    private DataTable worst;

    public WarriorsPlot() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

        avg = new LabelDataTable(Double.class, Double.class, "Average");
        best = new LabelDataTable(Double.class, Double.class, "Best");
        worst = new LabelDataTable(Double.class, Double.class, "Worst");
        XYPlot plot = new XYPlot(avg, best, worst);
        plot.getPointRenderers(avg).get(0).setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
        plot.getPointRenderers(best).get(0).setColor(new Color(1.0f, 0.0f, 0.0f, 1.0f));
        plot.getPointRenderers(worst).get(0).setColor(new Color(0.0f, 0.0f, 1.0f, 1.0f));

        plot.setLegendVisible(true);
        plot.getLegend().setAlignmentX(1.0);
        plot.getAxisRenderer(XYPlot.AXIS_X).getLabel().setText("Generation");
        plot.getAxisRenderer(XYPlot.AXIS_Y).getLabel().setText("Fitness");
        plot.getAxisRenderer(XYPlot.AXIS_X).setIntersection(5);


        getContentPane().add(new InteractivePanel(plot));
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
