package ie.gmit.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author eamon
 */
public class JarCtrl implements ActionListener {

    private JFileChooser fc;
    private JTextField txtFileName;
    private JLabel fileChooserLabel;
    private JFrame frame;

    /**
     *
     * @param frame
     * @param txtFileName
     * @param fileChooserLabel
     */
    public JarCtrl(JFrame frame, JTextField txtFileName, JLabel fileChooserLabel) {
        this.frame = frame;
        this.txtFileName = txtFileName;
        this.fileChooserLabel = fileChooserLabel;
    }

    /**
     *
     * @param evt
     */
    public void actionPerformed(ActionEvent evt) {
        JFileChooser fc = new JFileChooser("./");
        int returnVal = fc.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile().getAbsoluteFile();
            String name = file.getAbsolutePath();
            txtFileName.setText(name);
            System.out.println("You selected the following file: " + name);
            if (!txtFileName.getText().contains(".jar")) {
                fileChooserLabel.setText("Invalid file");
            } else {
                fileChooserLabel.setText(txtFileName.getText());

            }
        }
    }

}
