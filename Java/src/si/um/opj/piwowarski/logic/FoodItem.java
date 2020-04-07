package si.um.opj.piwowarski.logic;

/**
 * Represenation of food item
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class FoodItem {
    private String label;
    private double volume;
    private double weight;
    private java.time.LocalDate expirationDate;
    private FoodItemType type;

    // constructors

    /**
     * Create food item with label
     * @param label label of food item
     */
    public FoodItem(String label)
    {
        this.label = label;
    }

    /**
     * Create food item with empty fields
     */
    public FoodItem()
    {

    }

    /**
     * Create food item with label, volume, weight, expirationDate
     * @param label label of food item
     * @param volume volume of food item
     * @param weight weight of food item in kilograms
     * @param expirationDate expiration date of food item (yyyy-mm-dd)
     */
    public FoodItem(String label, double volume, double weight, java.time.LocalDate expirationDate)
    {
        this(label);
        if(volume < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.volume = volume;
        }
        if( weight < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.weight = weight;
        }
        this.expirationDate = expirationDate;
    }

    // getters/setters

    public FoodItemType getType() {
        return type;
    }

    public void setType(FoodItemType type) {
        this.type = type;
    }

    /**
     * get food item's label
     * @return food item's label
     */
    public String getLabel() {
        return label;
    }

    /**
     * set food item's label
     * @param label food item's label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * get food item's volume
     * @return food item's volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * set food item's volume
     * @param volume food item's volume
     */
    public void setVolume(double volume) {
        if(volume < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.volume = volume;
        }
    }

    /**
     * get food item's weight (in kilograms)
     * @return food item's weight (in kilograms)
     */
    public double getWeight() {
        return weight;
    }

    /**
     * set food item's weight (in kilograms)
     * @param weight food item's weight (in kilograms)
     */
    public void setWeight(double weight) {
        if( weight < 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        else
        {
            this.weight = weight;
        }
    }

    /**
     * get food item's expiration date (yyyy-mm-dd)
     * @return food item's expiration date (yyyy-mm-dd)
     */
    public java.time.LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * set food item's expiration date (yyyy-mm-dd)
     * @param expirationDate food item's expiration date (yyyy-mm-dd)
     */
    public void setExpirationDate(java.time.LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // methods

    /**
     * Return information about object in String
     * @return information as String about object (with all the fields)
     */
    @Override
    public String toString() {
        return "FoodItem{" +
                "label='" + label + '\'' +
                ", volume=" + volume +
                ", weight=" + weight +
                ", expirationDate=" + expirationDate +
                ", type=" + type +
                '}';
    }
}
