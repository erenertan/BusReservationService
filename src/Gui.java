import com.sun.org.apache.bcel.internal.generic.ObjectType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Vector;

public class Gui extends JFrame implements ActionListener{
    Main main;

    private JPanel findVoyagesPanel, reservationPanel, confirmReservationPanel;
    private JTabbedPane tabbedPane;
    private JLabel dateLabel, departurePointLabel, arrivalPointLabel;
    JTextField dateField;
    JTextField departurePointField;
    JTextField arrivalPointField;
    JButton findButton;
    DefaultTableModel tableModel;

    private JTable voyagesTable;

    private int rowNumber;
    private int sittingCapacity;

    private int widthOfGui = 1000;

    private int heightOfGui = 600;
    Gui(int sittingCapacity) {
        this.setSize(this.widthOfGui, this.heightOfGui);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setFocusable(false);
        setVisible(true);
        setSize(1000, 600);

        tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);

        findVoyagesPanel = new JPanel();
        findVoyagesPanel.setLayout(new BorderLayout());
        reservationPanel = new JPanel(new GridLayout(rowNumber, 5, 5, 5));
        confirmReservationPanel = new JPanel();

        tabbedPane.addTab("FindVoyages", findVoyagesPanel);
        tabbedPane.addTab("MakeReservation", reservationPanel);
        tabbedPane.addTab("ConfirmReservation", confirmReservationPanel);

        designVoyagesPanel();

        designReservationPanel(sittingCapacity);

    }

    private void designVoyagesPanel() {
        findVoyagesPanel.setLayout(new BorderLayout());
        JPanel entriesPanel = new JPanel(new GridLayout(2,4,2,2));

        //labels
        dateLabel = new JLabel("DATE");
        departurePointLabel = new JLabel("DEPARTURE POINT");
        arrivalPointLabel = new JLabel("ARRIVAL POINT");
        entriesPanel.add(dateLabel);
        entriesPanel.add(departurePointLabel);
        entriesPanel.add(arrivalPointLabel);
        entriesPanel.add(new JLabel());
        //TextFields
        dateField = new JTextField();
        departurePointField = new JTextField();
        arrivalPointField = new JTextField();
        entriesPanel.add(dateField);
        entriesPanel.add(departurePointField);
        entriesPanel.add(arrivalPointField);
        //Buttons
        findButton = new JButton("FIND");
        entriesPanel.add(findButton);
        findVoyagesPanel.add(entriesPanel,BorderLayout.NORTH);
        //Table
        createTable();
        findVoyagesPanel.add(new JScrollPane(voyagesTable), BorderLayout.CENTER);

        addActionListeners();
    }

    private void designReservationPanel(int sittingCapacity) {


        this.sittingCapacity = sittingCapacity;
        rowNumber = sittingCapacity/4;

        int index = 1;
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 2){
                    reservationPanel.add(new JLabel(""));
                }else{
                    addSeatsRandomly(index);
                    index++;
                }
            }
        }
    }

    private void addSeatsRandomly(int index){
        Random rnd =  new Random();
        int n = rnd.nextInt();
        if(n%2 == 0){
            reservationPanel.add(new Seat(index, selectGenderRandomly()));
        }else{
            reservationPanel.add(new Seat(index));
        }
    }

    private boolean selectGenderRandomly(){
        Random rnd =  new Random();
        int n = rnd.nextInt();
        boolean gender = n % 2 == 0;
        return gender;
    }


    private void createTable() {
        String [] columnNames = {"Id", "Date", "Departure Point", "Arrival Point", "Departure Time", "Arrival Time"};

        tableModel = new DefaultTableModel(null ,columnNames);
        voyagesTable = new JTable(tableModel);
        voyagesTable.getColumn("Id").setMaxWidth(75);
        voyagesTable.getColumn("Departure Point").setMaxWidth(75);
        voyagesTable.getColumn("Arrival Point").setMaxWidth(75);
        voyagesTable.setEnabled(true);
        voyagesTable.setCellSelectionEnabled(false);
        
        voyagesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {

                if (e.getClickCount() == 1) {
                    voyagesTable = (JTable)e.getSource();
                    int row = voyagesTable.getSelectedRow();
                    int column = voyagesTable.getSelectedColumn();

                    System.out.println("Row: " + row + "Column: " + column);
                    System.out.println(voyagesTable.getModel().getValueAt(row, column));
                }
            }
        });
    }


    private void addActionListeners() {
        //Voyages Panels
        dateField.addActionListener(this);
        departurePointField.addActionListener(this);
        arrivalPointField.addActionListener(this);
        findButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         main.actionPerformed(e);
    }

    public static void main(String[] args) {
        Gui gui = new Gui(30);
    }
}
