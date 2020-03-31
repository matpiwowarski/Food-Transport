package si.um.opj.piwowarski.logic.facility;

import si.um.opj.piwowarski.logic.*;
/**
 * Represenation of business facility
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class BusinessFacility {

    protected String name;
    protected Location location;

    // constructors

    public BusinessFacility()
    {

    }

    public BusinessFacility(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    // getters/setters

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

    // methods

    @Override
    public String toString() {
        return "BusinessFacility{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
