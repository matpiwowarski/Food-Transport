package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.FoodItemType;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    private JRadioButton LOADVANRadioButton;
    private JRadioButton UNLOADVANRadioButton;
    private JButton LoadUnloadButton;
    private JPanel LoadUnload;
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
    private JTabbedPane tabbedPane2;
    private JList VehicleSelect;
    private JTextField UpdateRegistration;
    private JTextField UpdateVolume;
    private JTextField UpdateMaxWeight;
    private JTextField UpdateAverageSpeed;
    private JTextField UpdateLength;
    private JComboBox UpdateExtraInfo;
    private JLabel ExtraInfoLabel;
    private JButton SAVEButton1;
    private JButton DELETEButton1;
    private JTabbedPane tabbedPane3;
    private JTextField UpdateLabel;
    private JTextField UpdateFoodVolume;
    private JTextField UpdateWeight;
    private JTextField UpdateExpirationDate;
    private JComboBox UpdateType;
    private JButton DELETEButton2;
    private JButton SAVEButton2;
    private DefaultListModel<FoodItem> foodItemModel;
    private ArrayList<FoodItem> FoodItemArrayList = new ArrayList<FoodItem>();
    private JList FoodItemSelect;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;

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

        ExtraInfoLabel.setText("Number Of Trailers");
        UpdateExtraInfo.removeAllItems();
        UpdateExtraInfo.addItem("0");
        UpdateExtraInfo.addItem("1");
        UpdateExtraInfo.addItem("2");
        UpdateExtraInfo.addItem("3");

        FoodItemType.addItem("Fresh");
        FoodItemType.addItem("Frozen");

        UpdateType.addItem("Fresh");
        UpdateType.addItem("Frozen");

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
                // CREATE
                ExtraVehicleLabel.setText("Number Of Trailers");
                ExtraVehicleField.removeAllItems();
                ExtraVehicleField.addItem("0");
                ExtraVehicleField.addItem("1");
                ExtraVehicleField.addItem("2");
                ExtraVehicleField.addItem("3");
                // UPDATE DELETE
                ExtraInfoLabel.setText("Number Of Trailers");
                UpdateExtraInfo.removeAllItems();
                UpdateExtraInfo.addItem("0");
                UpdateExtraInfo.addItem("1");
                UpdateExtraInfo.addItem("2");
                UpdateExtraInfo.addItem("3");
            }
        });
        VanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // VAN
                TruckButton.setSelected(false);
                // CREATE
                ExtraVehicleLabel.setText("Food Item Type");
                ExtraVehicleField.removeAllItems();
                ExtraVehicleField.addItem("Fresh");
                ExtraVehicleField.addItem("Frozen");
                // UPDATE DELETE
                ExtraInfoLabel.setText("Food Item Type");
                UpdateExtraInfo.removeAllItems();
                UpdateExtraInfo.addItem("Fresh");
                UpdateExtraInfo.addItem("Frozen");
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
        CreateFoodItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String label = FoodItemLabel.getText();
                double volume = Double.parseDouble(FoodItemVolume.getText());
                double weight = Double.parseDouble(FoodItemWeight.getText());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate expirationDate = LocalDate.parse(FoodItemExpirationDate.getText(), formatter);
                si.um.opj.piwowarski.logic.FoodItemType type;
                if(FoodItemType.getSelectedIndex() == 0)
                {
                    type = si.um.opj.piwowarski.logic.FoodItemType.FRESH;
                }
                else
                {
                    type = si.um.opj.piwowarski.logic.FoodItemType.FROZEN;
                }

                FoodItem foodItemToAdd = new FoodItem(label, volume, weight, expirationDate, type);
                FoodItemArrayList.add(foodItemToAdd);

                foodItemModel = new DefaultListModel<FoodItem>();

                for(FoodItem item : FoodItemArrayList)
                {
                    foodItemModel.addElement(item);
                }

                FoodItemSelect.setModel(foodItemModel);
                FoodItemSelect.setSelectedIndex(0);

                // clear
                FoodItemLabel.setText("");
                FoodItemVolume.setText("");
                FoodItemWeight.setText("");
                FoodItemExpirationDate.setText("");
                FoodItemType.setSelectedIndex(0);
            }
        });
        CreateVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RegistrationNumber.setText("");
                Volume.setText("");
                MaxWeight.setText("");
                AverageSpeed.setText("");
                Length.setText("");
                ExtraVehicleField.setSelectedIndex(0);
            }
        });
        CreateBusinessFacilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NameField.setText("");
                LocationField.setText("");
                CapacityField.setText("");
            }
        });
        DELETEButton2.addActionListener(new DeleteFoodItemListener(FoodItemSelect));
        FoodItemSelect.addListSelectionListener(new FoodItemLoadInfo());
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

    class FoodItemLoadInfo implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {

        }
    }
}

