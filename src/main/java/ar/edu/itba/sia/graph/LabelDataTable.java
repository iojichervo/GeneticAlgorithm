package ar.edu.itba.sia.graph;

import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;

public class LabelDataTable extends DataTable {

    private String label;

    public LabelDataTable(Class<? extends Comparable<?>>... classes) {
        super(classes);
    }

    public LabelDataTable(int i, Class<? extends Comparable<?>> aClass) {
        super(i, aClass);
    }

    public LabelDataTable(DataSource dataSource) {
        super(dataSource);
    }

    public LabelDataTable(Class<Double> doubleClass, Class<Double> doubleClass1, String label) {
        super(doubleClass, doubleClass1);
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
