import java.sql.Time;
import java.util.Arrays;

public class Voyage {
    private double id;
    private String departurePoint;
    private String arrivalPoint;
    private String date;
    private Time departureTime, arrivalTime;
    private Seats seats;

    public Voyage(String departurePoint, String arrivalPoint, String date, Time departureTime, Time arrivalTime, Seats seats) {
        this.id = Math.random() + 1;   //Todo: Give a shape to id's
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
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

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "id='" + id + '\'' +
                ", departurePoint='" + departurePoint + '\'' +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", date=" + date +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", sittingPlan" + Arrays.toString(seats.sittingPlan) +
                '}';
    } //Todo: Print to console sitting plan accurately
}
