package si.um.opj.piwowarski.logic;

/**
 * Represenation of location
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 * @version 2.0
 */

public class Location {
    private String city;
    private String country;

    // Constructors

    /**
     * Create si.um.opj.piwowarski.logic.Location with empty fields
     */
    public Location()
    {

    }

    /**
     * Create si.um.opj.piwowarski.logic.Location with name of city and name of country
     * @param city name of city
     * @param country name of country
     */
    public Location(String city, String country)
    {
        this.city = city;
        this.country = country;
    }

    // Getters/Setters
    /**
     * get city name of location
     * @return city name of location
     */
    public String getCity() {
        return city;
    }

    /**
     * set city name of location
     * @param city city name of location
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get country name of location
     * @return country name of location
     */
    public String getCountry() {
        return country;
    }

    /**
     * set country name of location
     * @param country country name of location
     */
    public void setCountry(String country) {
        this.country = country;
    }

    // Methods
    /**
     * Return information about object in String
     * @return information as String about object (with all the fields)
     */
    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
