package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportsCSVWritable implements Writable {
    private Pair<String, String> airCSVPair;

    public AirportsCSVWritable(String airportCSV) {
        int divide;
        String id, nameAirport;
        if(!airportCSV.contains("Description")) {
            divide = airportCSV.indexOf(",");
            id = airportCSV.substring(2, divide - 2).replace("\"", "");
            nameAirport = airportCSV.substring(divide + 2, airportCSV.length() - 1).replace("\"", "");
            System.out.println( "\n***********\nName of airport is : " + nameAirport + "************\n");
            airCSVPair = new Pair<>(id, nameAirport);
        }
    }

    public Pair<String, String> getAirportsCSVPair() {
        return airCSVPair;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeChars(airCSVPair.getKey());
        dataOutput.writeChars(airCSVPair.getValue());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        String airportCSV = dataInput.readLine();
        int divide;
        String id, nameAirport;
        if(!airportCSV.contains("Description")) {
            divide = airportCSV.indexOf(",");
            id = airportCSV.substring(2, divide - 2).replace("\"", "");
            nameAirport = airportCSV.substring(divide + 2, airportCSV.length() - 1).replace("\"", "");
            System.out.println( "\n***********\nName of airport is : " + nameAirport + "************\n");
            airCSVPair = new Pair<>(id, nameAirport);
        }
    }
}
