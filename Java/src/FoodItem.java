/**
 * FoodItem Class
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 */

public class FoodItem {
    private String label;
    private double volume;
    private double weight;
    private java.time.LocalDate expirationDate;

    // constructors

    public FoodItem(String label)
    {
        this.label = label;
    }

    public FoodItem()
    {

    }

    public FoodItem(String label, double volume, double weight, java.time.LocalDate expirationDate)
    {
        this(label);
        this.volume = volume;
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    // getters/setters

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public java.time.LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(java.time.LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // methods

    @Override
    public String toString() {
        return "FoodItem{" +
                "label='" + label + '\'' +
                ", volume=" + volume +
                ", weight=" + weight +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
