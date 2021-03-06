package si.um.opj.piwowarski.ui;

import jdk.jfr.Event;
import si.um.opj.piwowarski.logic.EventReporter;
import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.Location;
import si.um.opj.piwowarski.logic.Serializer;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.facility.Store;
import si.um.opj.piwowarski.logic.facility.Warehouse;
import si.um.opj.piwowarski.logic.transport.Truck;
import si.um.opj.piwowarski.logic.transport.Van;
import si.um.opj.piwowarski.logic.transport.Vehicle;

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
    private JRadioButton LoadButton;
    private JRadioButton UnloadButton;
    private JButton LoadUnloadButton;
    private JRadioButton LOADTRUCKRadioButton1;
    private JRadioButton UNLOADTRUCKRadioButton1;
    private JLabel FromIntoLabel;
    private JButton CreateBusinessFacilityButton;
    private JButton CreateVehicleButton;
    private JButton CreateFoodItemButton;
    private JTabbedPane tabbedPane1;
    private JTextField NameUpdate;
    private JTextField CapacityUpdate;
    private JButton DELETEButton;
    private JLabel CapacityUpdateLabel;
    private JButton SAVEButton;
    private JTabbedPane tabbedPane2;
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
    private JList VehicleJList;
    private JList BusinessFacilityJList;
    private JComboBox LocationComboBox;
    private JComboBox LocationComboBoxUpdate;
    private JPanel StoreWarehousePanel;
    private JPanel TruckVanPanel;
    // DATA
    public static Serializer serializer;
    // business facility
    private DefaultListModel<BusinessFacility> businessFacilityModel = new DefaultListModel<BusinessFacility>();
    private ArrayList<BusinessFacility> businessFacilityArrayList = new ArrayList<BusinessFacility>();
    private JList BusinessFacilitySelect;
    // vehicle
    private DefaultListModel<Vehicle> vehicleModel = new DefaultListModel<Vehicle>();
    private ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
    private JList VehicleSelect;
    // food item
    private DefaultListModel<FoodItem> foodItemModel = new DefaultListModel<FoodItem>();
    private ArrayList<FoodItem> FoodItemArrayList = new ArrayList<FoodItem>();
    private JList FoodItemSelect;
    private JList FoodItemJList;
    // only warehouses
    private ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
    private DefaultListModel<Warehouse> warehouseModel = new DefaultListModel<Warehouse>();
    private JList WarehouseJList;

    public MainWindow() {
        BusinessFacilitySelect.setModel(businessFacilityModel);
        BusinessFacilityJList.setModel(businessFacilityModel);

        FoodItemSelect.setModel(foodItemModel);
        FoodItemJList.setModel(foodItemModel);

        VehicleSelect.setModel(vehicleModel);
        WarehouseJList.setModel(warehouseModel);
        VehicleJList.setModel(vehicleModel);


        serializer = new Serializer(businessFacilityArrayList, vehicleArrayList, FoodItemArrayList, warehouses);
        serializer.deserialize();

        businessFacilityArrayList = serializer.getBusinessFacilityArrayList();
        vehicleArrayList = serializer.getVehicleArrayList();
        FoodItemArrayList = serializer.getFoodItemArrayList();
        warehouses = serializer.getWarehouses();

        for (var bf: businessFacilityArrayList) {
            businessFacilityModel.addElement(bf);
        }
        for (var vehicle: vehicleArrayList) {
            vehicleModel.addElement(vehicle);
        }
        for (var item: FoodItemArrayList) {
            foodItemModel.addElement(item);
        }
        for (var warehouse: warehouses) {
            warehouseModel.addElement(warehouse);
        }
        
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

        // BUSINESS FACILITY
        CreateBusinessFacilityButton.addActionListener(new AddBusinessFacility());
        DELETEButton.addActionListener(new DeleteBusinessFacilityListener(BusinessFacilitySelect, businessFacilityArrayList,
                WarehouseJList, warehouses));
        BusinessFacilitySelect.addListSelectionListener(new BusinessFacilityLoadInfo());
        SAVEButton.addActionListener(new UpdateBusinessFacility());

        // VEHICLE
        CreateVehicleButton.addActionListener(new AddVehicle());
        DELETEButton1.addActionListener(new DeleteVehicleListener(VehicleSelect, vehicleArrayList));
        VehicleSelect.addListSelectionListener(new VehicleLoadInfo());
        SAVEButton1.addActionListener(new UpdateVehicle());

        // FOOD ITEM
        CreateFoodItemButton.addActionListener(new AddFoodItem());
        DELETEButton2.addActionListener(new DeleteFoodItemListener(FoodItemSelect, FoodItemArrayList));
        FoodItemSelect.addListSelectionListener(new FoodItemLoadInfo());
        SAVEButton2.addActionListener(new UpdateFoodItem());

        // ACTIONS
        AddButton.addActionListener(new AddFoodItemToWarehouseListener(WarehouseJList, warehouses, FoodItemJList, FoodItemArrayList));
        LoadUnloadButton.addActionListener(new LoadUnloadVehicleListener(VehicleJList, BusinessFacilityJList));
    }

    public static void main(String[] args) {

        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 3/4 of the height, and 4/5 of the width
        int height = (int) (screenSize.height * 0.75);
        int width = (int) (screenSize.width * 0.8);

        JFrame frame = new JFrame("MainWindow");
        // set the jframe height and width
        frame.setPreferredSize(new Dimension(width, height));
        // center position of JFrame
        frame.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);

        frame.setContentPane(new MainWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                serializer.serialize();
            }
        }));
    }

    class UpdateVehicle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try
            {
                if (VehicleSelect.getSelectedIndex() >= 0) {
                    int index = VehicleSelect.getSelectedIndex();
                    Vehicle selectedItem = vehicleArrayList.get(index);

                    selectedItem.setRegistrationNumber(UpdateRegistration.getText());
                    selectedItem.setVolume(Double.parseDouble(UpdateVolume.getText()));
                    selectedItem.setMaxWeight(Double.parseDouble(UpdateMaxWeight.getText()));
                    selectedItem.setAverageSpeed(Double.parseDouble(UpdateAverageSpeed.getText()));
                    selectedItem.setCargo(new FoodItem[Integer.parseInt(UpdateLength.getText())]);

                    if (selectedItem instanceof Truck) {
                        if (UpdateExtraInfo.getSelectedIndex() == 0) {
                            ((Truck) selectedItem).setNumberOfTrailers(0);
                        } else if (UpdateExtraInfo.getSelectedIndex() == 1) {
                            ((Truck) selectedItem).setNumberOfTrailers(1);
                        } else if (UpdateExtraInfo.getSelectedIndex() == 2) {
                            ((Truck) selectedItem).setNumberOfTrailers(2);
                        } else {
                            ((Truck) selectedItem).setNumberOfTrailers(3);
                        }
                    } else // Van
                    {
                        if (UpdateExtraInfo.getSelectedIndex() == 0) {
                            ((Van) selectedItem).setFoodItemType(si.um.opj.piwowarski.logic.FoodItemType.FRESH);
                        } else {
                            ((Van) selectedItem).setFoodItemType(si.um.opj.piwowarski.logic.FoodItemType.FROZEN);
                        }
                    }
                }
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Vehicle updated");
            }
            catch (Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }
        }
    }

    class VehicleLoadInfo implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if (VehicleSelect.getSelectedIndex() >= 0) {
                int index = VehicleSelect.getSelectedIndex();
                Vehicle selectedItem = vehicleArrayList.get(index);

                if (selectedItem instanceof Truck) {
                    ExtraInfoLabel.setText("Number Of Trailers");
                    UpdateExtraInfo.removeAllItems();
                    UpdateExtraInfo.addItem("0");
                    UpdateExtraInfo.addItem("1");
                    UpdateExtraInfo.addItem("2");
                    UpdateExtraInfo.addItem("3");

                    if(((Truck)selectedItem).getNumberOfTrailers() == 0)
                    {
                        UpdateExtraInfo.setSelectedIndex(0);
                    }
                    else if (((Truck)selectedItem).getNumberOfTrailers() == 1)
                    {
                        UpdateExtraInfo.setSelectedIndex(1);
                    }
                    else if (((Truck)selectedItem).getNumberOfTrailers() == 2)
                    {
                        UpdateExtraInfo.setSelectedIndex(2);
                    }
                    else
                    {
                        UpdateExtraInfo.setSelectedIndex(3);
                    }

                } else {
                    ExtraInfoLabel.setText("Food Item Type");
                    UpdateExtraInfo.removeAllItems();
                    UpdateExtraInfo.addItem("Fresh");
                    UpdateExtraInfo.addItem("Frozen");

                    if(((Van)selectedItem).getFoodItemType() == si.um.opj.piwowarski.logic.FoodItemType.FRESH)
                    {
                        UpdateExtraInfo.setSelectedIndex(0);
                    }
                    else
                    {
                        UpdateExtraInfo.setSelectedIndex(1);
                    }
                }

                UpdateRegistration.setText(selectedItem.getRegistrationNumber());
                UpdateVolume.setText(String.valueOf(selectedItem.getVolume()));
                UpdateMaxWeight.setText(String.valueOf(selectedItem.getMaxWeight()));
                UpdateAverageSpeed.setText(String.valueOf(selectedItem.getAverageSpeed()));
                UpdateLength.setText(String.valueOf(selectedItem.getCargo().length));
            }
        }
    }

    class AddVehicle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try
            {
                if (TruckButton.isSelected()) {
                    if (RegistrationNumber.getText().length() > 0
                            && Volume.getText().length() > 0
                            && MaxWeight.getText().length() > 0
                            && AverageSpeed.getText().length() > 0
                            && Length.getText().length() > 0) {
                        String registration = RegistrationNumber.getText();
                        double volume = Double.parseDouble(Volume.getText());
                        double maxweight = Double.parseDouble(MaxWeight.getText());
                        double averageSpeed = Double.parseDouble(AverageSpeed.getText());
                        int length = Integer.parseInt(Length.getText());
                        int numberOfTrailers = 0;
                        if (ExtraVehicleField.getSelectedIndex() == 0) {
                            numberOfTrailers = 0;
                        } else if (ExtraVehicleField.getSelectedIndex() == 1) {
                            numberOfTrailers = 1;
                        } else if (ExtraVehicleField.getSelectedIndex() == 2) {
                            numberOfTrailers = 2;
                        } else if (ExtraVehicleField.getSelectedIndex() == 3) {
                            numberOfTrailers = 3;
                        }

                        Truck truck = new Truck(registration, volume, maxweight, averageSpeed, length, numberOfTrailers);
                        // ADDING
                        vehicleArrayList.add(truck);
                        vehicleModel.addElement(truck);
                        // CLEAR
                        RegistrationNumber.setText("");
                        Volume.setText("");
                        MaxWeight.setText("");
                        AverageSpeed.setText("");
                        Length.setText("");
                        ExtraVehicleField.setSelectedIndex(0);
                    }
                } else if (VanButton.isSelected()) {
                    if (RegistrationNumber.getText().length() > 0
                            && Volume.getText().length() > 0
                            && MaxWeight.getText().length() > 0
                            && AverageSpeed.getText().length() > 0
                            && Length.getText().length() > 0) {
                        String registration = RegistrationNumber.getText();
                        double volume = Double.parseDouble(Volume.getText());
                        double maxweight = Double.parseDouble(MaxWeight.getText());
                        double averageSpeed = Double.parseDouble(AverageSpeed.getText());
                        int length = Integer.parseInt(Length.getText());
                        si.um.opj.piwowarski.logic.FoodItemType type = si.um.opj.piwowarski.logic.FoodItemType.FRESH;
                        if (ExtraVehicleField.getSelectedIndex() == 0) {
                            type = si.um.opj.piwowarski.logic.FoodItemType.FRESH;
                        } else {
                            type = si.um.opj.piwowarski.logic.FoodItemType.FROZEN;
                        }

                        Van van = new Van(registration, volume, maxweight, averageSpeed, length, type);
                        // ADDING
                        vehicleArrayList.add(van);
                        vehicleModel.addElement(van);
                        // CLEAR
                        RegistrationNumber.setText("");
                        Volume.setText("");
                        MaxWeight.setText("");
                        AverageSpeed.setText("");
                        Length.setText("");
                        ExtraVehicleField.setSelectedIndex(0);
                    }
                }
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Vehicle added");
            }
            catch(Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }

        }
    }

    class UpdateBusinessFacility implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try
            {
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
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Updated Business Facility");
            }
            catch (Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
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
            try {
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
                        warehouses.add(warehouse);
                        warehouseModel.addElement(warehouse);
                        // CLEAR
                        NameField.setText("");
                        LocationComboBox.setSelectedIndex(0);
                        CapacityField.setText("");
                    }
                }
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Business Facility added");
            }
            catch (Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }
        }
    }

    class UpdateFoodItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
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
                    EventReporter reporter = new EventReporter();
                    reporter.addToReport("Updated food item");
                }
            }
            catch (Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }
        }
    }

    class AddFoodItem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try
            {
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

                    EventReporter reporter = new EventReporter();
                    reporter.addToReport("Food item added");
                }
            }
            catch (Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
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

