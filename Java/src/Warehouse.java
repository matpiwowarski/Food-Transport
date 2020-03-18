import java.util.Arrays;

/**
 * Represenation of warehouse
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 */

public class Warehouse {
    private String name;
    private Location location;
    private FoodItem[] foodItems;

    // Constructors

    /**
     * Create Warehouse with empty fields
     */
    private Warehouse()
    {

    }

    /**
     * Create Warehouse with name and location
     * @param name
     * @param location
     */
    private Warehouse(String name, Location location)
    {
        this.name = name;
        this.location = location;
    }

    /**
     * Create Warehouse with name, location and capacity (size of foodItems array)
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
     * get name of warehouse
     * @return name of warehouse
     */
    public String getName() {
        return name;
    }

    /**
     * set name of warehouse
     * @param name name of warehouse
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get location of warehouse
     * @return location of warehouse
     */
    public Location getLocation() {
        return location;
    }

    /**
     * set location of warehouse
     * @param location location of warehouse
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    // Methods

    /**
     * Adds food item to the warehouse's array
     * @param foodItem food item that we want to add to the warehouse's array
     * @since 2020-03-18
     */
    public void addItem(FoodItem foodItem)
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
    /**
     * Count how many food items do we have in FoodItem array
     * @return count of food items in the FoodItem array
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
     * Return information about object in String
     * @return information as String about object (with all the fields)
     */
    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                ", location=" + location.toString() +
                ", foodItems=" + Arrays.toString(foodItems) +
                '}';
    }
}
