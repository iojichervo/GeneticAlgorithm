package ar.edu.itba.sia.graph;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.ui.InteractivePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WarriorsPlot extends JFrame {

    private DataTable avg;
    private DataTable best;
    private DataTable worst;
    private JLabel label;

    public WarriorsPlot() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 900);
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

        JPanel panel = new JPanel();
        label = new JLabel();
        label.setFont(new Font("Verdana", 1, 20));
        panel.add(label);
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

        InteractivePanel iPanel = new InteractivePanel(plot);
        iPanel.setLayout(new BorderLayout());
        iPanel.add(panel, BorderLayout.SOUTH);
        add(iPanel);
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

    public void setText(String first, String second) {
        label.setText("<html><center>" + first + "<br>" + second + "</center></html>");
    }
}
