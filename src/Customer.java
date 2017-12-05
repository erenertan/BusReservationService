import java.sql.Time;
import java.util.ArrayList;

public class Customer {

    private String name, surname, gender;
    private int age;
    Main main;


    public Customer() {
    }

    //Get voyages by starting, ending points and date.
    void getVoyages(ArrayList<Voyage> allVoyagesList, String date, String departurePoint, String arrivalPoint) {
        //System.out.println("List of the voyages matched:");
        ArrayList<Voyage> listOfMatchedVoyages = new ArrayList<>();


/*
        //Example voyage to matched with properties.
        allVoyagesList.add(new Voyage(departurePoint, arrivalPoint, "12/10/2017",
                new Time(12, 00, 00), new Time(16, 00, 00), new Seats()));
*/

        for (Voyage voyage: allVoyagesList) {
            if (voyage.getDeparturePoint().equals(departurePoint) && voyage.getArrivalPoint().equals(arrivalPoint) && voyage.getDate().equals(date)) {
                listOfMatchedVoyages.add(voyage);
                //System.out.println(voyage);
            }
        }

        main.printVoyagesToTable(listOfMatchedVoyages);
    }

    void makeReservation() {

    }

    void confirmReservation() {

    }
}
