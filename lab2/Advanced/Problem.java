package Advanced;


import java.util.ArrayList;
import java.util.List;

/**
 * Describes an instance of the routing problem.
 * Manages a collection of locations and the roads that connect them.
 */
class Problem {
    private List<Location> locations = new ArrayList<>();
    private List<Road> roads = new ArrayList<>();

    /**
     * Adds a new location to the problem instance.
     * The location is only added if it does not already exist in the list.
     *
     * @param loc the Location object to be added
     */
    public void addLocation(Location loc) {
        if (!locations.contains(loc)) {
            locations.add(loc);
        }
    }

    /**
     * Adds a new road to the problem instance.
     * The road is only added if it does not already exist in the list.
     *
     * @param road the Road object to be added
     */
    public void addRoad(Road road) {
        if (!roads.contains(road)) {
            roads.add(road);
        }
    }
    /**
     * Retrieves the list of all locations.
     * Needed by the Dijkstra algorithm to initialize its distances.
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Retrieves the list of all roads.
     * Needed by the Dijkstra algorithm to find connected neighbors.
     */
    public List<Road> getRoads() {
        return roads;
    }
    /**
     * Determines if the current problem instance is valid.
     * A problem is valid if all roads connect known locations that exist in the problem.
     *
     * @return true if the problem is valid, false otherwise
     */
    public boolean isValid() {
        for (Road road : roads) {
            if (!locations.contains(road.getLoc1()) || !locations.contains(road.getLoc2())) {
                return false;
            }
            if (road.getLoc1().equals(road.getLoc2())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if it is possible to travel from a starting location to a destination
     * using the available roads. This uses a Depth-First Search (DFS) algorithm.
     *
     * @param start the starting Location
     * @param end   the destination Location
     * @return true if a path exists between the start and end locations, false otherwise
     */
    public boolean isReachable(Location start, Location end) {
        List<Location> visited = new ArrayList<>();
        return dfs(start, end, visited);
    }

    // Note: Private methods usually don't need Javadoc, but you can add standard comments.
    private boolean dfs(Location current, Location target, List<Location> visited) {
        if (current.equals(target)) return true;
        visited.add(current);

        for (Road road : roads) {
            Location neighbor = null;
            if (road.getLoc1().equals(current)) neighbor = road.getLoc2();
            else if (road.getLoc2().equals(current)) neighbor = road.getLoc1();

            if (neighbor != null && !visited.contains(neighbor)) {
                if (dfs(neighbor, target, visited)) return true;
            }
        }
        return false;
    }
}
