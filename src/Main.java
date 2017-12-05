import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Main implements ActionListener{

    static ArrayList<Voyage> listOfAllVoyages = new ArrayList();
    static ArrayList<Voyage> listOfMatchedVoyages = new ArrayList<>();

    Gui gui;
    Customer customer;
    int defaultCapasityOfVoyages;

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

            //Todo; Time class deprecated.
            listOfAllVoyages.add(new Voyage(startingPoint, endingPoint, "12/10/2017",
                    new Time(12, 00, 00), new Time(16, 00, 00),
                    defaultCapasityOfVoyages));
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

    public static void main(String[] args) {
        Gui gui = new Gui();
        Customer customer = new Customer();
        Main main = new Main(gui, customer);
        main.defaultCapasityOfVoyages = 40;

        gui.main = main;
        customer.main = main;

        main.createVoyages();
        main.printVoyagesToConsole();

    }
}