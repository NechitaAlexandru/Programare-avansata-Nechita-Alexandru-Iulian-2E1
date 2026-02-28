package Homework;


import java.util.Objects;

/**
 * Abstract sealed class representing a generic location.
 * Aceasta clasa este baza pentru toate tipurile de locatii (City, Airport, GasStation).
 */
abstract sealed class Location permits City, Airport, GasStation {
    private String name;
    private double x;
    private double y;

    /**
     * Constructor pentru initializarea unei locatii generice.
     *
     * @param name Numele locatiei
     * @param x coordonata x
     * @param y coordonata y
     */
    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * @return numele locatiei
     */
    public String getName() { return name; }

    /**
     * @return coordonata x a locatiei
     */
    public double getX() { return x; }

    /**
     * @return coordonata y a locatiei
     */
    public double getY() { return y; }

    /**
     * Overrides the default equals method to compare locations by name and coordinates.
     * Verifica daca doua locatii sunt identice pe baza numelui si coordonatelor.
     *
     * @param obj obiectul cu care se compara
     * @return true daca sunt identice, false in caz contrar
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return Double.compare(location.x, x) == 0 &&
                Double.compare(location.y, y) == 0 &&
                Objects.equals(name, location.name);
    }

    /**
     * Genereaza un cod hash unic bazat pe numele si coordonatele locatiei.
     *
     * @return codul hash al locatiei
     */
    public int hashCode() {
        return Objects.hash(name, x, y);
    }

    /**
     * Returneaza o reprezentare sub forma de sir de caractere a locatiei.
     *
     * @return un string continand numele, tipul clasei si coordonatele
     */
    public String toString() {
        return name + " (" + getClass().getSimpleName() + ") at " + x + ", " + y;
    }
}