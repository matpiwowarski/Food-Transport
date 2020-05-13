package si.um.opj.piwowarski.logic.transport;

import si.um.opj.piwowarski.logic.FoodItemType;

/**
 * Represenation of si.um.opj.piwowarski.logic.transport.Van
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class Van extends Vehicle implements java.io.Serializable{

    private FoodItemType foodItemType;

    // constructors

    public Van() {
    }

    public Van(int length) {
        super(length);
    }

    public Van(String registrationNumber, double averageSpeed) {
        super(registrationNumber, averageSpeed);
    }

    public Van(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length, FoodItemType foodItemType) {
        super(registrationNumber, volume, maxWeight, averageSpeed, length);
        this.foodItemType = foodItemType;
    }

    // getters/setters

    public FoodItemType getFoodItemType() {
        return foodItemType;
    }

    public void setFoodItemType(FoodItemType foodItemType) {
        this.foodItemType = foodItemType;
    }

    // methods

    @Override
    public double getVehicleMaxVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Van{" +
                "foodItemType=" + foodItemType + super.toString();
    }
}
