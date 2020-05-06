package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.Transportable;
import si.um.opj.piwowarski.logic.exception.CapacityExceededException;
import si.um.opj.piwowarski.logic.exception.FoodItemTypeException;
import si.um.opj.piwowarski.logic.exception.VolumeExceededException;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.facility.Store;
import si.um.opj.piwowarski.logic.facility.Warehouse;
import si.um.opj.piwowarski.logic.transport.Truck;
import si.um.opj.piwowarski.logic.transport.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadUnloadVehicleListener implements ActionListener {

    private JList<Vehicle> vehicleJList;
    private JList<BusinessFacility> businessFacilityJList;

    public LoadUnloadVehicleListener(JList<Vehicle> vehicleJList, JList<BusinessFacility> businessFacilityJList) {
        this.vehicleJList = vehicleJList;
        this.businessFacilityJList = businessFacilityJList;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        DefaultListModel<Vehicle> vehicleModel = (DefaultListModel<Vehicle>) vehicleJList.getModel();
        DefaultListModel<BusinessFacility> businessFacilityModel = (DefaultListModel<BusinessFacility>) businessFacilityJList.getModel();

        if(vehicleJList.getSelectedIndex() >= 0 && businessFacilityJList.getSelectedIndex() >= 0)
        {
            int vehicleIndex = vehicleJList.getSelectedIndex();
            Vehicle selectedVehicle = vehicleModel.get(vehicleIndex);

            int businessFacilityIndex = businessFacilityJList.getSelectedIndex();
            BusinessFacility selectedBusinessFacility = businessFacilityModel.get(businessFacilityIndex);

            if(selectedBusinessFacility instanceof Store)
            {
                tryToAcceptVehicle(((Store)selectedBusinessFacility), selectedVehicle);
            }
            else // Warehouse
            {
                tryToAcceptVehicle(((Warehouse)selectedBusinessFacility), selectedVehicle);
            }
        }
    }

    public void tryToAcceptVehicle(Transportable place, Vehicle vehicle)
    {
        try {
            place.acceptVehicle(vehicle);
        }
        catch (CapacityExceededException e)
        {
            System.out.println("accepting vehicle failed " + e.info);
            if(vehicle instanceof Truck) {
                vehicle.unloadFoodItems();
            }
            e.printStackTrace();
        }
        catch (VolumeExceededException e)
        {
            System.out.println("accepting vehicle failed " + e.info);
            if(vehicle instanceof Truck) {
                vehicle.unloadFoodItems();
            }
            e.printStackTrace();
        }
        catch (FoodItemTypeException e)
        {
            System.out.println("accepting vehicle failed" + e.info);
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
