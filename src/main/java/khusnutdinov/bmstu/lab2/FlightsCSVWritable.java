package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightsCSVWritable {

    private final static int DEST_AIRPORT_ID_INDEX = 14;
    private final static int FLIGHT_DELAY_INDEX = 17;

    private Pair<String, String> csvFlightPair;

    public FlightsCSVWritable(String flightCSV){
       String[] table = flightCSV.split(",");
       System.out.println(table[DEST_AIRPORT_ID_INDEX] + "======" + table[FLIGHT_DELAY_INDEX]);
       this.csvFlightPair = new Pair<>(table[DEST_AIRPORT_ID_INDEX], table[FLIGHT_DELAY_INDEX]);
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
