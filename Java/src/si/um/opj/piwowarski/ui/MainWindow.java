package si.um.opj.piwowarski.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel Cards;
    private JPanel ActionsCard;
    private JPanel CUDCard;
    private JButton CREATEUPDATEDELETEButton;
    private JButton ACTIONSButton;
    private JTabbedPane TabbedPane;
    private JPanel BusinessFacilityPanel;
    private JPanel VehiclePanel;
    private JPanel FoodItemPanel;
    private JPanel StoreWarehousePanel;
    private JRadioButton StoreButton;
    private JRadioButton WarehouseButton;
    private JPanel Information1Panel;
    private JButton Delete;
    private JButton Create;
    private JButton Update;
    private JTextField NameField;
    private JTextField LocationField;
    private JTextField CapacityField;
    private JRadioButton TruckButton;
    private JRadioButton VanButton;
    private JPanel TruckVanPanel;
    private JPanel Information2Panel;
    private JComboBox NumberOfTrailers;
    private JTextField Length;
    private JTextField AverageSpeed;
    private JTextField MaxWeight;
    private JTextField Volume;
    private JTextField RegistrationNumber;
    private JComboBox FoodItemType;
    private JTextField FoodItemExpirationDate;
    private JTextField FoodItemWeight;
    private JTextField FoodItemVolume;
    private JTextField FoodItemLabel;

    public MainWindow()
    {
        NumberOfTrailers.addItem("0");
        NumberOfTrailers.addItem("1");
        NumberOfTrailers.addItem("2");
        NumberOfTrailers.addItem("3");

        FoodItemType.addItem("Fresh");
        FoodItemType.addItem("Frozen");

        CREATEUPDATEDELETEButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                ActionsCard.setVisible(false);
                CUDCard.setVisible(true);
            }
        });

        ACTIONSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                ActionsCard.setVisible(true);
                CUDCard.setVisible(false);
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

