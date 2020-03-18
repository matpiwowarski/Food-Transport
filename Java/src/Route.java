public class Route {
    private Store store;
    private Warehouse warehouse;
    private double distance;

    // Constructors
    public Route()
    {

    }

    public Route(Store store, Warehouse warehouse, double distance)
    {
        this.store = store;
        this.warehouse = warehouse;
        this.distance = distance;
    }

    // Getters/Setters
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Methods

    @Override
    public String toString() {
        return "Route{" +
                "store=" + store.toString() +
                ", warehouse=" + warehouse.toString() +
                ", distance=" + distance +
                '}';
    }
}
