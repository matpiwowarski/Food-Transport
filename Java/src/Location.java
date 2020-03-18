public class Location {
    private String city;
    private String country;

    // Constructors
    public Location()
    {

    }

    public Location(String city, String country)
    {
        this.city = city;
        this.country = country;
    }

    // Getters/Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Methods
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("City: " + city);
        str.append(" Country: " + country);

        return str.toString();
    }
}
