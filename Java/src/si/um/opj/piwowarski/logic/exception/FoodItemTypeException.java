package si.um.opj.piwowarski.logic.exception;

import si.um.opj.piwowarski.logic.FoodItemType;

public class FoodItemTypeException extends Exception{

    public String info;

    public FoodItemTypeException(String label, FoodItemType foodItemType, FoodItemType vanType) {
        info = " (FOODITEMTYPE PROBLEM): FoodItemLabel = " + label;
        info += " ; FoodItemType = " + foodItemType;
        info += " ; VanType = " + vanType;
    }
}
