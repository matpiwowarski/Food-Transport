/**
 * Represenation of route with store, warehouse and distance between them
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 * @version 2.0
 */

public class Route {
    private Store store;
    private Warehouse warehouse;
    private double distance;

    // Constructors
    /**
     * Create Route with empty fields
     */
    public Route()
    {

    }

    /**
     * Create Route with Store object, Warehouse object and distance
     * @param store object of Store
     * @param warehouse object of Warehouse
     * @param distance distance between Store and Warehouse
     */
    public Route(Store store, Warehouse warehouse, double distance)
    {
        this.store = store;
        this.warehouse = warehouse;
        this.distance = distance;
    }

    // Getters/Setters

    /**
     * get store of the route
     * @return store of the route
     */
    public Store getStore() {
        return store;
    }

    /**
     * set store of the route
     * @param store store of the route
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * get warehouse of the route
     * @return warehouse of the route
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * set warehouse of the route
     * @param warehouse warehouse of the route
     */
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * get distance of the route
     * @return distance of the route
     */
    public double getDistance() {
        return distance;
    }

    /**
     * set distance of the route
     * @param distance distance of the route
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Methods
    /**
     * Return information about object in String
     * @return information as String about object (with all the fields)
     */
    @Override
    public String toString() {
        return "Route{" +
                "store=" + store.toString() +
                ", warehouse=" + warehouse.toString() +
                ", distance=" + distance +
                '}';
    }
}
