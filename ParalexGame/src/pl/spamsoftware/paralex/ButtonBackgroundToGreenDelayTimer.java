package pl.spamsoftware.paralex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBackgroundToGreenDelayTimer implements ActionListener {
    private int buttonBackgroundDelay;
    private Timer backgroundToGreenDelay;
    private JButton jButton;
    private DatabaseInterface databaseInterface;

    ButtonBackgroundToGreenDelayTimer(JButton jButton, DatabaseInterface databaseInterface){
        this.jButton = jButton;
        this.databaseInterface = databaseInterface;
        buttonBackgroundDelay = 10;
        backgroundToGreenDelay = new Timer(1, this);
        backgroundToGreenDelay.setInitialDelay(0);
        backgroundToGreenDelay.start();
        setBackgroundToGreen();
    }
    private void setBackgroundToGreen(){
        jButton.setBackground(Color.GREEN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(buttonBackgroundDelay == 0){
            backgroundToGreenDelay.stop();
            databaseInterface.goodAnswer();
        }
        else{
            buttonBackgroundDelay--;
        }
    }
}
