package ie.gmit.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class AnalyzerCtrl implements ActionListener {

    private PSCalculator psc;
    private JTextField jarName;
    private Object[][] data;
    private JButton btnResults;

    public AnalyzerCtrl(JTextField jarName, Object[][] data, JButton btnResults) {
        //this.psc = psc;
        this.jarName = jarName;
        this.data = data;
        this.btnResults = btnResults;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Analyzing Jar");

        // create a new instance of the positional stability calculator
        psc = new PSCalculator(jarName.getText());
        // get the table data from the calculator to feed to the app summary below
        data = psc.getTableData();
        System.out.println(data.length);
        // make the app summary table view visible 
        btnResults.setVisible(true);
    }

    public Object[][] getData() {
        return this.data;
    }

}
