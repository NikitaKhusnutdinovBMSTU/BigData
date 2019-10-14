package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightsCSVWritable {

    private static final int DEST_AIRPORT_ID_INDEX = 14;
    private static final int FLIGHT_DELAY_INDEX = 17;
    private static final int TOTAL = 18;

    private Pair<String, String> csvFlightPair;

    public FlightsCSVWritable(String flightCSV){
        String id, delay;
        System.out.println(flightCSV);
        //избавляемся от первой колонки
        if(flightCSV.length() > 1 && !flightCSV.contains("YEAR")) {
            String[] table = flightCSV.split(",");
            if(table.length < TOTAL){
                return;
            }
            id = table[DEST_AIRPORT_ID_INDEX];
            delay = table[FLIGHT_DELAY_INDEX];
            if(!id.isEmpty() && !delay.isEmpty()) {
                this.csvFlightPair = new Pair<>(id, delay);
            }
        }
    }

    public Pair<String, String> getFlightsCSVPair(){
        return csvFlightPair;
    }


    public String getDestAirportID(){
        return csvFlightPair.getKey();
    }

    public String getFlightDelay(){
        return csvFlightPair.getValue();
    }

}
