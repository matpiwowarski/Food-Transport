package si.um.opj.piwowarski.logic;

import si.um.opj.piwowarski.logic.exception.CapacityExceededException;
import si.um.opj.piwowarski.logic.exception.FoodItemTypeException;
import si.um.opj.piwowarski.logic.exception.VolumeExceededException;
import si.um.opj.piwowarski.logic.transport.Vehicle;

public interface Transportable {
    public void acceptVehicle(Vehicle vehicle) throws CapacityExceededException, FoodItemTypeException, VolumeExceededException;
}
