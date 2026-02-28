package Compulsory;

/**
 * Main Class of the function
 */
public class Main {

    public static void main(String[] args) {

        Location iasi = new Location("Iasi", "City", 10.0, 20.0);
        Location vaslui = new Location("Vaslui", "City", 10.0, 50.0);
        Location otopeni = new Location("Otopeni", "Airport", 100.0, 200.0);

        Road expressRoad = new Road("Express", 45.0, 100, iasi, vaslui);

        System.out.println(iasi);
        System.out.println(vaslui);
        System.out.println(otopeni);
        System.out.println(expressRoad);
    }
}