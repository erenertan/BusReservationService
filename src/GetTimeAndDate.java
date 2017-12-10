import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class GetTimeAndDate {

    /**
     * Getting departure time, arrival time with this departure time.
     */
    public GetTimeAndDate() {
    }


    /**
     * Select random day from future.
     * @return string with date.
     */
    String getRandomDay() {
        //Genereting departure, arrival days and mounths.
        Date d1 = new Date(); //Get now
        Date d2 = new Date(118, 0, 28); //Get another day

        //Get random day between d1 and d2
        Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY"); //Format it
        //System.out.println(dateFormat.format(randomDate));
        return dateFormat.format(randomDate);
    }
}
