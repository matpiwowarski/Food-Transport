package si.um.opj.piwowarski.logic.transport;

import java.util.Arrays;
import si.um.opj.piwowarski.logic.*;
import si.um.opj.piwowarski.logic.exception.CapacityExceededException;
import si.um.opj.piwowarski.logic.exception.FoodItemTypeException;
import si.um.opj.piwowarski.logic.exception.VolumeExceededException;

/**
 * Represenation of vehicle
 *
 * @author  Mateusz Piwowarski
 * @since   2020-04-08
 * @version 4.0
 */

public abstract class Vehicle implements java.io.Serializable {
    protected String registrationNumber;
    protected double volume;
    protected double maxWeight;
    protected double averageSpeed;
    /** array of food items*/
    protected FoodItem[] cargo;

    /**
     * Create vehicle with empty fields
     */
    // Constructors
    public Vehicle()
    {

    }

    public Vehicle(int length) {
        this.cargo = new FoodItem[length];
    }

    /**
     * Create vehicle with registration number and average speed
     * @param registrationNumber vehicle's registration number
     * @param averageSpeed vehicle's average speed (km/h)
     */
    public Vehicle(String registrationNumber, double averageSpeed)
    {
        this.registrationNumber = registrationNumber;
        if(averageSpeed < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.averageSpeed = averageSpeed;
        }
    }

    /**
     * Create vehicle with registration number, volume, max weight and average speed
     * @param registrationNumber vehicle's registration number
     * @param volume vehicle's volume
     * @param maxWeight vehicle's max weight (kg)
     * @param averageSpeed vehicle's average speed (km/h)
     * @param length count of food items in vehicle's cargo array
     */
    public Vehicle(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length)
    {
        this(registrationNumber, averageSpeed);
        if(volume < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.volume = volume;
        }
        if(maxWeight < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.maxWeight = maxWeight;
        }
        this.cargo = new FoodItem[length];
    }
    // Getters/Setters

    public FoodItem[] getCargo() {
        return cargo;
    }

    public void setCargo(FoodItem[] cargo) {
        this.cargo = cargo;
    }

    /**
     * get vehicle's registration number
     * @return vehicle's registration number
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * set vehicle's registration number
     * @param registrationNumber vehicle's registration number
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * get vehicle's volume
     * @return vehicle's volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * set vehicle's volume
     * @param volume vehicle's volume
     */
    public void setVolume(double volume) {
        if(volume < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.volume = volume;
        }
    }

    /**
     * get vehicle's max weight (kg)
     * @return vehicle's max weight (kg)
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * set vehicle's max weight (kg)
     * @param maxWeight vehicle's max weight (kg)
     */
    public void setMaxWeight(double maxWeight) {
        if(maxWeight < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.maxWeight = maxWeight;
        }
    }

    /**
     * get vehicle's average speed (km/h)
     * @return vehicle's average speed (km/h)
     */
    public double getAverageSpeed() {
        return averageSpeed;
    }

    /**
     * set vehicle's average speed (km/h)
     * @param averageSpeed vehicle's average speed (km/h)
     */
    public void setAverageSpeed(double averageSpeed) {
        if(averageSpeed < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.averageSpeed = averageSpeed;
        }
    }

    // Methods

    public void unloadFoodItems()
    {
        Arrays.fill(this.cargo, null);
    }

    public double getTakenSpace()
    {
        double foodItemsVolume = 0;

        for(int i = 0; i < this.cargo.length;  i++)
        {
            if(this.cargo[i] != null)
            {
                foodItemsVolume += this.cargo[i].getVolume();
            }
        }

        double percentsTaken = foodItemsVolume / this.getVehicleMaxVolume();

        return percentsTaken;
    }

    public abstract double getVehicleMaxVolume();

    /**
     * Calculate travel time in days to run the route by vehicle
     * @param route vehicle's target route
     * @return travel days to run the route
     * @since 2020-03-18
     */
    public int calculateTravelTime(Route route)
    {
        int travelDays = 0;
        // distance -> km
        // average speed -> km/h

        double travelHours = route.getDistance() / this.averageSpeed;
        travelDays = (int)Math.ceil(travelHours / 24);

        return travelDays;
    }


    public void loadFoodItem(FoodItem foodItem)
    {
        // food item type is ok/ we are loading into truck
        for(int i = 0; i < this.cargo.length;  i++)
        {
            if (this.cargo[i] == null) {
                this.cargo[i] = foodItem; // adding
                break;
            }
        }
    }
    /**
     * Loads array of foodItems into the cargo array
      */
    public void loadFoodItem(FoodItem[] foodItems)
    {
        // foreach
        for(FoodItem item : foodItems)
        {
            if(item != null)
            {
                this.loadFoodItem(item);
            }
        }
    }

    public boolean isFull() {

        for(int i = 0; i < this.cargo.length;  i++)
        {
            if(this.cargo[i] == null)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", volume=" + volume +
                ", maxWeight=" + maxWeight +
                ", averageSpeed=" + averageSpeed +
                ", cargo=" + Arrays.toString(cargo) +
                '}';
    }

    public boolean checkSpaceForFoodItem(FoodItem item) {
        double space = this.getVehicleMaxVolume();

        double foodItemsVolume = 0;

        for(int i = 0; i < this.cargo.length;  i++)
        {
            if(this.cargo[i] != null)
            {
                foodItemsVolume += this.cargo[i].getVolume();
            }
        }

        double foodItemsVolumeWithNewItem = foodItemsVolume + item.getVolume();
        if(foodItemsVolumeWithNewItem > space)
            return false;

        return true;
    }
}
