package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;


public class AirportsCSVWritable{

    private Pair<String, String> airCSVPair;

    public AirportsCSVWritable(String airportCSV) {
        int divide;
        String airportID, nameAirport;

        if(!airportCSV.contains("Description")) {
            divide = airportCSV.indexOf(",");
            // troubles with parse ""STRING"" -> added + 1 for each substring pos
            airportID = airportCSV.substring(1, divide - 1);
            nameAirport = airportCSV.substring(divide + 2, airportCSV.length() - 1);
            if(!airportID.isEmpty() && !nameAirport.isEmpty()) {
                airCSVPair = new Pair<>(airportID, nameAirport);
            }
        }
    }

    public Pair<String, String> getAirCSVPair() {

        return airCSVPair;
    }

}
