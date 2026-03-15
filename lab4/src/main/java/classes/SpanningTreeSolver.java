package classes;

import java.util.*;
import java.util.stream.Collectors;

public class SpanningTreeSolver {


    public static List<List<Street>> getKSolutions(City city, int k) {
        List<List<Street>> allSolutions = new ArrayList<>();


        List<Street> baseMst = findMST(city, null);


        if (baseMst.size() < city.getIntersections().size() - 1) {
            return allSolutions;
        }
        allSolutions.add(baseMst);


        for (Street edgeToIgnore : baseMst) {
            List<Street> alternativeMst = findMST(city, edgeToIgnore);


            if (alternativeMst.size() == city.getIntersections().size() - 1) {
                allSolutions.add(alternativeMst);
            }
        }


        allSolutions.sort(Comparator.comparingDouble(SpanningTreeSolver::calculateTotalCost));


        return allSolutions.stream().limit(k).collect(Collectors.toList());
    }

    // Kruskal
    private static List<Street> findMST(City city, Street ignoredEdge) {
        List<Street> result = new ArrayList<>();

        //Sort by length
        List<Street> sortedStreets = new ArrayList<>(city.getStreets());
        sortedStreets.sort(Comparator.comparing(Street::getLength));


        Map<Intersection, Intersection> parent = new HashMap<>();
        for (Intersection i : city.getIntersections()) {
            parent.put(i, i);
        }

        for (Street street : sortedStreets) {
            if (street == ignoredEdge) continue; // Skip the excluded edge!

            Intersection rootU = findRoot(parent, street.getU());
            Intersection rootV = findRoot(parent, street.getV());


            if (!rootU.equals(rootV)) {
                result.add(street);
                parent.put(rootU, rootV);
            }
        }
        return result;
    }

    //metoda helper
    private static Intersection findRoot(Map<Intersection, Intersection> parent, Intersection i) {
        if (parent.get(i).equals(i)) return i;
        Intersection root = findRoot(parent, parent.get(i));
        parent.put(i, root);
        return root;
    }


    public static double calculateTotalCost(List<Street> tree) {
        return tree.stream().mapToDouble(Street::getLength).sum();
    }
}