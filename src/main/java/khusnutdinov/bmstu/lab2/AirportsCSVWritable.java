package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;

public class AirportsCSVWritable {
    private Pair<String, String> airCSVPair;

    public AirportsCSVWritable(String airportCSV){
        int divide = airportCSV.indexOf(",");
        this.airCSVPair = new Pair<>(airportCSV.substring(0, divide), airportCSV.substring(divide + 1, airportCSV.length() - 1));
    }

    public Pair<String, String> getAirportsPair(){
        return airCSVPair;
    }

}
