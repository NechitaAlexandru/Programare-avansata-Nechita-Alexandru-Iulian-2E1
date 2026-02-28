package Advanced;


import java.util.ArrayList;
import java.util.List;

/**
 * Describes the solution to a routing problem.
 */
public class Solution {
    private List<Location> path;
    private double totalCost;

    public Solution(List<Location> path, double totalCost) {
        this.path = new ArrayList<>(path);
        this.totalCost = totalCost;
    }

    public List<Location> getPath() { return path; }
    public double getTotalCost() { return totalCost; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Route: ");
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i).getName());
            if (i < path.size() - 1) sb.append(" -> ");
        }
        sb.append("\nTotal Cost: ").append(String.format("%.2f", totalCost));
        return sb.toString();
    }
}