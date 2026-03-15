package classes;

import java.util.*;

public class City {
    private Set<Intersection> intersections = new HashSet<>();
    private List<Street> streets = new LinkedList<>();
    private Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public void addIntersection(Intersection i) {
        intersections.add(i);
        cityMap.putIfAbsent(i, new ArrayList<>());
    }

    public void addStreet(Street s) {
        streets.add(s);
        cityMap.get(s.getU()).add(s);
        cityMap.get(s.getV()).add(s);
    }

    public Set<Intersection> getIntersections() { return intersections; }
    public List<Street> getStreets() { return streets; }
    public Map<Intersection, List<Street>> getCityMap() { return cityMap; }
}