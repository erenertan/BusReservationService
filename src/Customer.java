import java.util.ArrayList;

public class Customer {

    private String name, surname, gender;
    private int age;
    Main main;


    /**
     * Customer class to simulate customer aspects from main class.
     */
    public Customer() {
    }

    /**
     * Gets voyages depends on user selection.
     * @param allVoyagesList All voyages in database.
     * @param date Parameter to find matched voyages with user input date.
     * @param departurePoint Parameter that takes departure point from user.
     * @param arrivalPoint Parameter that takes arrival point from user.
     * @return list of found voyages from all list depends on selection.
     */
    //Get voyages by starting, ending points and date.
    ArrayList<Voyage> getVoyages(ArrayList<Voyage> allVoyagesList, String date, String departurePoint, String arrivalPoint) {
        //System.out.println("List of the voyages matched:");
        ArrayList<Voyage> listOfMatchedVoyages = new ArrayList<>();

        /*//Example voyage to matched with properties.
        allVoyagesList.add(new Voyage(departurePoint, arrivalPoint, "12/10/2017",
                new Time(12, 00, 00), new Time(16, 00, 00), main.createSittingPlanForAVoyage(40)));
*/
        for (Voyage voyage: allVoyagesList) {
            if ((voyage.getDeparturePoint().toLowerCase().equals(departurePoint.toLowerCase()) || departurePoint.isEmpty()) &&
                    (voyage.getArrivalPoint().toLowerCase().equals(arrivalPoint.toLowerCase()) || arrivalPoint.isEmpty()) &&
                    ((voyage.getDate().equals(date)) || date.isEmpty())) {
                listOfMatchedVoyages.add(voyage);
                //System.out.println(voyage);
            }
        }

        return listOfMatchedVoyages;
    }

    void makeReservation() {

    }

    void confirmReservation() {

    }
}
