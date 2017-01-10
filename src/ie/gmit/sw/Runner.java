package ie.gmit.sw;

/**
 *
 * @author eamon
 */
public class Runner {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AppWindow();
            }
        });
    }
}
