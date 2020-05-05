package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.FoodItemType;
import si.um.opj.piwowarski.logic.Location;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.facility.Store;
import si.um.opj.piwowarski.logic.facility.Warehouse;

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
    private JRadioButton StoreButton;
    private JRadioButton WarehouseButton;
    private JPanel Information1Panel;
    private JTextField NameField;
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
    private DefaultListModel<BusinessFacility> businessFacilityModel = new DefaultListModel<BusinessFacility>();
    private ArrayList<BusinessFacility> businessFacilityArrayList = new ArrayList<BusinessFacility>();
    private DefaultListModel<FoodItem>  foodItemModel = new DefaultListModel<FoodItem>();
    private ArrayList<FoodItem> FoodItemArrayList = new ArrayList<FoodItem>();
    private JList FoodItemSelect;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JComboBox LocationComboBox;
    private JComboBox LocationComboBoxUpdate;
    private JPanel StoreWarehousePanel;

    public MainWindow()
    {
        BusinessFacilitySelect.setModel(businessFacilityModel);
        FoodItemSelect.setModel(foodItemModel);

        CapacityField.setVisible(false);
        CapacityLabel.setVisible(false);
        CapacityUpdate.setVisible(false);
        CapacityUpdateLabel.setVisible(false);

        LocationComboBox.addItem("Katowice (POL)");
        LocationComboBox.addItem("Maribor (SLV)");
        LocationComboBox.addItem("Ljubljana (SLV)");
        LocationComboBox.addItem("Paris (FRA)");

        LocationComboBoxUpdate.addItem("Katowice (POL)");
        LocationComboBoxUpdate.addItem("Maribor (SLV)");
        LocationComboBoxUpdate.addItem("Ljubljana (SLV)");
        LocationComboBoxUpdate.addItem("Paris (FRA)");

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

        // BUSINESS FACILITY
        CreateBusinessFacilityButton.addActionListener(new AddBusinessFacility());
        DELETEButton.addActionListener(new DeleteBusinessFacilityListener(BusinessFacilitySelect, businessFacilityArrayList));
        BusinessFacilitySelect.addListSelectionListener(new BusinessFacilityLoadInfo());
        SAVEButton.addActionListener(new UpdateBusinessFacility());

        // FOOD ITEM
        CreateFoodItemButton.addActionListener(new AddFoodItem());
        DELETEButton2.addActionListener(new DeleteFoodItemListener(FoodItemSelect, FoodItemArrayList));
        FoodItemSelect.addListSelectionListener(new FoodItemLoadInfo());
        SAVEButton2.addActionListener(new UpdateFoodItem());
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

    class UpdateBusinessFacility implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (BusinessFacilitySelect.getSelectedIndex() >= 0) {
                int index = BusinessFacilitySelect.getSelectedIndex();
                BusinessFacility selectedItem = businessFacilityArrayList.get(index);

                selectedItem.setName(NameUpdate.getText());
                Location location = new Location();
                if (LocationComboBoxUpdate.getSelectedIndex() == 0) {
                    location = new Location("Katowice", "Poland");
                } else if (LocationComboBoxUpdate.getSelectedIndex() == 1) {
                    location = new Location("Maribor", "Slovenia");
                } else if (LocationComboBoxUpdate.getSelectedIndex() == 2) {
                    location = new Location("Ljubljana", "Slovenia");
                } else {
                    location = new Location("Paris", "France");
                }
                selectedItem.setLocation(location);

                if (selectedItem instanceof Warehouse) {
                    ((Warehouse) selectedItem).setFoodItems(new FoodItem[Integer.parseInt(CapacityUpdate.getText())]);
                }
            }
        }
    }

    class BusinessFacilityLoadInfo implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(BusinessFacilitySelect.getSelectedIndex() >= 0)
            {
                int index = BusinessFacilitySelect.getSelectedIndex();
                BusinessFacility selectedItem = businessFacilityArrayList.get(index);

                if(selectedItem instanceof Store)
                {
                    CapacityUpdate.setVisible(false);
                    CapacityUpdateLabel.setVisible(false);
                }
                else
                {
                    CapacityUpdate.setVisible(true);
                    CapacityUpdateLabel.setVisible(true);
                    CapacityUpdate.setText(String.valueOf(((Warehouse)selectedItem).getFoodItems().length));
                }

                NameUpdate.setText(selectedItem.getName());
                if(selectedItem.getLocation().getCity() == "Katowice")
                    LocationComboBoxUpdate.setSelectedIndex(0);
                else if(selectedItem.getLocation().getCity() == "Maribor")
                    LocationComboBoxUpdate.setSelectedIndex(1);
                else if(selectedItem.getLocation().getCity() == "Ljubljana")
                    LocationComboBoxUpdate.setSelectedIndex(2);
                else
                    LocationComboBoxUpdate.setSelectedIndex(3);
            }
        }
    }

    class AddBusinessFacility implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(StoreButton.isSelected())
            {
                if (NameField.getText().length() > 0)
                {
                    String name = NameField.getText();
                    Location location = new Location();
                    if(LocationComboBox.getSelectedIndex() == 0)
                    {
                        location = new Location("Katowice", "Poland");
                    }
                    else if(LocationComboBox.getSelectedIndex() == 1)
                    {
                        location = new Location("Maribor", "Slovenia");
                    }
                    else if(LocationComboBox.getSelectedIndex() == 2)
                    {
                        location = new Location("Ljubljana", "Slovenia");
                    }
                    else
                    {
                        location = new Location("Paris", "France");
                    }
                    Store store = new Store(name, location);
                    // ADDING
                    businessFacilityArrayList.add(store);
                    businessFacilityModel.addElement(store);
                    // CLEAR
                    NameField.setText("");
                    LocationComboBox.setSelectedIndex(0);
                    CapacityField.setText("");
                }
            }
            else if(WarehouseButton.isSelected())
            {
                if (NameField.getText().length() > 0 && CapacityField.getText().length() > 0)
                {
                    String name = NameField.getText();
                    Location location = new Location();
                    if(LocationComboBox.getSelectedIndex() == 0)
                    {
                        location = new Location("Katowice", "Poland");
                    }
                    else if(LocationComboBox.getSelectedIndex() == 1)
                    {
                        location = new Location("Maribor", "Slovenia");
                    }
                    else if(LocationComboBox.getSelectedIndex() == 2)
                    {
                        location = new Location("Ljubljana", "Slovenia");
                    }
                    else
                    {
                        location = new Location("Paris", "France");
                    }
                    int capacity = Integer.parseInt(CapacityField.getText());
                    Warehouse warehouse = new Warehouse(name, location, capacity);
                    // ADDING
                    businessFacilityArrayList.add(warehouse);
                    businessFacilityModel.addElement(warehouse);
                    // CLEAR
                    NameField.setText("");
                    LocationComboBox.setSelectedIndex(0);
                    CapacityField.setText("");
                }
            }
        }
    }

    class UpdateFoodItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (FoodItemSelect.getSelectedIndex() >= 0) {
                int index = FoodItemSelect.getSelectedIndex();
                FoodItem selectedItem = FoodItemArrayList.get(index);

                selectedItem.setLabel(UpdateLabel.getText());
                selectedItem.setVolume(Double.parseDouble(UpdateFoodVolume.getText()));
                selectedItem.setWeight(Double.parseDouble(UpdateWeight.getText()));
                selectedItem.setExpirationDate(java.time.LocalDate.parse(UpdateExpirationDate.getText()));

                if (UpdateType.getSelectedIndex() == 0) {
                    selectedItem.setType(si.um.opj.piwowarski.logic.FoodItemType.FRESH);
                } else // FROZEN
                {
                    selectedItem.setType(si.um.opj.piwowarski.logic.FoodItemType.FROZEN);
                }

                FoodItemSelect.setSelectedIndex(-1);
            }
        }
    }

    class AddFoodItem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (FoodItemLabel.getText().length() > 0 &&
                    FoodItemVolume.getText().length() > 0 &&
                    FoodItemWeight.getText().length() > 0 &&
                    FoodItemExpirationDate.getText().length() > 0
            ) {
                String label = FoodItemLabel.getText();
                double volume = Double.parseDouble(FoodItemVolume.getText());
                double weight = Double.parseDouble(FoodItemWeight.getText());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate expirationDate = LocalDate.parse(FoodItemExpirationDate.getText(), formatter);

                si.um.opj.piwowarski.logic.FoodItemType type;
                if (FoodItemType.getSelectedIndex() == 0) {
                    type = si.um.opj.piwowarski.logic.FoodItemType.FRESH;
                } else {
                    type = si.um.opj.piwowarski.logic.FoodItemType.FROZEN;
                }

                FoodItem foodItemToAdd = new FoodItem(label, volume, weight, expirationDate, type);

                // ADDING
                FoodItemArrayList.add(foodItemToAdd);
                foodItemModel.addElement(foodItemToAdd);

                // clear
                FoodItemLabel.setText("");
                FoodItemVolume.setText("");
                FoodItemWeight.setText("");
                FoodItemExpirationDate.setText("");
                FoodItemType.setSelectedIndex(0);
            }
        }
    }


    class FoodItemLoadInfo implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(FoodItemSelect.getSelectedIndex() >= 0)
            {
                int index = FoodItemSelect.getSelectedIndex();
                FoodItem selectedItem = FoodItemArrayList.get(index);

                UpdateLabel.setText(selectedItem.getLabel());
                UpdateFoodVolume.setText(String.valueOf(selectedItem.getVolume()));
                UpdateWeight.setText(String.valueOf(selectedItem.getWeight()));
                UpdateExpirationDate.setText(String.valueOf(selectedItem.getExpirationDate()));
                if(selectedItem.getType() == si.um.opj.piwowarski.logic.FoodItemType.FRESH)
                {
                    UpdateType.setSelectedIndex(0);
                }
                else // FROZEN
                {
                    UpdateType.setSelectedIndex(1);
                }
            }
        }
    }
}

