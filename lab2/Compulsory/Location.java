/**
 Location Class
 **/
class Location {
    private String name;
    private String type;
    private double x;
    private double y;

    /**
     * @param name numele locatiei
     * @param type tipul locatiei (city, airport...)
     * @param x coordonata x
     * @param y coordonata y
     */
    public Location(String name, String type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Getters si setters
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
/**
 Modificam toString
 **/
    @Override
    public String toString() {
        return "Location{name='" + name + "', type='" + type + "', x=" + x + ", y=" + y + "}";
    }
}


