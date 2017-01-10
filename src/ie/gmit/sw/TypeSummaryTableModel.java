package ie.gmit.sw;

import javax.swing.table.*;

public class TypeSummaryTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 777L;
    private String[] cols = {"Class", "Efferent", "Afferent", "Stability"};

    private Object[][] data;

    public Object[][] getData() {
        return this.data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public int getColumnCount() {
        return cols.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return cols[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
