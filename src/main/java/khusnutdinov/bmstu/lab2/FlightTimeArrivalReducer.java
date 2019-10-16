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
        int counter = 0;
        Double min = Double.MAX_VALUE, max = Double.MIN_VALUE, currentDelay, sum = 0.0;
        Iterator iterator = values.iterator();
        String airportName = iterator.next().toString();

        while(iterator.hasNext()){
            String token = iterator.next().toString();
            // not interesting case
            if (token.length() == 0){
                continue;
            }

            currentDelay = new Double(token);
            // not interesting case
            if (currentDelay == 0.0) {
                continue;
            }
            // init/update max and min values
            if(counter == 0 || max < currentDelay){
                max = currentDelay;
            }
            if(counter == 0 || min > currentDelay){
                min = currentDelay;
            }
            sum += currentDelay;
            counter += 1;
        }
        if(counter > 0){
            String infoString = "".concat("[Min: ".concat(min.toString().concat(", ")));
            infoString = infoString.concat("Max: ").concat(max.toString()).concat(", ");
            infoString = infoString.concat("Avg: ").concat((Math.round(sum/counter)).concat("];"));
            context.write(new Text(airportName), new Text(infoString));
        }
    }
}
