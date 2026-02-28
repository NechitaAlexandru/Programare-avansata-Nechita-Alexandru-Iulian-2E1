package Homework;


import java.util.Objects;

/**
 * Represents a road connecting two locations.
 * Reprezinta o strada sau un drum care conecteaza doua locatii diferite.
 */
class Road {
    private RoadType type;
    private double length;
    private int speedLimit;
    private Location loc1;
    private Location loc2;

    /**
     * Constructor pentru initializarea unui drum.
     * Lungimea drumului nu poate fi mai mica decat distanta Euclidiana dintre cele doua locatii.
     *
     * @param type tipul strazii
     * @param length lungimea strazii
     * @param speedLimit viteza maxima
     * @param loc1 prima locatie
     * @param loc2 a doua locatie
     */
    public Road(RoadType type, double length, int speedLimit, Location loc1, Location loc2) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.loc1 = loc1;
        this.loc2 = loc2;

        double distance = Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2));
        this.length = Math.max(length, distance); // Minimalist way to ensure length isn't less than distance
    }

    /**
     * @return prima locatie conectata de acest drum
     */
    public Location getLoc1() { return loc1; }

    /**
     * @return a doua locatie conectata de acest drum
     */
    public Location getLoc2() { return loc2; }

    /**
     * Overrides equals to prevent duplicate roads with the same endpoints and type.
     * Verifica egalitatea intre doua drumuri, luand in considerare ambele directii (A catre B este identic cu B catre A).
     *
     * @param obj obiectul cu care se compara
     * @return true daca drumurile conecteaza aceleasi locatii si au acelasi tip, false in caz contrar
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Road road = (Road) obj;
        return type == road.type &&
                ((Objects.equals(loc1, road.loc1) && Objects.equals(loc2, road.loc2)) ||
                        (Objects.equals(loc1, road.loc2) && Objects.equals(loc2, road.loc1))); // Handles both directions
    }

    /**
     * Genereaza un cod hash unic bazat pe tipul drumului si cele doua locatii.
     *
     * @return codul hash al drumului
     */
    public int hashCode() {
        return Objects.hash(type, loc1, loc2);
    }
}