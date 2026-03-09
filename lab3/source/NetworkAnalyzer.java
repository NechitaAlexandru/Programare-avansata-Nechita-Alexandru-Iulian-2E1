package source;

import java.util.*;

public class NetworkAnalyzer {
    private Map<Profile, List<Profile>> adj;
    private int time;
    private Map<Profile, Integer> disc;
    private Map<Profile, Integer> low;
    private Map<Profile, Profile> parent;
    private Set<Profile> cutVertices;
    private List<Set<Profile>> biconnectedComponents;
    private Deque<Edge> stack;


    private record Edge(Profile u, Profile v) {}

    public NetworkAnalyzer(List<Profile> profiles) {
        adj = new HashMap<>();


        for (Profile p : profiles) {
            adj.putIfAbsent(p, new ArrayList<>());
            if (p instanceof Person person) {
                for (Profile neighbor : person.getRelationships().keySet()) {
                    adj.putIfAbsent(neighbor, new ArrayList<>());

                    if (!adj.get(p).contains(neighbor)) {
                        adj.get(p).add(neighbor);
                    }
                    if (!adj.get(neighbor).contains(p)) {
                        adj.get(neighbor).add(p);
                    }
                }
            }
        }
    }

    public void analyze() {
        time = 0;
        disc = new HashMap<>();
        low = new HashMap<>();
        parent = new HashMap<>();
        cutVertices = new HashSet<>();
        biconnectedComponents = new ArrayList<>();
        stack = new ArrayDeque<>();

        for (Profile p : adj.keySet()) {
            if (!disc.containsKey(p)) {
                dfs(p);


                if (!stack.isEmpty()) {
                    Set<Profile> component = new HashSet<>();
                    while (!stack.isEmpty()) {
                        Edge e = stack.pop();
                        component.add(e.u());
                        component.add(e.v());
                    }
                    if (component.size() > 1) {
                        biconnectedComponents.add(component);
                    }
                }
            }
        }
    }

    private void dfs(Profile u) {
        disc.put(u, time);
        low.put(u, time);
        time++;
        int children = 0;

        for (Profile v : adj.get(u)) {
            if (!disc.containsKey(v)) {
                children++;
                parent.put(v, u);
                stack.push(new Edge(u, v));

                dfs(v);

                low.put(u, Math.min(low.get(u), low.get(v)));


                if ((parent.get(u) == null && children > 1) ||
                        (parent.get(u) != null && low.get(v) >= disc.get(u))) {
                    cutVertices.add(u);

                    Set<Profile> component = new HashSet<>();
                    while (true) {
                        Edge e = stack.pop();
                        component.add(e.u());
                        component.add(e.v());
                        if (e.u().equals(u) && e.v().equals(v)) break;
                    }
                    biconnectedComponents.add(component);
                }
            } else if (v != parent.get(u) && disc.get(v) < disc.get(u)) {
                // Back edge found
                stack.push(new Edge(u, v));
                low.put(u, Math.min(low.get(u), disc.get(v)));
            }
        }
    }

    public Set<Profile> getCutVertices() { return cutVertices; }

    public List<Set<Profile>> getBiconnectedComponents() { return biconnectedComponents; }
}