package si.um.opj.piwowarski.logic.facility;

import java.util.Arrays;
import java.time.LocalDate;
import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.*;
import si.um.opj.piwowarski.logic.exception.CapacityExceededException;
import si.um.opj.piwowarski.logic.exception.FoodItemTypeException;
import si.um.opj.piwowarski.logic.exception.VolumeExceededException;
import si.um.opj.piwowarski.logic.transport.*;

/**
 * Represenation of warehouse
 *
 * @author  Mateusz Piwowarski
 * @since   2020-04-08
 * @version 4.0
 */

public class Warehouse extends BusinessFacility implements Transportable{
    private FoodItem[] foodItems;

    // Constructors

    /**
     * Create si.um.opj.piwowarski.logic.facility.Warehouse with name and location
     * @param name name of warehouse
     * @param location location of warehouse
     */
    private Warehouse(String name, Location location)
    {
        super(name, location);
    }

    /**
     * Create si.um.opj.piwowarski.logic.facility.Warehouse with name, location and capacity (size of foodItems array)
     * @param name name of warehouse
     * @param location location of warehouse
     * @param capacity size of foodItems array (food item count)
     */
    public Warehouse(String name, Location location, int capacity)
    {
        this(name,location);
        this.foodItems = new FoodItem[capacity];
    }

    // Getters/Setters
    /**
     * get array of food items
     * @return food items array
     */
    public FoodItem[] getFoodItems() {
        return foodItems;
    }

    /**
     * set array of food items
     * @param foodItems food items array
     */
    public void setFoodItems(FoodItem[] foodItems) {
        this.foodItems = foodItems;
    }

    // Methods

    private Boolean stillValid(FoodItem foodItem)
    {
        return foodItem.getExpirationDate().isAfter(LocalDate.now().plusDays(3));
    }

    /**
     * Checks if food item is valid and tries to add food item to the warehouse's array
     * @param foodItem food item that we want to add to the warehouse's array
     * @since 2020-03-31
     */
    public void addItem(FoodItem foodItem)
    {
        if(stillValid(foodItem))
        {
            for(int i = 0; i < this.foodItems.length;  i++)
            {
                if(this.foodItems[i] == null)
                {
                    this.foodItems[i] = foodItem; // adding
                    break;
                }
            }
            // no place in array = no adding new foodItem
        }// else fooItem is invalid
    }
    /**
     * Removes food item from the warehouse's array
     * @param foodItem food item that we want to remove from the warehouse's array
     * @since 2020-03-18
     */
    public void removeItem(FoodItem foodItem)
    {
        for(int i = 0; i < this.foodItems.length;  i++)
        {
            if(this.foodItems[i] == foodItem)
            {
                this.foodItems[i] = null; // deleting
                break;
            }
        }
    }

    public void removeAllItems()
    {
        for(int i = 0; i < this.foodItems.length;  i++)
        {
            if(this.foodItems[i] != null)
            {
                this.foodItems[i] = null; // deleting
            }
        }
    }
    /**
     * Count how many food items do we have in si.um.opj.piwowarski.logic.FoodItem array
     * @return count of food items in the si.um.opj.piwowarski.logic.FoodItem array
     * @since 2020-03-18
     */
    public int returnTheNumberOfFoodItems()
    {
        int count = 0;
        for(int i = 0; i < this.foodItems.length;  i++)
        {
            if(this.foodItems[i] != null)
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Checks if there is food item in foodItems array by label
     * @param label is label that we will find food item by
     * @return true/false if function found food item or not
     * @since 2020-03-18
     */
    public boolean foodItemExists(String label)
    {
        for(int i = 0; i < this.foodItems.length;  i++)
        {
            if(this.foodItems[i] != null)
            {
                if(this.foodItems[i].getLabel() == label)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * must load the accepted vehicle with food items that are currently in the warehouse.
     * Alert: loading of food items varies if the accepted vehicle is a Van or a Truck (hint: use operator instanceof)
     *
     * @param vehicle
     */

    public void acceptVehicle(Vehicle vehicle) throws CapacityExceededException, VolumeExceededException, FoodItemTypeException
    {
        int numberOfFoodItems = this.getNumberOfFoodItems();
        //Onto a truck, we can load a whole array of food items
        if(vehicle instanceof Truck)
        {
            vehicle.loadFoodItem(foodItems);
            // capacity

            if(vehicle.getCargo().length < numberOfFoodItems)
                throw new CapacityExceededException(vehicle.getCargo().length, numberOfFoodItems);
            // volume
            if(vehicle.getTakenSpace() > 1)
                throw new VolumeExceededException(vehicle.getRegistrationNumber(),vehicle.getVehicleMaxVolume());

            // success
            // foreach
            for(FoodItem item : vehicle.getCargo())
            {
                this.removeItem(item);
            }
        }
        // while loading onto a van is done one food item at a time.
        else if (vehicle instanceof  Van)
        {
            boolean volumeException = false;
            boolean foodItemException = false;
            // foreach
            for(FoodItem item : foodItems)
            {
                if(item != null)
                {
                    // capacity
                    if(vehicle.isFull())
                        throw new CapacityExceededException(vehicle.getCargo().length, numberOfFoodItems);

                    if(vehicle.checkSpaceForFoodItem(item))
                    {
                        if(((Van)vehicle).getFoodItemType() == item.getType())
                        {
                            vehicle.loadFoodItem(item);
                            // removing item if added to van
                            this.removeItem(item);
                        }
                        else
                        {
                            foodItemException = true;
                        }
                    }
                    else
                    {
                        volumeException = true;
                    }
                }
            }
            if(volumeException)
            {
                throw new VolumeExceededException(vehicle.getRegistrationNumber(),vehicle.getVehicleMaxVolume());
            }
            if(foodItemException)
            {
                throw new FoodItemTypeException(vehicle.getRegistrationNumber(),((Van)vehicle).getFoodItemType());
            }

        }
    }

    public int getNumberOfFoodItems()
    {
        int number = 0;
        for(int i = 0; i < this.foodItems.length;  i++)
        {
            if(this.foodItems[i] != null)
            {
                number++;
            }
        }
        return number;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                ", name='" + name + '\'' +
                ", location=" + location +
                "foodItems=" + Arrays.toString(foodItems) +
                '}';
    }
}
