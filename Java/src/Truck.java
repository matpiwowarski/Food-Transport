/**
 * Represenation of Truck
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class Truck extends Vehicle {

    private int numberOfTrailers;

    // constructors

    public Truck(int numberOfTrailers) {
        this.numberOfTrailers = numberOfTrailers;
    }

    public Truck(int length, int numberOfTrailers) {
        super(length);
        this.numberOfTrailers = numberOfTrailers;
    }

    public Truck(String registrationNumber, double averageSpeed, int numberOfTrailers) {
        super(registrationNumber, averageSpeed);
        this.numberOfTrailers = numberOfTrailers;
    }

    public Truck(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length, int numberOfTrailers) {
        super(registrationNumber, volume, maxWeight, averageSpeed, length);
        this.numberOfTrailers = numberOfTrailers;
    }

    // methods

    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }

    public void setNumberOfTrailers(int numberOfTrailers) {
        this.numberOfTrailers = numberOfTrailers;
    }

    @Override
    public double getVehicleMaxVolume() {
        return this.numberOfTrailers * this.volume;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "numberOfTrailers=" + numberOfTrailers +
                '}' + super.toString();
    }
}
