/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.util.Random;

class SeatSelection extends JFrame {

    private int rowNumber;
    private JPanel sittingPlanPanel = new JPanel(new GridLayout(rowNumber, 5, 5, 5));
    private int capacity;

    public SeatSelection(int capacity) {
        this.capacity = capacity;
        rowNumber = capacity/4;

        int index = 1;
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 2){
                sittingPlanPanel.add(new JLabel(""));
                }else{
                addSeatsRandomly(index);
                index++;
                }
            }
        }
        add(sittingPlanPanel);
        setTitle("Seat Selection Panel");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void addSeatsRandomly(int index){
        Random rnd =  new Random();
        int n = rnd.nextInt();
        if(n%2 == 0){
            sittingPlanPanel.add(new Seat(index, selectGenderRandomly()));
        }else{
            sittingPlanPanel.add(new Seat(index));
        }
    }

    boolean selectGenderRandomly(){
        Random rnd =  new Random();
        int n = rnd.nextInt();
        boolean gender = n % 2 == 0;
        return gender;
    }

}
