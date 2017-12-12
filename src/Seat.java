import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Seat extends JLabel {

    int index;
    int price;
    static Gui gui;
    boolean isEmpty = true;
    boolean gender;
    boolean isSelected;

    /**
     * There are number of seats at sitting plan for a voyage. Seats are creating with this class.
     * @param index Index of that seat to reserve it.
     * @param gender Gender of customer who reserved the seat.
     */
    public Seat(int index,int price, boolean gender) {
        super(Integer.toString(index));
        this.index = index;
        this.price = price;
        this.gender = gender;
        this.isEmpty = false;
        this.setOpaque(true);

        if (gender) {
            this.setBackground(Color.BLUE);

        } else {
            this.setBackground(Color.pink);

        }
    }

    /**
     * Seat class with mouse listener. These seats are created empty.
     * Customer will select these seats by clicking on that in reservation panel.
     * @param index
     */
    public Seat(int index, int price, Gui gui) {
        super(Integer.toString(index));
        Seat.gui = gui;
        this.index = index;
        this.price = price;
        this.isEmpty = false;
        this.isSelected = false;
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Seat activeSeat = (Seat)e.getSource();
                if(isSelected){
                    activeSeat.setBorder(BorderFactory.createEmptyBorder());
                    isSelected = false;
                }else{
                    activeSeat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    isSelected = true;
                }
            }

        });
    }


}
