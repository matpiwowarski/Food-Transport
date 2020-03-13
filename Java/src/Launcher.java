public class Launcher {
    public static void main(String[] args) {

        Location storeLocation = new Location("Maribor", "Slovenia");
        Location warehouseLocation = new Location("Katowice", "Poland");

        Store store = new Store("MM Panda", storeLocation);
        Warehouse warehouse = new Warehouse("Amir", warehouseLocation);

        Route route = new Route(store, warehouse, 634);

        Vehicle skoda = new Vehicle("COYG123", 80);

        System.out.println("From " + store.getName() + " To " + warehouse.getName() + " " + route.getDistance() + "km");
        System.out.println(skoda.calculateTravelTime(route) + " day/days");
    }
}
