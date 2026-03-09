package source;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person implements Profile, Comparable<Person> {
    private String id;
    private String name;
    private LocalDate birthDate;
    private String nationality;
    private Map<Profile, String> relationships;

    public Person(String id, String name, LocalDate birthDate, String nationality) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.relationships = new HashMap<>();
    }

    public void addRelationship(Profile profile, String description) {
        this.relationships.put(profile, description);
    }

    public Map<Profile, String> getRelationships() {
        return relationships;
    }

    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public String getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int compareTo(Person other) {
        if (this.name == null) return -1;
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', nationality='%s', born='%s'}", name, nationality, birthDate);
    }
}