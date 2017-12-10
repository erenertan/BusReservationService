import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;

public class Main implements ActionListener{


    static ArrayList<Voyage> listOfAllVoyages = new ArrayList();
    static ArrayList<Voyage> listOfMatchedVoyages = new ArrayList<>();

    Gui gui;
    Customer customer;
    int defaultCapasityOfVoyages;
    GetTimeAndDate getTimeAndDate = new GetTimeAndDate();

    /**
     *
     * @param gui
     * @param customer
     */
    public Main(Gui gui, Customer customer) {
        this.gui = gui;
        this.customer = customer;
    }

    /**
     * Sample comment for main method.
     * @param args
     */
    public static void main(String[] args) {
        Gui gui = new Gui();
        Customer customer = new Customer();
        Main main = new Main(gui, customer);
        main.defaultCapasityOfVoyages = 40;

        gui.main = main;
        customer.main = main;

        //Creating sample voyages and printing them.
        main.printVoyagesToTable(main.createVoyages(40));

//        main.printVoyagesToConsole();


    }

    //Creates voyages randomly
    //Todo:Order voyages depends on days.
    ArrayList<Voyage> createVoyages(int numberOfSampleVoyages) {
        String[] startingPointArr = {"Bursa", "Ankara", "Canakkale", "Istanbul", "Izmir", "Maraş", "Balıkkesir", "Erzincan", "Erzurum"};
        String[] endingPointArr = {"Bursa", "Ankara", "Canakkale", "Istanbul", "Izmir", "Maraş", "Balıkkesir", "Erzincan", "Erzurum"};


        //Create voyages up to numberOfSampleVoyages value .
        for (int i = 0; i < numberOfSampleVoyages; i++) {
//            System.out.println((int) (Math.random() * 5));
            String startingPoint = startingPointArr[(int) (Math.random() * 5)];
            String endingPoint = endingPointArr[(int) (Math.random() * 5)];

            int departureTime = (int) (Math.random() * 24) + 1;
            int endingTime = ((int) (Math.random() * 24)) + departureTime;

            if (departureTime == endingTime) {
                endingTime = (int) (Math.random() * 24) + 1;
            }

            //To prevent equality of departure and arrival points.
            if (startingPoint.equals(endingPoint)) {
                endingPoint = endingPointArr[(int) (Math.random() * 5)];
            }

            //Todo; Time class deprecated.
            listOfAllVoyages.add(new Voyage(startingPoint, endingPoint, getTimeAndDate.getRandomDay(),
                    new Time(departureTime, 00, 00), new Time(endingTime, 00, 00),
                    defaultCapasityOfVoyages));
        }


        return listOfAllVoyages;
    }


    //Prints all voyages in the list.
    void printVoyagesToConsole() {
        for (int i = 0; i < listOfAllVoyages.size(); i++) {
            System.out.println(listOfAllVoyages.get(i));
        }
    }

    void printVoyagesToTable(ArrayList<Voyage> voyagesList) {
        gui.reservationPanel.removeAll();
        gui.tableModel.setRowCount(0);

        for (Voyage voyage: voyagesList) {
            Object[] voyageData = {voyage.getId(), voyage.getDate(), voyage.getDeparturePoint(), voyage.getArrivalPoint(),
                    voyage.getDepartureTime(), voyage.getArrivalTime()};
            gui.tableModel.addRow(voyageData);
        }

        listOfMatchedVoyages.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(gui.findButton)) {
            listOfMatchedVoyages = customer.getVoyages(listOfAllVoyages, gui.dateField.getText(),
                    gui.departurePointField.getText(), gui.arrivalPointField.getText());
            printVoyagesToTable(listOfMatchedVoyages);
//            customer.getVoyages(listOfMatchedVoyages, "12/10/2017", "Izmir", "Bursa");
            //printVoyagesToConsole();   //Enable this to check voyages in console.
        } else if(e.getSource().equals(gui.tableModel)) {
            System.out.println("This is table.");
        }
    }
}