/**
 * User can run every methods here in main method
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-18
 */

public class Launcher {
    public static void main(String[] args) {

        FoodItem orange = new FoodItem("yellow Orange", 10, 10, java.time.LocalDate.now().plusYears(1));
        FoodItem banana = new FoodItem("green Banana", 5, 5, java.time.LocalDate.now().plusYears(3));
        FoodItem apple = new FoodItem("red Apple", 3, 3, java.time.LocalDate.now().plusYears(2));

        Location maribor = new Location("Maribor", "Slovenia");
        Location katowice = new Location("Katowice", "Poland");
        Store mmPanda = new Store("MM Panda", maribor);
        Vehicle ferrari = new Vehicle("XD123", 200, 3000, 150);
        Warehouse wareHouse = new Warehouse("Test warehouse", katowice, 10);
        Route testRoute = new Route(mmPanda, wareHouse, 600);

        // NEW WAREHOUSE METHODS

        wareHouse.addItem(orange);
        wareHouse.addItem(banana);
        wareHouse.addItem(apple);

        System.out.println("Do we have green Banana?: " + wareHouse.foodItemExists("green Banana"));
        System.out.println("food count: " + wareHouse.returnTheNumberOfFoodItems());

        System.out.println("Remove " + banana.toString());
        wareHouse.removeItem(banana);

        System.out.println("Do we have green Banana?: " + wareHouse.foodItemExists("green Banana"));
        System.out.println("food count: " + wareHouse.returnTheNumberOfFoodItems());

        // TESTING TO STRING()
        /*
        System.out.println(orange.toString());
        System.out.println(maribor.toString());
        System.out.println(katowice.toString());
        System.out.println(mmPanda.toString());
        System.out.println(ferrari.toString());
        System.out.println(wareHouse.toString());
         */

    }
}
