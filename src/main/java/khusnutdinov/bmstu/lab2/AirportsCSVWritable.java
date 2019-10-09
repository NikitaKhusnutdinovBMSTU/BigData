package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportsCSVWritable {

    private final static int END_OF_COLUMNS = 17;
    private final static int DEST_AIRPORT_ID_INDEX = 0;
    private final static int FLIGHT_DELAY_INDEX = 0;

    private Pair<String, String> csvDataPair;

    public AirportsCSVWritable(String dataIn){
       String[] table = dataIn.split(" ");
       this.csvDataPair = new Pair<>(table[DEST_AIRPORT_ID_INDEX], table[FLIGHT_DELAY_INDEX]);
    }

    public Pair<String, String> getAirportsCSVPair(){
        return csvDataPair;
    }

    public String getDestAirportID(){
        return csvDataPair.getKey();
    }

    public String getFlightDelay(){
        return csvDataPair.getValue();
    }
}
