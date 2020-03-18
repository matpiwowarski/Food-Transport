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
    private Warehouse()
    {

    }

    private Warehouse(String name, Location location)
    {
        this.name = name;
        this.location = location;
    }

    public Warehouse(String name, Location location, int capacity)
    {
        this(name,location);
        this.foodItems = new FoodItem[capacity];
    }

    // Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

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

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                ", location=" + location.toString() +
                ", foodItems=" + Arrays.toString(foodItems) +
                '}';
    }
}
