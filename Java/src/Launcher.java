public class Launcher {
    public static void main(String[] args) {

        FoodItem orange = new FoodItem("yellow Orange");
        Location maribor = new Location("Maribor", "Slovenia");
        Location katowice = new Location("Katowice", "Poland");
        Store mmPanda = new Store("MM Panda", maribor);
        Vehicle ferrari = new Vehicle("XD123", 150);

        Warehouse wareHouse = new Warehouse("Test warehouse", katowice, 10);
        wareHouse.addItem(orange);

        Route testRoute = new Route(mmPanda, wareHouse, 600);

        System.out.println(orange.toString());
        System.out.println(maribor.toString());
        System.out.println(katowice.toString());
        System.out.println(mmPanda.toString());
        System.out.println(ferrari.toString());
        System.out.println(wareHouse.toString());

    }
}
