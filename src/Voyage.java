import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Voyage {

    static Gui gui;
    private double id;
    private String departurePoint;
    private String arrivalPoint;
    private String date;
    private Time departureTime, arrivalTime;
    private Seat[] sittingPlan;
    private int defaultSeatPrice = 50;

    /**
     *
     * @param gui Interface manager(Gui class) to push index of seats
     * @param departurePoint Departure point of voyage.
     * @param arrivalPoint Arrival point of voyage
     * @param date Departure date of voyage.
     * @param departureTime Departure time of voyage.
     * @param arrivalTime Arrival time to arrival point of voyage.
     * @param voyageCapacity Sitting capacity of voyage.
     */
    public Voyage(Gui gui, String departurePoint, String arrivalPoint, String date, Time departureTime,
                  Time arrivalTime, int voyageCapacity) {
        this.gui = gui;
        this.id = Math.random() + 1;   //Todo: Give a shape to id's
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.sittingPlan = createSittingPlan(voyageCapacity);
    }

    /**
     * Takes voyage capacity as paramater from constructor and creates sitting plan for the voyage.
     * @param voyageCapacity Number of voyage capacity.
     * @return sitting plan for the voyage.
     */
    private Seat[] createSittingPlan(int voyageCapacity) {
        Seat[] sittingPlan = new Seat[voyageCapacity];

        for (int i = 1; i <= voyageCapacity; i++) {
            Random rnd =  new Random();
            int n = rnd.nextInt();
            if(n%2 == 0){
                sittingPlan[i - 1] = new Seat(i, defaultSeatPrice, selectGenderRandomly());
            }else{
                sittingPlan[i - 1] = new Seat(i, defaultSeatPrice ,gui);
            }
        }

        return sittingPlan;
    }

    /**
     * Creates random gender for voyages.
     * @return Gender of seat.
     */
    private boolean selectGenderRandomly(){
        Random rnd =  new Random();
        int n = rnd.nextInt();
        boolean gender = n % 2 == 0;
        return gender;
    }



    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Seat[] getSittingPlan() {
        return sittingPlan;
    }

    public void setSittingPlan(Seat[] sittingPlan) {
        this.sittingPlan = sittingPlan;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "id=" + id +
                ", departurePoint='" + departurePoint + '\'' +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", date='" + date + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
