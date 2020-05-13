package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.EventReporter;
import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.facility.Warehouse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteBusinessFacilityListener implements ActionListener {

    private JList<BusinessFacility> businessFacilityJList;
    private JList<Warehouse> warehouseJList;
    private ArrayList<BusinessFacility> businessFacilityArrayList;
    private ArrayList<Warehouse> warehouses;

    public DeleteBusinessFacilityListener(JList<BusinessFacility> businessFacilityJList, ArrayList<BusinessFacility> businessFacilityArrayList,
    JList<Warehouse> warehouseJList, ArrayList<Warehouse> warehouses)
    {
        this.businessFacilityJList = businessFacilityJList;
        this.businessFacilityArrayList = businessFacilityArrayList;
        this.warehouseJList = warehouseJList;
        this.warehouses = warehouses;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultListModel<BusinessFacility> model = (DefaultListModel<BusinessFacility>) businessFacilityJList.getModel();
        DefaultListModel<Warehouse> warehouseModel = (DefaultListModel<Warehouse>) warehouseJList.getModel();

        if(businessFacilityJList.getSelectedIndex() >= 0)
        {
            try {
                int index = businessFacilityJList.getSelectedIndex();
                BusinessFacility selectedItem = businessFacilityArrayList.get(index);
                if(selectedItem instanceof Warehouse)
                {
                    int warehouseIndex = warehouses.indexOf(selectedItem);
                    warehouseModel.remove(warehouseIndex);
                    warehouses.remove(warehouseIndex);
                }

                model.remove(index);
                businessFacilityArrayList.remove(index);
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Deleted business facility");
            }
            catch(Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }
        }
        businessFacilityJList.setSelectedIndex(-1);
    }

}
