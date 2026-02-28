package Homework;


/**
 * Concrete class for a City.
 * Reprezinta o locatie de tip oras, adaugand o proprietate specifica pentru populatie.
 */
final class City extends Location {
    private int population;

    /**
     * Constructor pentru initializarea unui oras.
     *
     * @param name numele orasului
     * @param x coordonata x
     * @param y coordonata y
     * @param population populatia orasului
     */
    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }
}
