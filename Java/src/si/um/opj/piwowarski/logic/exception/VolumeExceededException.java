package si.um.opj.piwowarski.logic.exception;

import si.um.opj.piwowarski.logic.FoodItem;

public class VolumeExceededException extends Exception {

    public String info;

    public VolumeExceededException(String label, double volume, double emptyVolume) {

        info = " (VOLUME PROBLEM): " + label + " couldn't be loaded";
        info += "\t\t item volume: " + volume;
        info += "\t\t empty volume in vehicle: " + emptyVolume;
    }
}
