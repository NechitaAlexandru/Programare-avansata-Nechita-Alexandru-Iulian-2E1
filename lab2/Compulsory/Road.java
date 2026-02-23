/**
 * Implementare clasa Road
 */
class Road {
    private String type;
    private double length;
    private int speedLimit;
    private Location loc1;
    private Location loc2;

    /**
     *
     * @param type tipul strazii
     * @param length lungimea strazii
     * @param speedLimit viteza permisa
     * @param loc1 prima localitate
     * @param loc2 a doua localitate
     */
    public Road(String type, double length, int speedLimit, Location loc1, Location loc2) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.loc1 = loc1;
        this.loc2 = loc2;
        /**
         Calculam distana folosind euclid
         **/
        double distance = Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) +
                Math.pow(loc1.getY() - loc2.getY(), 2));

        if (length < distance) {
            this.length = distance;
        } else {
            this.length = length;
        }
    }

    /**
     * Getters si Setters
     */
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public int getSpeedLimit() { return speedLimit; }
    public void setSpeedLimit(int speedLimit) { this.speedLimit = speedLimit; }

    public Location getLoc1() { return loc1; }
    public void setLoc1(Location loc1) { this.loc1 = loc1; }

    public Location getLoc2() { return loc2; }
    public void setLoc2(Location loc2) { this.loc2 = loc2; }

    /**
     * Implementam toString-ul
     */
    @Override
    public String toString() {
        return "Road{type='" + type + "', length=" + length + ", speedLimit=" + speedLimit +
                ", connects=" + loc1.getName() + " and " + loc2.getName() + "}";
    }
}