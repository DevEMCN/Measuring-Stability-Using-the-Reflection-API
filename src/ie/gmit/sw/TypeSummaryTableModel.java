package ie.gmit.sw;

import javax.swing.table.*;
public class TypeSummaryTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 777L;
	private String[] cols = {"Class", "Efferent", "Afferent", "Stability"};
//	private Object[][] data = {
//		{"Stuff 1", "Other Stuff 1"},
//		{"Stuff 2", "Other Stuff 2"},
//		{"Stuff 3", "Other Stuff 3"},
//		{"Stuff 4", "Other Stuff 4"},
//		{"Stuff 5", "Other Stuff 5"},
//		{"Stuff 6", "Other Stuff 6"},
//		{"Stuff 7", "Other Stuff 7"}
//	};
	private Object[][] data;
	
	public Object[][] getData(){
		return this.data;
	}
	public void setData(Object[][] data){
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