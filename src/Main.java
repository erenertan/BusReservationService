import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;

public class Main implements ActionListener{

    static ArrayList<Voyage> listOfAllVoyages = new ArrayList();
    static ArrayList<Voyage> listOfMatchedVoyages = new ArrayList<>();

    Gui gui;
    Customer customer;

    public Main(Gui gui, Customer customer) {
        this.gui = gui;
        this.customer = customer;
    }

    //Create voyages randomly
    //Todo:There can be voyages to same city
    //Todo:Create different voyages with departure and arrival time.
    void createVoyages() {
        String[] startingPointArr = {"Bursa", "Ankara", "Canakkale", "Istanbul", "Izmir"};
        String[] endingPointArr = {"Bursa", "Bolu", "Edirne", "Istanbul", "Erzurum"};

        for (int i = 0; i < 5; i++) {
//            System.out.println((int) (Math.random() * 5));
            String startingPoint = startingPointArr[(int) (Math.random() * 5)];
            String endingPoint = endingPointArr[(int) (Math.random() * 5)];

            listOfAllVoyages.add(new Voyage(startingPoint, endingPoint, "12/10/2017",
                    new Time(12, 00, 00), new Time(16, 00, 00), new Seats()));
            //Todo; Time class deprecated.
        }

        printVoyagesToTable(listOfAllVoyages);
    }

    //Prints all voyages in the list.
    void printVoyagesToConsole() {
        for (int i = 0; i < listOfAllVoyages.size(); i++) {
            System.out.println(listOfAllVoyages.get(i));
        }
    }

    void printVoyagesToTable(ArrayList<Voyage> voyagesList) {
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
            customer.getVoyages(listOfAllVoyages, gui.dateField.getText(), gui.departurePointField.getText(), gui.arrivalPointField.getText());
//            customer.getVoyages(listOfMatchedVoyages, "12/10/2017", "Izmir", "Bursa");
            //printVoyagesToConsole();   //Enable this to check voyages in console.
        } else if(e.getSource().equals(gui.tableModel)) {
            System.out.println("This is table.");
        }
    }

    public static void main(String[] args) {
        Gui gui = new Gui(40);
        Customer customer = new Customer();
        Main main = new Main(gui, customer);

        gui.main = main;
        customer.main = main;

        main.createVoyages();
        main.printVoyagesToConsole();

    }
}