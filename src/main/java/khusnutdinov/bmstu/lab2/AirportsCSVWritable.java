package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;

public class AirportsCSVWritable {
    private Pair<String, String> airCSVPair;

    public AirportsCSVWritable(String airportCSV){
        String[] twoFoldColumn = airportCSV.split(" ");
        this.airCSVPair = new Pair<>(twoFoldColumn[0], twoFoldColumn[1]);
    }

}
