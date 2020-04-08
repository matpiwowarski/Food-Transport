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
        FoodItem orange = new FoodItem("Orange", 1, 10, java.time.LocalDate.now().plusYears(10), FoodItemType.FROZEN);
        FoodItem banana = new FoodItem("Banana", 1, 5, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);
        FoodItem apple = new FoodItem("Apple", 1, 3, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);
        FoodItem lemon = new FoodItem("Lemon", 1, 3, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);
        FoodItem strawberry = new FoodItem("Strawberry", 1, 3, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);

        // big food items
        FoodItem bigOrange = new FoodItem( "Big orange", 3, 10, java.time.LocalDate.now().plusYears(10), FoodItemType.FROZEN);
        FoodItem bigBanana = new FoodItem("Big banana", 5, 5, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);
        FoodItem bigApple = new FoodItem("Big apple", 5, 3, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);
        FoodItem bigLemon = new FoodItem("Big lemon", 10, 3, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);
        FoodItem bigStrawberry = new FoodItem("Big strawberry", 3, 3, java.time.LocalDate.now().plusDays(10), FoodItemType.FROZEN);

        Location katowice = new Location("Katowice", "Poland");
        Store store = new Store("Katowice Store", katowice);

        // max volume = 30; array size = 10
        Truck bigTruck = new Truck("TRUCK123", 10, 3000, 70, 10, 3);
        // max volume = 10; array size = 5
        Van frozenVan = new Van("FROZEN123", 10,4000, 60, 5, FoodItemType.FROZEN);
        // small truck
        Truck smallTruck = new Truck("SMALL123", 4, 3000, 70, 10, 2);

        // warehouse with 100 items
        Warehouse wareHouse = new Warehouse("Katowice warehouse", katowice, 100);

        // ADDING ITEMS TO WAREHOUSE
        wareHouse.addItem(apple);
        wareHouse.addItem(banana);
        wareHouse.addItem(lemon);
        wareHouse.addItem(strawberry);
        wareHouse.addItem(bigLemon);
        wareHouse.addItem(bigOrange);
        wareHouse.addItem(bigApple);
        wareHouse.addItem(bigBanana);
        wareHouse.addItem(bigStrawberry);
        wareHouse.addItem(orange);

        System.out.println("WAREHOUSE AT THE BEGINNING:");
        PrintFoodItemsLabels(wareHouse.getFoodItems());
        System.out.println();

        // LOADING FROM WAREHOUSE TO VAN
        System.out.println("VAN LOADING:");
        wareHouse.acceptVehicle(frozenVan);
        System.out.println();
        System.out.println("VAN AFTER LOADING:");
        PrintFoodItemsLabels(frozenVan.getCargo());
        System.out.println();
        System.out.println("WAREHOUSE AFTER LOADING VAN:");
        PrintFoodItemsLabels(wareHouse.getFoodItems());
        System.out.println();

        // LOADING FROM WAREHOUSE TO SMALL TRUCK
        System.out.println("SMALL TRUCK LOADING:");
        wareHouse.acceptVehicle(smallTruck);
        System.out.println();
        System.out.println("SMALL TRUCK AFTER LOADING:");
        PrintFoodItemsLabels(smallTruck.getCargo());
        System.out.println();
        System.out.println("WAREHOUSE AFTER LOADING SMALL TRUCK:");
        PrintFoodItemsLabels(wareHouse.getFoodItems());
        System.out.println();

        // LOADING FROM WAREHOUSE TO BIG TRUCK

        System.out.println("BIG TRUCK LOADING:");
        wareHouse.acceptVehicle(bigTruck);
        System.out.println();
        System.out.println("BIG TRUCK AFTER LOADING:");
        PrintFoodItemsLabels(bigTruck.getCargo());
        System.out.println();
        System.out.println("WAREHOUSE AFTER LOADING BIG TRUCK:");
        PrintFoodItemsLabels(wareHouse.getFoodItems());
        System.out.println();

        // LOADING FROM BIG TRUCK AND VAN TO THE STORE
        System.out.println("VAN UNLOADING:");
        store.acceptVehicle(frozenVan);
        System.out.println("BIG TRUCK UNLOADING:");
        store.acceptVehicle(bigTruck);
        System.out.println("VAN AFTER UNLOADING:");
        PrintFoodItemsLabels(frozenVan.getCargo());
        System.out.println("BIG TRUCK AFTER UNLOADING:");
        PrintFoodItemsLabels(bigTruck.getCargo());
        System.out.println();

        // BONUS PART:
        System.out.println("BONUS PART:");
        System.out.println();
        FoodItem frozenPotato = new FoodItem("Frozen Potato", 1, 10, java.time.LocalDate.now().plusYears(10), FoodItemType.FROZEN);
        FoodItem freshPotato = new FoodItem("Fresh Potato", 1, 10, java.time.LocalDate.now().plusYears(10), FoodItemType.FRESH);

        // ADDING FRESH AND FROZEN ITEMS INTO WAREHOUSE
        wareHouse.addItem(frozenPotato);
        wareHouse.addItem(freshPotato);
        System.out.println("WAREHOUSE AT THE BEGINNING:");
        PrintFoodItemsLabels(wareHouse.getFoodItems());
        System.out.println();
        // LOADING FROZEN VAN
        System.out.println("LOADING FROZEN VAN:");
        wareHouse.acceptVehicle(frozenVan);
        System.out.println();
        // FROZEN VAN AFTER LOADING
        System.out.println("FROZEN VAN AFTER LOADING:");
        PrintFoodItemsLabels(frozenVan.getCargo());
        System.out.println();
        // WAREHOUSE AFTER LOADING FROZEN VAN
        System.out.println("WAREHOUSE AFTER LOADING FROZEN VAN:");
        PrintFoodItemsLabels(wareHouse.getFoodItems());
    }

    // additional

    static public void PrintFoodItemsLabels(FoodItem[] foodItems)
    {
        StringBuilder str = new StringBuilder();
        int index = 1;

        // foreach
        for(FoodItem item : foodItems)
        {
            if(item != null)
            {
                str.append(index + ". ");
                str.append(item.getLabel());
                str.append("   ");
                index++;
            }
        }

        System.out.println(str.toString());
    }
}
