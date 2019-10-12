package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightsCSVWritable implements Writable{

    private final static int DEST_AIRPORT_ID_INDEX = 14;
    private final static int FLIGHT_DELAY_INDEX = 17;

    private Pair<String, String> csvFlightPair;

    public FlightsCSVWritable(String flightCSV){
        String id, delay;
        //избавляемся от первой колонки
        if(flightCSV.length() > 1 && !flightCSV.contains("YEAR")) {
            String[] table = flightCSV.split(",");
            if(table.length < 18){
                return;
            }
            id = table[DEST_AIRPORT_ID_INDEX];
            delay = table[FLIGHT_DELAY_INDEX];
            this.csvFlightPair = new Pair<>(id, delay);
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

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeChars(csvFlightPair.getKey());
        dataOutput.writeChars(csvFlightPair.getValue());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        String flightCSV = dataInput.readLine();
        String id, delay;
        //избавляемся от первой колонки
        if(flightCSV.length() > 1 && !flightCSV.contains("YEAR")) {
            String[] table = flightCSV.split(",");
            if(table.length < 18){
                return;
            }
            id = table[DEST_AIRPORT_ID_INDEX];
            delay = table[FLIGHT_DELAY_INDEX];
            this.csvFlightPair = new Pair<>(id, delay);
        }
    }
}
