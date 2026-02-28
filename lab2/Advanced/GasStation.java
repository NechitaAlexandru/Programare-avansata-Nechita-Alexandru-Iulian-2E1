package Advanced;


/**
 * Concrete class for a Gas Station.
 * Reprezinta o locatie de tip benzinarie, avand un pret specific pentru combustibil.
 */
final class GasStation extends Location {
    private double gasPrice;

    /**
     * Constructor pentru initializarea unei benzinarii.
     *
     * @param name numele benzinarieri
     * @param x coordonata x
     * @param y coordonata y
     * @param gasPrice pretul combustibilului
     */
    public GasStation(String name, double x, double y, double gasPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
    }
}