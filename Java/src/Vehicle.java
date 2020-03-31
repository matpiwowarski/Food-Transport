/**
 * Represenation of vehicle
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 * @version 2.0
 */

public class Vehicle {
    private String registrationNumber;
    private double volume;
    private double maxWeight;
    private double averageSpeed;

    /**
     * Create vehicle with empty fields
     */
    // Constructors
    public Vehicle()
    {

    }

    /**
     * Create vehicle with registration number and average speed
     * @param registrationNumber vehicle's registration number
     * @param averageSpeed vehicle's average speed (km/h)
     */
    public Vehicle(String registrationNumber, double averageSpeed)
    {
        this.registrationNumber = registrationNumber;
        this.averageSpeed = averageSpeed;
    }

    /**
     * Create vehicle with registration number, volume, max weight and average speed
     * @param registrationNumber vehicle's registration number
     * @param volume vehicle's volume
     * @param maxWeight vehicle's max weight (kg)
     * @param averageSpeed vehicle's average speed (km/h)
     */
    public Vehicle(String registrationNumber, double volume, double maxWeight, double averageSpeed)
    {
        this(registrationNumber, averageSpeed);
        this.volume = volume;
        this.maxWeight = maxWeight;
    }
    // Getters/Setters

    /**
     * get vehicle's registration number
     * @return vehicle's registration number
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * set vehicle's registration number
     * @param registrationNumber vehicle's registration number
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * get vehicle's volume
     * @return vehicle's volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * set vehicle's volume
     * @param volume vehicle's volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * get vehicle's max weight (kg)
     * @return vehicle's max weight (kg)
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * set vehicle's max weight (kg)
     * @param maxWeight vehicle's max weight (kg)
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * get vehicle's average speed (km/h)
     * @return vehicle's average speed (km/h)
     */
    public double getAverageSpeed() {
        return averageSpeed;
    }

    /**
     * set vehicle's average speed (km/h)
     * @param averageSpeed vehicle's average speed (km/h)
     */
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
    /**
     * Return information about object in String
     * @return information as String about object (with all the fields)
     */
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
