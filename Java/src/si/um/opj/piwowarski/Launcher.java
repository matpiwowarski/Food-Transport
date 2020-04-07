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

        // food items
        FoodItem orange = new FoodItem("yellow Orange", 1, 10, java.time.LocalDate.now().plusYears(10));
        FoodItem banana = new FoodItem("green Banana", 1, 5, java.time.LocalDate.now().plusDays(10));
        FoodItem apple = new FoodItem("red Apple", 1, 3, java.time.LocalDate.now().plusDays(10));
        FoodItem bigOrange = new FoodItem("big yellow Orange", 5, 10, java.time.LocalDate.now().plusYears(10));
        FoodItem bigBanana = new FoodItem("big green Banana", 5, 5, java.time.LocalDate.now().plusDays(10));
        FoodItem bigApple = new FoodItem("big red Apple", 5, 3, java.time.LocalDate.now().plusDays(10));

        Location katowice = new Location("Katowice", "Poland");
        Store mmPanda = new Store("Katowice Store", katowice);

        // max volume = 30; array size = 10
        Truck bigTruck = new Truck("TRUCK123", 10, 3000, 70, 10, 3);
        // max volume = 10; array size = 5
        Van frozenVan = new Van("FROZEN123", 10,4000, 60, 5, FoodItemType.FROZEN);

        // warehouse with 100 items
        Warehouse wareHouse = new Warehouse("Katowice warehouse", katowice, 100);

        // ADDING ITEMS TO WAREHOUSE
        wareHouse.addItem(orange);
        wareHouse.addItem(banana);
        wareHouse.addItem(apple);
        wareHouse.addItem(bigOrange);
        wareHouse.addItem(bigBanana);
        wareHouse.addItem(bigApple);

        System.out.println(wareHouse);

    }
}
