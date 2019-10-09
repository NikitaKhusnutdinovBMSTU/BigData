package khusnutdinov.bmstu.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightTimeArrivalReducer extends Reducer<SharedKey, Text, Text, Text> {
    /*
        Функция reduce должна извлекать имя аэропорта а затем расчитывать
        среднее/минимальное/максимальное время задержки
                                                                           */
    @Override
    protected void reduce(SharedKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        Iterator iterator = values.iterator();
    }
}
