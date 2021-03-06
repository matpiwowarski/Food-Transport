package si.um.opj.piwowarski.logic.exception;

import si.um.opj.piwowarski.logic.FoodItem;

public class VolumeExceededException extends Exception {

    public String info;
    public EventGravity gravity = EventGravity.WARNING;

    public VolumeExceededException(String label, double volume, double emptyVolume) {

        info = " (VOLUME PROBLEM): " + label + " couldn't be loaded";
        info += "\t\t item volume: " + volume;
        info += "\t\t empty volume in vehicle: " + emptyVolume;
    }

    public VolumeExceededException()
    {

    }

    public VolumeExceededException(String registrationNumber, double vehicleMaxVolume) {
        info = " (VOLUME PROBLEM): vehicle " + registrationNumber + " couldn't be loaded";
        info += " ; vehicleMaxVolume = " + vehicleMaxVolume;
    }
}
