package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;

public class AirportsCSVWritable {
    private Pair<String, String> airCSVPair;

    public AirportsCSVWritable(String airportCSV){
        if(airportCSV.contains(""))
        int divide = airportCSV.indexOf(",");
        this.airCSVPair = new Pair<>(airportCSV.substring(0, divide), airportCSV.substring(divide + 2, airportCSV.length() - 1));
    }

    public Pair<String, String> getAirportsPair(){
        return airCSVPair;
    }

}
