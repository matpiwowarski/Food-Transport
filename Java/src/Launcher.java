/**
 * User can run every methods here in main method
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 * @version 2.0
 */

public class Launcher {
    public static void main(String[] args) {

        FoodItem orange = new FoodItem("yellow Orange", 10, 10, java.time.LocalDate.now().plusYears(1));
        FoodItem banana = new FoodItem("green Banana", 5, 5, java.time.LocalDate.now().plusYears(3));
        FoodItem apple = new FoodItem("red Apple", 3, 3, java.time.LocalDate.now().plusYears(2));

        Location maribor = new Location("Maribor", "Slovenia");
        Location katowice = new Location("Katowice", "Poland");
        Store mmPanda = new Store("MM Panda", maribor);
        Vehicle ferrari = new Vehicle("XD123", 200, 3000, 150, 10);
        Warehouse wareHouse = new Warehouse("Test warehouse", katowice, 10);
        Route testRoute = new Route(mmPanda, wareHouse, 600);




    }
}
