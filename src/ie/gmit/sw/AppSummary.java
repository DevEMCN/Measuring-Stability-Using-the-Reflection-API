package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author eamon
 */
public class AppSummary extends JDialog {

    private static final long serialVersionUID = 777L;
    private TypeSummaryTableModel tm = null;
    private JTable table = null;
    private JScrollPane tableScroller = null;
    private JButton btnClose = null;
    private JPanel tablePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private Container c;

    /**
     *
     * @param parent
     * @param modal
     * @param tstm
     */
    public AppSummary(JFrame parent, boolean modal, TypeSummaryTableModel tstm) {
        super(parent, modal);
        super.setTitle("Summary");
        super.setResizable(true);

        this.setSize(new Dimension(500, 400));

        c = getContentPane();
        c.setLayout(new FlowLayout());

        this.tm = tstm; // setting the typeSummaryTableModel to the one given by resultsCtrl

        createTable();
        configureButtonPanel();

        c.add(tablePanel);
        c.add(buttonPanel);

        //System.out.println(tstm.getData().length);
    }

    /**
     *
     * @return
     */
    public TypeSummaryTableModel getTM() {
        return this.tm;
    }

    private void createTable() {
        // get the typeSummaryTable Model
        tm = getTM();
        // set the typeSummaryTableModel for the table
        table = new JTable(tm);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setSelectionBackground(Color.YELLOW);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumn column = null;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(200);
                column.setMaxWidth(200);
                column.setMinWidth(200);
            } else {
                column.setPreferredWidth(100);
                column.setMaxWidth(100);
                column.setMinWidth(100);
            }
        }

        tableScroller = new JScrollPane(table);
        tableScroller.setPreferredSize(new java.awt.Dimension(485, 235));
        tableScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        tablePanel.add(tableScroller, FlowLayout.LEFT);
    }

    private void configureButtonPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Configure the Cancel button
        btnClose = new JButton("Close");
        btnClose.setToolTipText("Close this Window");
        btnClose.setPreferredSize(new java.awt.Dimension(100, 40));
        btnClose.setMaximumSize(new java.awt.Dimension(100, 40));
        btnClose.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnClose.setMinimumSize(new java.awt.Dimension(100, 40));
        btnClose.setIcon(new ImageIcon("images/close.gif"));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        buttonPanel.add(btnClose);
    }
}
