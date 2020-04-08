package si.um.opj.piwowarski.logic.exception;

public class CapacityExceededException extends Exception {

    public String info;

    public CapacityExceededException(String label, int length) {
        info = "accepting vehicle failed (CAPACITY PROBLEM): " + label + " couldn't be loaded";
        info += "\t\t Vehicle Capacity: " + length;
    }

    public CapacityExceededException(int length, int length1) {
        info = "accepting vehicle failed (CAPACITY PROBLEM): vehicle capacity " + length;
        info += " ; foodItems capacity " + length1;
    }
}
