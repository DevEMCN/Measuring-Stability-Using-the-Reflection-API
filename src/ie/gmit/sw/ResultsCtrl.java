package ie.gmit.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ResultsCtrl implements ActionListener {

    private JFrame frame;
    private AnalyzerCtrl ac;

    public ResultsCtrl(JFrame frame, AnalyzerCtrl ac) {
        this.frame = frame;
        this.ac = ac;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //   create a new type summary table model
        TypeSummaryTableModel tstm = new TypeSummaryTableModel();
        //System.out.println(data.length);
        // set the data of the table to the data acquired from running the tool
        tstm.setData(ac.getData());
        // pass the app summary module a reference to the created tstm
        AppSummary as = new AppSummary(frame, true, tstm);
        as.show();
    }

}
