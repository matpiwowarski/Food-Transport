package si.um.opj.piwowarski.logic.transport;

/**
 * Represenation of si.um.opj.piwowarski.logic.transport.Van
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class Van extends Vehicle {

    // constructors

    public Van() {
    }

    public Van(int length) {
        super(length);
    }

    public Van(String registrationNumber, double averageSpeed) {
        super(registrationNumber, averageSpeed);
    }

    public Van(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length) {
        super(registrationNumber, volume, maxWeight, averageSpeed, length);
    }

    // methods

    @Override
    public double getVehicleMaxVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "si.um.opj.piwowarski.logic.transport.Van{}" + super.toString();
    }
}
