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
        Double min = Double.MAX_VALUE, max = Double.MIN_VALUE, currentDelay, sum = 0.0;
        int counter = 0;
        String airportName = iterator.next().toString();
        while(iterator.hasNext()){
            String token = iterator.next().toString();
            if (token.length() == 0){
                continue;
            }

            currentDelay = new Double(token);
            if (currentDelay == 0.0){
                continue;
            }
            counter++;
            if(counter == 0 || min > currentDelay){
                min = currentDelay;
            }
            if(counter == 0 || max < currentDelay){
                max = currentDelay;
            }
            sum += currentDelay;
        }
        if(counter > 0){
            String infoString = "".concat("[Min: ".concat(min.toString().concat(", ")));
            infoString = infoString.concat("Max: ").concat(max.toString()).concat(", ");
            infoString = infoString.concat("Avg: ").concat(new Double(sum/counter).toString().concat("];"));
            context.write(new Text(airportName), new Text(infoString));
        }

    }
}