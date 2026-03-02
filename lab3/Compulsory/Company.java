package Compulsory;
public class Company implements Profile, Comparable<Company> {
    private String id;
    private String name;

    public Company(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int compareTo(Company other) {
        if (this.name == null) return -1;
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Company{id='" + id + "', name='" + name + "'}";
    }
}