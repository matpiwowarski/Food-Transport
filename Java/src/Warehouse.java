import java.util.Arrays;

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

    public boolean foodItemExists(String label)
    {
        for(int i = 0; i < this.foodItems.length;  i++)
        {
            if(this.foodItems[i].getLabel() == label)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: " + name);
        str.append(" Location: " + location.toString());
        str.append(" Food Items: " + Arrays.toString(foodItems));

        return str.toString();
    }
}
