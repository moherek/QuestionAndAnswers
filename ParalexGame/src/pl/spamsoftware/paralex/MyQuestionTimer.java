package pl.spamsoftware.paralex;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyQuestionTimer implements ActionListener{
    private Timer questionTimer;
    public static final int MAX_TIME = 15;
    private int counter;
    private int delay = 1000;
    private DatabaseInterface databaseInterface;
    private ActionListener actionListener;

    MyQuestionTimer(DatabaseInterface databaseInterface, ActionListener actionListener){
        this.databaseInterface = databaseInterface;
        this.actionListener = actionListener;
        counter = MAX_TIME;
        questionTimer = new Timer(delay, this);
        questionTimer.setInitialDelay(0);
        questionTimer.start();
    }

    public int getCounter() {
        return counter;
    }
    public void restartTimer(){
        questionTimer.stop();
        counter = MAX_TIME;
        questionTimer.start();
    }
    public void stopTimer(){
        questionTimer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(counter == 0)
        {
            questionTimer.stop();
            databaseInterface.badAnswer();
            actionListener.actionPerformed(e);
        }
        else
        {
            counter--;
            actionListener.actionPerformed(e);
        }

    }
}
