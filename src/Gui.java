import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener{
    private Main main;
    private JPanel findVoyagesPanel, makeReservationPanel, confirmReservationPanel;
    private JTabbedPane tabbedPane;
    private JLabel dateLabel, departurePointLabel, arrivalPointLabel;
    private JTextField dateField, departurePointField, arrivalPointField;
    private JButton findButton;
    DefaultTableModel tableModel;

    private JTable voyagesTable;



    private int widthOfGui = 1000;

    private int heightOfGui = 600;
    Gui() {
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
        makeReservationPanel = new JPanel();
        confirmReservationPanel = new JPanel();

        tabbedPane.addTab("FindVoyages", findVoyagesPanel);
        tabbedPane.addTab("MakeReservation", makeReservationPanel);
        tabbedPane.addTab("ConfirmReservation", confirmReservationPanel);

        designVoyagesPanel();

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



    private void createTable() {
        String [] columnNames = {"Id", "Date", "Departure Point", "Arrival Point", "Departure Time", "Arrival Time"};

        tableModel = new DefaultTableModel(null ,columnNames);
        voyagesTable = new JTable(tableModel);
        voyagesTable.getColumn("Id").setMaxWidth(75);
        voyagesTable.getColumn("Departure Point").setMaxWidth(75);
        voyagesTable.getColumn("Arrival Point").setMaxWidth(75);
        voyagesTable.setEnabled(false);

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
        Gui gui = new Gui();
    }
}
