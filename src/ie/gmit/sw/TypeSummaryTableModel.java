package ie.gmit.sw;

import javax.swing.table.*;

/**
 *
 * @author eamon
 */
public class TypeSummaryTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 777L;
    private String[] cols = {"Class", "Efferent", "Afferent", "Stability"};

    private Object[][] data;

    /**
     *
     * @return
     */
    public Object[][] getData() {
        return this.data;
    }

    /**
     *
     * @param data
     */
    public void setData(Object[][] data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public int getColumnCount() {
        return cols.length;
    }

    /**
     *
     * @return
     */
    public int getRowCount() {
        return data.length;
    }

    /**
     *
     * @param col
     * @return
     */
    public String getColumnName(int col) {
        return cols[col];
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /**
     *
     * @param c
     * @return
     */
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
