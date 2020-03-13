public class Warehouse {
    private String name;
    private Location location;

    // Constructors
    public Warehouse()
    {

    }

    public Warehouse(String name, Location location)
    {
        this.name = name;
        this.location = location;
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
}
