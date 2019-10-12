package khusnutdinov.bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightArrivalComparator extends WritableComparator {

    // чекаем только код аэропорта
    public FlightArrivalComparator(){
        super(SharedKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b){
        SharedKey sharedKey1 = (SharedKey) a;
        SharedKey sharedKey2 = (SharedKey) b;
        System.out.println("AHAHAHSDHJJAHDKAHSGJDAGSJHDASJHGDAJHDHJAS");
        return sharedKey1.compareToFirstPart(sharedKey2);
    }
}
