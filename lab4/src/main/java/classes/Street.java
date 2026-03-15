package classes;

public class Street implements Comparable<Street> {
    private String name;
    private double length;
    private Intersection u, v;

    public Street(String name, double length, Intersection u, Intersection v) {
        this.name = name;
        this.length = length;
        this.u = u;
        this.v = v;
    }

    public double getLength() { return length; }
    public Intersection getU() { return u; }
    public Intersection getV() { return v; }

    // Natural order given by implementing Comparable
    @Override
    public int compareTo(Street other) {
        return Double.compare(this.length, other.length);
    }

    @Override
    public String toString() {
        return name + " (" + length + ")";
    }
}