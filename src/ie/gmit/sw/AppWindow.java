package ie.gmit.sw;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class AppWindow {

    private JFrame frame;
    private PSCalculator psc;
    private Object[][] data;
    private AppSummary as;
    private TypeSummaryTableModel tstm;
    private JLabel fileChooserLabel = new JLabel("");
    private JButton btnResults = new JButton("See Results");
    private JarCtrl jc;
    private JFileChooser fc;
    private AnalyzerCtrl ac;
    private ResultsCtrl rc;

    public AppWindow() {
        //Create a window for the application
        frame = new JFrame();
        frame.setTitle("B.Sc. in Software Development - GMIT");
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        //The file panel will contain the file chooser
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
        top.setBorder(new javax.swing.border.TitledBorder("Select Jar File"));
        top.setPreferredSize(new java.awt.Dimension(500, 100));
        top.setMaximumSize(new java.awt.Dimension(500, 100));
        top.setMinimumSize(new java.awt.Dimension(500, 100));

        final JTextField txtFileName = new JTextField(20);
        txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
        txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
        txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
        txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));

        JButton btnChooseFile = new JButton("Browse...");
        btnChooseFile.setToolTipText("Select Jar File");
        btnChooseFile.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMaximumSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(90, 30));

        jc = new JarCtrl(frame, txtFileName, fileChooserLabel);
        btnChooseFile.addActionListener(jc);

        JButton btnOther = new JButton("Analyze Jar");
        btnOther.setToolTipText("Analyze Jar");
        btnOther.setPreferredSize(new java.awt.Dimension(150, 30));
        btnOther.setMaximumSize(new java.awt.Dimension(150, 30));
        btnOther.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnOther.setMinimumSize(new java.awt.Dimension(150, 30));

        ac = new AnalyzerCtrl(txtFileName, data, btnResults);
        btnOther.addActionListener(ac);

        top.add(txtFileName);
        top.add(btnChooseFile);
        top.add(btnOther);
        frame.getContentPane().add(top); //Add the panel to the window

        JPanel middle = new JPanel(new FlowLayout(FlowLayout.LEADING));
        middle.setBorder(new BevelBorder(BevelBorder.RAISED));
        middle.setPreferredSize(new java.awt.Dimension(500, 100));
        middle.setMaximumSize(new java.awt.Dimension(500, 100));
        middle.setMinimumSize(new java.awt.Dimension(500, 100));

        //fileChooserLabel = new JLabel("Choose a jar file");
        middle.add(fileChooserLabel);
        frame.getContentPane().add(middle);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));
        bottom.setMaximumSize(new java.awt.Dimension(500, 50));
        bottom.setMinimumSize(new java.awt.Dimension(500, 50));

        //Create Results button
        btnResults.setVisible(false);

        // there is a flaw in my mvc pattern here to get this working
        rc = new ResultsCtrl(frame, ac);
        btnResults.addActionListener(rc);

        JButton btnQuit = new JButton("Quit"); //Create Quit button
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        bottom.add(btnResults);
        bottom.add(btnQuit);

        frame.getContentPane().add(bottom);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AppWindow();
    }
}
