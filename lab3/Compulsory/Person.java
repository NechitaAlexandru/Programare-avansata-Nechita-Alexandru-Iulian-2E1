package Compulsory;
import java.util.Arrays;

public class Person implements Profile, Comparable<Person> {
    private String id;
    private String name;


    private Acquaintance[] acquaintances;
    private int acquaintanceCount;

    private Employment[] employments;
    private int employmentCount;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;


        this.acquaintances = new Acquaintance[10];
        this.employments = new Employment[10];
        this.acquaintanceCount = 0;
        this.employmentCount = 0;
    }


    public void addAcquaintance(Person person, String relationshipType) {
        if (acquaintanceCount == acquaintances.length) {
            acquaintances = Arrays.copyOf(acquaintances, acquaintances.length * 2);
        }
        acquaintances[acquaintanceCount++] = new Acquaintance(person, relationshipType);
    }


    public void addEmployment(Company company, String position) {
        if (employmentCount == employments.length) {
            employments = Arrays.copyOf(employments, employments.length * 2);
        }
        employments[employmentCount++] = new Employment(company, position);
    }

    public Acquaintance[] getAcquaintances() {
        return Arrays.copyOf(acquaintances, acquaintanceCount);
    }

    public Employment[] getEmployments() {
        return Arrays.copyOf(employments, employmentCount);
    }

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
        return "Person{id='" + id + "', name='" + name + "'}";
    }
}


