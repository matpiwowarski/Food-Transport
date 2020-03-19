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

    /**
     * Create Store with empty fields
     */
    public Store()
    {

    }

    /**
     * Create Store with name and location
     * @param name name of the store
     * @param location location of the store
     */
    public Store(String name, Location location)
    {
        this.name = name;
        this.location = location;
    }

    // Getters/Setters

    /**
     * get name of the store
     * @return name of the store
     */
    public String getName() {
        return name;
    }

    /**
     * set name of the store
     * @param name name of the store
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get location of the store
     * @return location of the store
     */
    public Location getLocation() {
        return location;
    }

    /**
     * set location of the store
     * @param location location of the store
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    // Methods
    /**
     * Return information about object in String
     * @return information as String about object (with all the fields)
     */
    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", location=" + location.toString() +
                '}';
    }
}
