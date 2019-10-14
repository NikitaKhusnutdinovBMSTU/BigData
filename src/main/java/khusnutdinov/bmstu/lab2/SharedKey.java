package khusnutdinov.bmstu.lab2;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/*ключ, который мы будем использовать для reduce side join (0 - это аэропорт, 1 - это перелет) */

public class SharedKey implements WritableComparable<SharedKey> {
    private String airportID;
    private int flag;

    //
    public SharedKey() {
        this.airportID = "null";
        this.flag = -1;
    }

    public SharedKey(String airportID, int flag){
        this.airportID = airportID;
        this.flag = flag;
    }

    public void write(DataOutput dataOutput) throws IOException{
        dataOutput.writeChars(airportID);
        dataOutput.writeInt(flag);
    }

    public void readFields(DataInput dataInput) throws IOException{
        String stringLine = dataInput.readLine();
        int sizeLine = stringLine.length();
        // считываем флаг
        flag = stringLine.charAt(sizeLine - 1);
        // остаток строки и есть ID
        airportID = stringLine.substring(0, sizeLine - 1);
    }

    public String getAirportID(){
        return airportID;
    }

    public int getFlag(){
        return flag;
    }

    public int compareToFirstPart(SharedKey other){
        return airportID.compareTo(other.getAirportID());
    }

    public int compareTo(SharedKey other){
        // сравниваем по строкам ID
        int airportIDCompare = airportID.compareTo(other.getAirportID());
        int otherFlag = other.getFlag();
        if(airportIDCompare == 0){
            return flag - otherFlag;
        }
        return airportIDCompare;
        /* если они равны, то тогда сравниваем по флагу,
            иначе отправляем сравнение строк            */
    }
}
