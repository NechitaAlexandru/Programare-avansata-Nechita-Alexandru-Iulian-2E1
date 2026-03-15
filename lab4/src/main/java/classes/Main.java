package classes;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        Intersection[] nodeArray = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        Set<Intersection> intersectionSet = new HashSet<>(Arrays.asList(nodeArray));

        List<Street> streetList = new LinkedList<>();
        streetList.add(new Street("S1", 10.5, nodeArray[0], nodeArray[1]));
        streetList.add(new Street("S2", 5.2, nodeArray[0], nodeArray[2]));
        streetList.add(new Street("S3", 8.0, nodeArray[1], nodeArray[2]));

        streetList.sort(Comparator.comparing(Street::getLength));
        System.out.println("Compulsory Sorted Streets: " + streetList);
        System.out.println("--------------------------------------------------");


        City city = new City();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            city.addIntersection(new Intersection(faker.address().streetName() + " Crossing"));
        }

        List<Intersection> cityNodes = new ArrayList<>(city.getIntersections());
        for (int i = 0; i < 20; i++) {
            Intersection u = cityNodes.get(faker.random().nextInt(cityNodes.size()));
            Intersection v = cityNodes.get(faker.random().nextInt(cityNodes.size()));
            if (!u.equals(v)) {
                city.addStreet(new Street(faker.address().streetName(), faker.number().randomDouble(2, 1, 20), u, v));
            }
        }

        double minLength = 5.0;
        List<Street> filteredStreets = city.getStreets().stream()
                .filter(s -> s.getLength() > minLength)
                .filter(s -> city.getCityMap().get(s.getU()).size() >= 3 || city.getCityMap().get(s.getV()).size() >= 3)
                .collect(Collectors.toList());

        System.out.println("Homework Filtered Streets Count: " + filteredStreets.size());
        System.out.println("--------------------------------------------------");

        int k = 3;
        List<List<Street>> topSolutions = SpanningTreeSolver.getKSolutions(city, k);

        if (topSolutions.isEmpty()) {
            System.out.println("The randomly generated city is disconnected.");
        } else {
            for (int i = 0; i < topSolutions.size(); i++) {
                List<Street> network = topSolutions.get(i);
                double cost = SpanningTreeSolver.calculateTotalCost(network);

                System.out.printf("Solution %d (Total Cost: %.2f)%n", i + 1, cost);
                for (Street s : network) {
                    System.out.println("  -> " + s.toString());
                }
            }
        }
    }
}