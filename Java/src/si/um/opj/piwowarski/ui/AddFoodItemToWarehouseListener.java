package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.EventReporter;
import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.facility.Warehouse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddFoodItemToWarehouseListener implements ActionListener {

    private JList<Warehouse> warehouseJList;
    private ArrayList<Warehouse> warehouses;
    private JList<FoodItem> foodItemJList;
    private ArrayList<FoodItem> foodItems;


    AddFoodItemToWarehouseListener(JList<Warehouse> warehouseJList, ArrayList<Warehouse> warehouses,
                                   JList<FoodItem> foodItemJList, ArrayList<FoodItem> foodItems)
    {
        this.warehouseJList = warehouseJList;
        this.warehouses = warehouses;
        this.foodItemJList = foodItemJList;
        this.foodItems = foodItems;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(foodItemJList.getSelectedIndex() >= 0 && warehouseJList.getSelectedIndex() >= 0)
        {
            try{
                int foodItemIndex = foodItemJList.getSelectedIndex();
                int warehouseIndex = warehouseJList.getSelectedIndex();

                FoodItem selectedFoodItem = foodItems.get(foodItemIndex);
                Warehouse selectedWarehouse = warehouses.get(warehouseIndex);

                EventReporter reporter = new EventReporter();
                reporter.addToReport("Added food item into warehouse");

                selectedWarehouse.addItem(selectedFoodItem);
            }
            catch(Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }

        }
    }
}
