package classes;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.spanning.KruskalMinimumSpanningTree;

import java.util.*;

public class MaintenanceRouting {

    public static List<Intersection> getMaintenanceRoute(City city) {
        List<Intersection> nodes = new ArrayList<>(city.getIntersections());


        Map<Intersection, Integer> nodeToId = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            nodeToId.put(nodes.get(i), i);
        }

        Graph graph = GraphBuilder.numVertices(nodes.size()).buildGraph();

        for (Street s : city.getStreets()) {
            int u = nodeToId.get(s.getU());
            int v = nodeToId.get(s.getV());

            graph.addEdge(u, v);
            graph.setEdgeWeight(u, v, s.getLength());
        }
       //kruskal
        KruskalMinimumSpanningTree mstAlg = new KruskalMinimumSpanningTree(graph);
        Graph mst = mstAlg.getTree();

        // (DFS)
        List<Intersection> route = new ArrayList<>();
        boolean[] visited = new boolean[nodes.size()];

        if (!nodes.isEmpty()) {
            dfs(0, mst, nodes, visited, route);
            route.add(nodes.get(0)); // Return to start
        }

        return route;
    }

    private static void dfs(int current, Graph mst, List<Intersection> nodes, boolean[] visited, List<Intersection> route) {
        visited[current] = true;
        route.add(nodes.get(current));

        int[] neighbors = mst.neighbors(current);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(neighbor, mst, nodes, visited, route);
            }
        }
    }
}