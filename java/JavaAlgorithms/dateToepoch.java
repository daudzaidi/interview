package JavaAlgorithms;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by shalvi on 15/06/16.
 */
public class dateToepoch {

    public static void main(String[] args) throws Exception
    {
        String str = "Oct 1 2016 23:11:52.454 UTC";
        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
       // System.out.println(timeZone.getID());
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy HH:mm:SS z");
        df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));

        Date date = new Date(1475398800000L);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);
        System.out.println("UTC : "+formatted);
        format.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        formatted = format.format(date);
        System.out.println("America/Los_Angeles : "+formatted);


/*
        Date date2 = new Date(1475398800000L);
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format2.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted2 = format2.format(date);
        System.out.println("UTC : "+formatted2);
        format2.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        formatted2 = format2.format(date);
        System.out.println("America/Los_Angeles : "+formatted2);
*/

        /*for(int i=1;i<31;i++){
            str = "Oct "+i+" 2016 00:00:00";
            Date date = df.parse(str);
            long epoch = date.getTime();
            System.out.println(epoch); // 1055545912454
        }*/


        LocalDateTime nowInUtc = LocalDateTime.now(Clock.systemUTC());
        LocalDateTime currentTimeInLosAngeles = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));

       // System.out.println("JAVA 8 - Local Time UTC : "+nowInUtc);
       // System.out.println("JAVA 8 - Local Time Los Angeles : "+currentTimeInLosAngeles);

        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        long epoch = currentTimeInLosAngeles.atZone(losAngeles).toEpochSecond();
        //System.out.println("JAVA 8 - LOS ANGELES TIME IN EPOCH :"+ epoch);


        LocalDateTime dateFromEpochLA =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(1475400600000L), losAngeles);
        System.out.println("JAVA 8 - Local Time Los Angeles : "+dateFromEpochLA);

        long epochLA = dateFromEpochLA.atZone(losAngeles).toEpochSecond();
        System.out.println("JAVA 8 - LOS ANGELES TIME IN EPOCH :"+ epochLA);

        //midnight
        LocalDate dateMidnight = dateFromEpochLA.toLocalDate();
        System.out.println("JAVA 8 - LOS ANGELES TIME IN EPOCH :"+ dateMidnight.atStartOfDay());
        LocalDateTime dateFromEpochLAMidnight = dateMidnight.atStartOfDay();
        long epochLAMidnight = dateFromEpochLAMidnight.atZone(losAngeles).toEpochSecond();
        System.out.println("JAVA 8 - LOS ANGELES TIME IN EPOCH MIDNIGHT :"+ epochLAMidnight);


    }

}
