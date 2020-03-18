/**
 * Represenation of vehicle
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 */

public class Vehicle {
    private String registrationNumber;
    private double volume;
    private double maxWeight;
    private double averageSpeed;

    // Constructors
    public Vehicle()
    {

    }

    public Vehicle(String registrationNumber, double averageSpeed)
    {
        this.registrationNumber = registrationNumber;
        this.averageSpeed = averageSpeed;
    }

    public Vehicle(String registrationNumber, double volume, double maxWeight, double averageSpeed)
    {
        this(registrationNumber, averageSpeed);
        this.volume = volume;
        this.maxWeight = maxWeight;
    }
    // Getters/Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    // Methods

    /**
     * Calculate travel time in days to run the route by vehicle
     * @param route vehicle's target route
     * @return travel days to run the route
     * @since 2020-03-18
     */
    public int calculateTravelTime(Route route)
    {
        int travelDays = 0;
        // distance -> km
        // average speed -> km/h

        double travelHours = route.getDistance() / this.averageSpeed;
        travelDays = (int)Math.ceil(travelHours / 24);

        return travelDays;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", volume=" + volume +
                ", maxWeight=" + maxWeight +
                ", averageSpeed=" + averageSpeed +
                '}';
    }
}
