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
    private JTabbedPane CUDTabbedPane;
    private JPanel BusinessFacilityPanel;
    private JPanel VehiclePanel;
    private JPanel FoodItemPanel;
    private JPanel StoreWarehousePanel;
    private JRadioButton StoreButton;
    private JRadioButton WarehouseButton;
    private JPanel Information1Panel;
    private JTextField NameField;
    private JTextField LocationField;
    private JTextField CapacityField;
    private JRadioButton TruckButton;
    private JRadioButton VanButton;
    private JPanel TruckVanPanel;
    private JPanel Information2Panel;
    private JComboBox ExtraVehicleField;
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
    private JLabel CapacityLabel;
    private JLabel ExtraVehicleLabel;
    private JTabbedPane ActionTabbedPane;
    private JPanel AddFoodPanel;
    private JPanel LoadVehiclePanel;
    private JButton AddButton;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton LOADVANRadioButton;
    private JRadioButton UNLOADVANRadioButton;
    private JButton LoadUnloadButton;
    private JPanel LoadUnload;
    private JTextField BusinessFacilityName;
    private JTextField RegistrationNumberLoadUnload;
    private JRadioButton LOADTRUCKRadioButton1;
    private JRadioButton UNLOADTRUCKRadioButton1;
    private JLabel FromIntoLabel;
    private JButton CreateBusinessFacilityButton;
    private JButton CreateVehicleButton;
    private JButton CreateFoodItemButton;
    private JTabbedPane tabbedPane1;
    private JList BusinessFacilitySelect;
    private JTextField NameUpdate;
    private JTextField LocationUpdate;
    private JTextField CapacityUpdate;
    private JButton DELETEButton;
    private JLabel CapacityUpdateLabel;
    private JButton SAVEButton;

    public MainWindow()
    {

        CapacityField.setVisible(false);
        CapacityLabel.setVisible(false);
        CapacityUpdate.setVisible(false);
        CapacityUpdateLabel.setVisible(false);

        ExtraVehicleField.addItem("0");
        ExtraVehicleField.addItem("1");
        ExtraVehicleField.addItem("2");
        ExtraVehicleField.addItem("3");

        FoodItemType.addItem("Fresh");
        FoodItemType.addItem("Frozen");

        LOADVANRadioButton.doClick();
        TruckButton.doClick();
        StoreButton.doClick();

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
        TruckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TRUCK
                VanButton.setSelected(false);
                ExtraVehicleLabel.setText("Number Of Trailers");
                ExtraVehicleField.removeAllItems();
                ExtraVehicleField.addItem("0");
                ExtraVehicleField.addItem("1");
                ExtraVehicleField.addItem("2");
                ExtraVehicleField.addItem("3");
            }
        });
        VanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // VAN
                TruckButton.setSelected(false);
                ExtraVehicleLabel.setText("Food Item Type");
                ExtraVehicleField.removeAllItems();
                ExtraVehicleField.addItem("Fresh");
                ExtraVehicleField.addItem("Frozen");
            }
        });
        StoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // STORE
                WarehouseButton.setSelected(false);
                CapacityField.setVisible(false);
                CapacityLabel.setVisible(false);
                CapacityUpdate.setVisible(false);
                CapacityUpdateLabel.setVisible(false);
            }
        });
        WarehouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // WAREHOUSE
                StoreButton.setSelected(false);
                CapacityField.setVisible(true);
                CapacityLabel.setVisible(true);
                CapacityUpdate.setVisible(true);
                CapacityUpdateLabel.setVisible(true);
            }
        });
        LOADVANRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UNLOADVANRadioButton.setSelected(false);
                LOADTRUCKRadioButton1.setSelected(false);
                UNLOADTRUCKRadioButton1.setSelected(false);
                LoadUnloadButton.setText("LOAD");
                FromIntoLabel.setText("From");
            }
        });
        UNLOADVANRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LOADVANRadioButton.setSelected(false);
                LOADTRUCKRadioButton1.setSelected(false);
                UNLOADTRUCKRadioButton1.setSelected(false);
                LoadUnloadButton.setText("UNLOAD");
                FromIntoLabel.setText("Into");
            }
        });
        LOADTRUCKRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LOADVANRadioButton.setSelected(false);
                UNLOADVANRadioButton.setSelected(false);
                UNLOADTRUCKRadioButton1.setSelected(false);
                LoadUnloadButton.setText("LOAD");
                FromIntoLabel.setText("From");
            }
        });
        UNLOADTRUCKRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LOADVANRadioButton.setSelected(false);
                UNLOADVANRadioButton.setSelected(false);
                LOADTRUCKRadioButton1.setSelected(false);
                LoadUnloadButton.setText("UNLOAD");
                FromIntoLabel.setText("Into");
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

