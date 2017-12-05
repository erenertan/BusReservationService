import java.util.Arrays;

public class Seats {

    //Todo: Connect Seats with SeatSelection Class
    String sittingPlan[][];

    public Seats() {
        this.sittingPlan = new String[4][10];
    }

    public Seats(String[][] sittingPlan) {
        this.sittingPlan = sittingPlan;
    }

    public String[][] getSittingPlan() {
        return sittingPlan;
    }

    public void setSittingPlan(String[][] sittingPlan) {
        this.sittingPlan = sittingPlan;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "sittingPlan=" + Arrays.toString(sittingPlan) +
                '}';
    }
}
