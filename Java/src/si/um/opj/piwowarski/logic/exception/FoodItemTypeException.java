package si.um.opj.piwowarski.logic.exception;

import si.um.opj.piwowarski.logic.FoodItemType;

public class FoodItemTypeException extends Exception{

    public String info;
    public EventGravity gravity = EventGravity.WARNING;

    public FoodItemTypeException( String registrationNumber, FoodItemType type) {
        info = " (FOODITEMTYPE PROBLEM): Vehicle " + registrationNumber;
        info += " is " + type + " type";
    }
}
