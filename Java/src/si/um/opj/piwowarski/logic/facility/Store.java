package si.um.opj.piwowarski.logic.facility;

/**
 * Represenation of store
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 * @version 2.0
 */

public class Store {
    private String name;
    private Location location;

    // Constructors

    /**
     * Create si.um.opj.piwowarski.logic.facility.Store with empty fields
     */
    public Store()
    {

    }

    /**
     * Create si.um.opj.piwowarski.logic.facility.Store with name and location
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
        return "si.um.opj.piwowarski.logic.facility.Store{" +
                "name='" + name + '\'' +
                ", location=" + location.toString() +
                '}';
    }
}
