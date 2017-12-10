import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame implements ActionListener{
    Main main;

    JPanel findVoyagesPanel, reservationPanel, confirmReservationPanel;
    private JTabbedPane tabbedPane;
    private JLabel dateLabel, departurePointLabel, arrivalPointLabel;
    //Todo:Add combo box to the voyage selection text fields.
    JTextField dateField;
    JTextField departurePointField;
    JTextField arrivalPointField;
    JButton findButton, showAllVoyages;
    DefaultTableModel tableModel;

    private JTable voyagesTable;

    private int rowNumber;

    private int widthOfGui = 1000;

    private int heightOfGui = 600;

    /**
     * Gui class is the view class. Creates tabs in frame.
     */
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
        reservationPanel = new JPanel(new GridLayout(rowNumber, 5, 5, 5));
        confirmReservationPanel = new JPanel();

        tabbedPane.addTab("FindVoyages", findVoyagesPanel);
        tabbedPane.addTab("MakeReservation", reservationPanel);
        tabbedPane.addTab("ConfirmReservation", confirmReservationPanel);

        designVoyagesPanel();

    }

    /**
     * Voyages panel designer method to find voyages depends on date, departure point or arrival point.
     * Creates components for these features.
     */
    //Todo:Add showAllVoyages button to voyages panel.
    //Todo:Highlight selected voyage in table
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


    /**
     * Shows sitting plans of a voyage at that time. It takes which voyage clicked at voyages panel.
     * @param sittingPlan Sitting plan of given voyage.
     */
    private void designReservationPanel(Seat[] sittingPlan) {
        reservationPanel.removeAll();

        rowNumber = sittingPlan.length/4;

        int indexOfSeatToAddPanel = 1;
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 2){
                    reservationPanel.add(new JLabel(""));
                }else{
                    reservationPanel.add(sittingPlan[indexOfSeatToAddPanel - 1]);
                    indexOfSeatToAddPanel++;
                }
            }
        }
    }

    /**
     * Method to create table which shows voyages.
     */
    private void createTable() {
        String [] columnNames = {"Id", "Date", "Departure Point", "Arrival Point", "Departure Time", "Arrival Time"};

        tableModel = new DefaultTableModel(null ,columnNames){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        voyagesTable = new JTable(tableModel);
        voyagesTable.setRowSelectionAllowed(true);
        voyagesTable.setEnabled(true);
        voyagesTable.setCellSelectionEnabled(false);

        voyagesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {

                if (e.getClickCount() == 1) {
                    voyagesTable = (JTable)e.getSource();
                    int row = voyagesTable.getSelectedRow();

                    System.out.println(voyagesTable.getModel().getValueAt(row, 0));

                    Voyage selectedVoyage = null;

                    for (Voyage voyage: main.listOfAllVoyages) {
                        if (voyage.getId() == (double) voyagesTable.getModel().getValueAt(row, 0)) {
                            selectedVoyage = voyage;
                        }
                    }

                    designReservationPanel(selectedVoyage.getSittingPlan());

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

}
