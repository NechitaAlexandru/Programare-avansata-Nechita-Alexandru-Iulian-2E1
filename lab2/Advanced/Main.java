package Advanced;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class for testing the Homework and Bonus requirements.
 */
public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem();

        // 1. Create Locations
        City iasi = new City("Iasi", 10.0, 20.0, 300000);
        City vaslui = new City("Vaslui", 10.0, 50.0, 50000);
        City bacau = new City("Bacau", 50.0, 20.0, 150000);
        Airport otopeni = new Airport("Otopeni", 100.0, 200.0, 3);

        problem.addLocation(iasi);
        problem.addLocation(vaslui);
        problem.addLocation(bacau);
        problem.addLocation(otopeni);

        // 2. Create Roads
        // Route 1 (Through Vaslui): Shorter distance, but slow speed limit
        Road r1 = new Road(RoadType.COUNTRY, 40.0, 50, iasi, vaslui);
        Road r2 = new Road(RoadType.EXPRESS, 180.0, 100, vaslui, otopeni);

        // Route 2 (Through Bacau): Longer distance, but very fast speed limit
        Road r3 = new Road(RoadType.HIGHWAY, 60.0, 130, iasi, bacau);
        Road r4 = new Road(RoadType.HIGHWAY, 190.0, 130, bacau, otopeni);

        problem.addRoad(r1);
        problem.addRoad(r2);
        problem.addRoad(r3);
        problem.addRoad(r4);

        System.out.println("Is the problem valid? " + problem.isValid());

        // 3. Test Dijkstra Algorithm
        Dijkstra router = new Dijkstra(problem);

        System.out.println("\n--- Shortest Route (Optimized for Distance) ---");
        Solution shortest = router.findBestRoute(iasi, otopeni, false);
        System.out.println(shortest);

        System.out.println("\n--- Fastest Route (Optimized for Time) ---");
        Solution fastest = router.findBestRoute(iasi, otopeni, true);
        System.out.println(fastest);

        // 4. Test Performance for Bonus Points!
        System.out.println("\n--- Running Bonus Performance Test ---");
        testPerformance();
    }

    /**
     * Generates a large random problem to test algorithm performance and memory.
     * Required for the Bonus section of the assignment.
     */
    public static void testPerformance() {
        Problem bigProblem = new Problem();
        Random rand = new Random();
        int numLocations = 10000; // Generates 1,000 random cities!

        // Generate Random Locations
        List<Location> generatedLocs = new ArrayList<>();
        for (int i = 0; i < numLocations; i++) {
            City c = new City("City_" + i, rand.nextDouble() * 1000, rand.nextDouble() * 1000, 1000);
            bigProblem.addLocation(c);
            generatedLocs.add(c);
        }

        // Generate Random Roads between them
        for (int i = 0; i < numLocations * 2; i++) {
            Location l1 = generatedLocs.get(rand.nextInt(numLocations));
            Location l2 = generatedLocs.get(rand.nextInt(numLocations));
            if (!l1.equals(l2)) {
                bigProblem.addRoad(new Road(RoadType.EXPRESS, rand.nextDouble() * 100 + 10, 80, l1, l2));
            }
        }

        Dijkstra router = new Dijkstra(bigProblem);

        // Measure starting memory and time
        System.gc(); // Suggest to Java to clean up background memory first
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        // Run the algorithm on the massive map
        Solution sol = router.findBestRoute(generatedLocs.get(0), generatedLocs.get(numLocations - 1), false);

        // Measure ending memory and time
        long endTime = System.currentTimeMillis();
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
        System.out.println("Memory used: " + (endMemory - startMemory) / (1024 * 1024) + " MB");

        if (sol != null) {
            System.out.println("Success! Random path found with total cost: " + String.format("%.2f", sol.getTotalCost()));
        } else {
            System.out.println("No path happened to connect those two specific random nodes.");
        }
    }
}
