package ie.gmit.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author eamon
 */
public class AnalyzerCtrl implements ActionListener {

    private PSCalculator psc;
    private JTextField jarName;
    private Object[][] data;
    private JButton btnResults;

    /**
     *
     * @param jarName
     * @param data
     * @param btnResults
     */
    public AnalyzerCtrl(JTextField jarName, Object[][] data, JButton btnResults) {
        //this.psc = psc;
        this.jarName = jarName;
        this.data = data;
        this.btnResults = btnResults;
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Analyzing Jar");

        // create a new instance of the positional stability calculator
        psc = new PSCalculator(jarName.getText());
        // get the table data from the calculator to feed to the app summary below
        data = psc.getTableData();
     
        // make the app summary table view visible 
        btnResults.setVisible(true);
    }

    /**
     *
     * @return
     */
    public Object[][] getData() {
        // used this to get around a problem with my code
        return this.data;
    }

}
