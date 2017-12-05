import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Seat extends JLabel {

    int index;
    boolean isEmpty = true;
    boolean gender;
    boolean isSelected;

    public Seat(int index, boolean gender) {
        super(Integer.toString(index));
        this.index = index;
        this.gender = gender;
        this.isEmpty = false;
        this.setOpaque(true);

        if (gender) {
            this.setBackground(Color.BLUE);

        } else {
            this.setBackground(Color.pink);

        }
    }

    public Seat(int index) {
        super(Integer.toString(index));
        this.index = index;
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
