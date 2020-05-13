package si.um.opj.piwowarski.logic.facility;

import si.um.opj.piwowarski.logic.*;
import si.um.opj.piwowarski.logic.transport.Vehicle;

/**
 * Represenation of store
 *
 * @author  Mateusz Piwowarski
 * @since   2020-04-08
 * @version 4.0
 */

public class Store extends BusinessFacility implements Transportable, java.io.Serializable{

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

    /**
     * The method acceptVehicle in the class Store unloads all food items from the vehicle.
     * @param vehicle
     */
    public void acceptVehicle(Vehicle vehicle)
    {
        vehicle.unloadFoodItems();
    }

    @Override
    public String toString() {
        return "Store{" + super.toString();
    }
}
