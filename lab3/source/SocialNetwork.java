package source;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SocialNetwork {
    private List<Profile> profiles;

    public SocialNetwork() {
        this.profiles = new ArrayList<>();
    }

    public void addProfile(Profile p) {
        profiles.add(p);
    }

    public int computeImportance(Profile target) {
        Set<Profile> uniqueConnections = new HashSet<>();

        if (target instanceof Person person) {
            uniqueConnections.addAll(person.getRelationships().keySet());
        }

        for (Profile p : profiles) {
            if (p instanceof Person person) {
                if (person.getRelationships().containsKey(target)) {
                    uniqueConnections.add(p);
                }
            }
        }

        return uniqueConnections.size();
    }

    public void printNetwork() {
        profiles.sort((p1, p2) -> Integer.compare(computeImportance(p2), computeImportance(p1)));

        System.out.println("=== Social Network Profiles (Ordered by Importance) ===");

        for (Profile p : profiles) {
            System.out.printf("\n[Importance: %d] %s\n", computeImportance(p), p.toString());

            if (p instanceof Person person) {
                Map<Profile, String> rels = person.getRelationships();

                if (rels.isEmpty()) {
                    System.out.println("   -> No outward connections.");
                } else {
                    for (Map.Entry<Profile, String> entry : rels.entrySet()) {
                        Profile connected = entry.getKey();
                        String how = entry.getValue();

                        if (connected instanceof Company) {
                            System.out.printf("   -> Works at: %s (Position: %s)\n", connected.getName(), how);
                        } else {
                            System.out.printf("   -> Knows: %s (How: %s)\n", connected.getName(), how);
                        }
                    }
                }
            }
        }
    }
}