package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;

public class AirportsCSVWritable {
    private Pair<String, String> airCSVPair;

    public AirportsCSVWritable(String airportCSV) {
        int divide;
        String id, nameAirport;
        if(!airportCSV.contains("Description")) {
            divide = airportCSV.indexOf(",");
            id = airportCSV.substring(2, divide - 2);
            nameAirport = airportCSV.substring(divide + 2, airportCSV.length() - 1);
            airCSVPair = new Pair<>(id, nameAirport);
        }
    }

    public Pair<String, String> getAirportsCSVPair() {
        return airCSVPair;
    }

}
