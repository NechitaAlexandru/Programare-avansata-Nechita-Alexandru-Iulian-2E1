package Homework;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class for testing the Homework requirements.
 */
public class Main {

    /**
     * Punctul de intrare in aplicatie (Entry point of the application).
     * Ruleaza un test simplu pentru a verifica validitatea problemei si conectivitatea.
     *
     * @param args argumentele primite din linia de comanda
     */
    public static void main(String[] args) {
        Problem problem = new Problem();

        Location iasi = new City("Iasi", 10.0, 20.0, 300000);
        Location vaslui = new City("Vaslui", 10.0, 50.0, 50000);
        Location otopeni = new Airport("Otopeni", 100.0, 200.0, 3);

        problem.addLocation(iasi);
        problem.addLocation(vaslui);
        problem.addLocation(otopeni);

        // Trying to add a duplicate (will be ignored because we overrode equals)
        problem.addLocation(new City("Iasi", 10.0, 20.0, 300000));

        Road r1 = new Road(RoadType.EXPRESS, 45.0, 100, iasi, vaslui);
        problem.addRoad(r1);

        System.out.println("Is the problem valid? " + problem.isValid());
        System.out.println("Can I reach Vaslui from Iasi? " + problem.isReachable(iasi, vaslui));
        System.out.println("Can I reach Otopeni from Iasi? " + problem.isReachable(iasi, otopeni));
    }
}