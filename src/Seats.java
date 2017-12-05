import java.util.Arrays;

public class Seats {

    //Todo: Connect Seats with SeatSelection Class

    Seat[] sittingPlan;

    public Seats(Seat[] sittingPlan) {
        this.sittingPlan = sittingPlan;
    }

    public Seat[] getSittingPlan() {
        return sittingPlan;
    }

    public void setSittingPlan(Seat[] sittingPlan) {
        this.sittingPlan = sittingPlan;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "sittingPlan=" + Arrays.toString(sittingPlan) +
                '}';
    }
}
