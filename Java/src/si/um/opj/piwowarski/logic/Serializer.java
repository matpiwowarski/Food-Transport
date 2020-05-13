package si.um.opj.piwowarski.logic;

import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.facility.Warehouse;
import si.um.opj.piwowarski.logic.transport.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class Serializer {

    private ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
    private ArrayList<FoodItem> FoodItemArrayList = new ArrayList<FoodItem>();
    private ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
    private ArrayList<BusinessFacility> businessFacilityArrayList = new ArrayList<BusinessFacility>();

    public Serializer(ArrayList<BusinessFacility> businessFacilityArrayList,
                      ArrayList<Vehicle> vehicleArrayList,
                      ArrayList<FoodItem> FoodItemArrayList,
                      ArrayList<Warehouse> warehouses) {
        this.businessFacilityArrayList = businessFacilityArrayList;
        this.vehicleArrayList = vehicleArrayList;
        this.FoodItemArrayList = FoodItemArrayList;
        this.warehouses = warehouses;
    }

    public void serialize() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.ser"));
            // save lists
            objectOutputStream.writeObject(warehouses);
            objectOutputStream.writeObject(FoodItemArrayList);
            objectOutputStream.writeObject(vehicleArrayList);
            objectOutputStream.writeObject(businessFacilityArrayList);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.ser"));

            warehouses = (ArrayList<Warehouse>)inputStream.readObject();
            FoodItemArrayList = (ArrayList<FoodItem>)inputStream.readObject();
            vehicleArrayList = (ArrayList<Vehicle>)inputStream.readObject();
            businessFacilityArrayList = (ArrayList<BusinessFacility>)inputStream.readObject();


            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public ArrayList<FoodItem> getFoodItemArrayList() {
        return FoodItemArrayList;
    }

    public ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    public ArrayList<BusinessFacility> getBusinessFacilityArrayList() {
        return businessFacilityArrayList;
    }

}
