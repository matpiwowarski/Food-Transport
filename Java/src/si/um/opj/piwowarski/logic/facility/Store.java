package si.um.opj.piwowarski.logic.facility;

import si.um.opj.piwowarski.logic.*;
/**
 * Represenation of store
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class Store extends BusinessFacility{

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
        super(name, location);
    }

    // Methods

    @Override
    public String toString() {
        return "Store{}" + super.toString();
    }
}
