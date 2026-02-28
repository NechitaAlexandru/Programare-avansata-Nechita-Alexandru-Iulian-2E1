package Advanced;

import java.util.*;

/**
 * Implements Dijkstra's algorithm to find the best route between locations.
 */
public class Dijkstra {
    private Problem problem;

    /**
     * @param problem the problem instance containing the map of locations and roads
     */
    public Dijkstra(Problem problem) {
        this.problem = problem;
    }

    /**
     * Finds the best route from start to end.
     *
     * @param start    The starting location
     * @param end      The destination location
     * @param fastest  If true, calculates based on time (length / speed). If false, calculates based on distance (length).
     * @return A Solution object containing the path, or null if no path is possible.
     */
    public Solution findBestRoute(Location start, Location end, boolean fastest) {
        Map<Location, Double> costs = new HashMap<>();
        Map<Location, Location> previousNode = new HashMap<>();

        // PriorityQueue to always evaluate the lowest-cost path first
        PriorityQueue<Location> queue = new PriorityQueue<>(Comparator.comparingDouble(costs::get));

        // Initialize all distances to infinity
        for (Location loc : problem.getLocations()) {
            costs.put(loc, Double.MAX_VALUE);
        }

        costs.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (current.equals(end)) break; // We reached the destination!

            for (Road road : problem.getRoads()) {
                Location neighbor = null;
                // Check if this road connects to our current location
                if (road.getLoc1().equals(current)) neighbor = road.getLoc2();
                else if (road.getLoc2().equals(current)) neighbor = road.getLoc1();

                if (neighbor != null) {
                    // Cost is either time (distance / speed) or just distance
                    double cost = fastest ? (road.getLength() / road.getSpeedLimit()) : road.getLength();
                    double newCost = costs.get(current) + cost;

                    // If we found a cheaper way to get to this neighbor, update it
                    if (newCost < costs.get(neighbor)) {
                        costs.put(neighbor, newCost);
                        previousNode.put(neighbor, current);

                        queue.remove(neighbor); // Refresh the queue priority
                        queue.add(neighbor);
                    }
                }
            }
        }

        // If the destination's cost is still infinity, it's unreachable
        if (costs.get(end) == Double.MAX_VALUE) {
            return null;
        }

        // Reconstruct the path backwards from the destination
        List<Location> path = new ArrayList<>();
        Location step = end;
        while (step != null) {
            path.add(step);
            step = previousNode.get(step);
        }
        Collections.reverse(path); // Flip it so it goes Start -> End

        return new Solution(path, costs.get(end));
    }
}