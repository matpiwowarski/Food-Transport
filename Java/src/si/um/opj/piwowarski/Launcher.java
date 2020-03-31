package si.um.opj.piwowarski;

import si.um.opj.piwowarski.logic.*;
import si.um.opj.piwowarski.logic.facility.*;
import si.um.opj.piwowarski.logic.transport.*;

import java.io.Console;

/**
 * User can run every methods here in main method
 *
 * @author  Mateusz Piwowarski
 * @since   2020-03-31
 * @version 3.0
 */

public class Launcher {
    public static void main(String[] args) {

        FoodItem orange = new FoodItem("yellow Orange", 10, 10, java.time.LocalDate.now().plusYears(1));
        FoodItem banana = new FoodItem("green Banana", 5, 5, java.time.LocalDate.now().plusDays(4));
        FoodItem apple = new FoodItem("red Apple", 3, 3, java.time.LocalDate.now().plusDays(2));

        Location maribor = new Location("Maribor", "Slovenia");
        Location katowice = new Location("Katowice", "Poland");
        Store mmPanda = new Store("MM Panda", maribor);
        Truck bigTruck = new Truck("XD123", 50, 3000, 70, 10, 3);
        Van frozenVan = new Van("VAN", 50,4000, 60, 5, FoodItemType.FROZEN);
        Warehouse wareHouse = new Warehouse("Test warehouse", katowice, 10);
        Route testRoute = new si.um.opj.piwowarski.logic.Route(mmPanda, wareHouse, 600);

        // testing a)

        bigTruck.loadFoodItem(apple);
        bigTruck.loadFoodItem(orange);
        System.out.println(bigTruck);
        System.out.println("taken space: " + bigTruck.getTakenSpace());

        bigTruck.unloadFoodItems();
        System.out.println(bigTruck);
        System.out.println("taken space: " + bigTruck.getTakenSpace());

        // testing b)

        System.out.println("max volume: " + bigTruck.getVehicleMaxVolume());
        System.out.println("max volume: " + frozenVan.getVehicleMaxVolume());

        // testing c)
        wareHouse.addItem(orange);
        wareHouse.addItem(banana);
        wareHouse.addItem(apple); // expiration date = now + 2 days => shouldn't be added
        System.out.println(wareHouse);
    }
}
