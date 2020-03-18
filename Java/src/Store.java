/**
 * Represenation of store
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 */

public class Store {
    private String name;
    private Location location;

    // Constructors
    public Store()
    {

    }

    public Store(String name, Location location)
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

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", location=" + location.toString() +
                '}';
    }
}
