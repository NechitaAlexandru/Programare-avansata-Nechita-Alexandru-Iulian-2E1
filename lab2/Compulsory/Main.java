/**
 Main Class of the function
 **/
void main() {

    Location iasi = new Location("Iasi", "City", 10.0, 20.0);
    Location vaslui = new Location("Vaslui", "City", 10.0, 50.0);
    Location otopeni = new Location("Otopeni", "Airport", 100.0, 200.0);

    Road expressRoad = new Road("Express", 45.0, 100, iasi, vaslui);

    IO.println(iasi);
    IO.println(vaslui);
    IO.println(otopeni);
    IO.println(expressRoad);
}