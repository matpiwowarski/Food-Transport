package si.um.opj.piwowarski.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel cards;
    private JPanel card1;
    private JPanel card2;
    private JButton CREATEUPDATEDELETEButton;
    private JButton ACTIONSButton;

    public MainWindow()
    {
        CREATEUPDATEDELETEButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                card1.setVisible(true);
                card2.setVisible(false);
            }
        });

        ACTIONSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                card1.setVisible(false);
                card2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;


        JFrame frame = new JFrame("MainWindow");
        // set the jframe height and width
        frame.setPreferredSize(new Dimension(width, height));
        // center position of JFrame
        frame.setLocation((screenSize.width - width)/2, (screenSize.height-height)/2);

        frame.setContentPane(new MainWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

