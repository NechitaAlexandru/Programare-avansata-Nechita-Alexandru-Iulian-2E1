package Homework;

/**
 * Concrete class for an Airport.
 * Reprezinta o locatie de tip aeroport, avand un numar specific de terminale.
 */
final class Airport extends Location {
    private int terminals;

    /**
     * Constructor pentru initializarea unui aeroport.
     *
     * @param name numele aeroportului
     * @param x coordonata x
     * @param y coordonata y
     * @param terminals numarul de terminale ale aeroportului
     */
    public Airport(String name, double x, double y, int terminals) {
        super(name, x, y);
        this.terminals = terminals;
    }
}