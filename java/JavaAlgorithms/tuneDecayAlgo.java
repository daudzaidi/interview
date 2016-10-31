package JavaAlgorithms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shalvi on 21/06/16.
 */
public class tuneDecayAlgo {
    public static void main(String... args) throws ParseException {
        String str = "Oct 1 2016 23:11:52.454 UTC";
        double decay = 0;
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy HH:mm:ss:SSS zzz");
        long timePeriod = System.currentTimeMillis();
        for (int i = 1; i <= 31; i++) {
            str = "Aug " + i + " 2016 00:00:00:000 UTC";
            Date date = df.parse(str);
            long epoch = date.getTime();
            //System.out.println(epoch); // 1055545912454
            long r = epoch - timePeriod;
            double numHours = (double) r / (1000 * 60 * 60);
            //decay = -(Math.pow(1 / EXPONENT_FACTOR, -numHours / 24));
            decay = 8 - 0.018 * (Math.pow(numHours / 24, 2));
            System.out.println(decay);
        }
    }
}