package pl.spamsoftware.paralex;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements DatabaseInterface, ActionListener {
    private DatabaseManager databaseManager;
    private GameWindow gameWindow;
    private MyQuestionTimer myQuestionTimer;
    private int idQuestion = 1;

    public Game(){

        myQuestionTimer = new MyQuestionTimer(this, this);

        databaseManager = new DatabaseManager(idQuestion);
        gameWindow = new GameWindow(this);
        gameWindow.setText(databaseManager.getMyQuestionAndAnswers());
    }

    @Override
    public boolean goodAnswer() {
        idQuestion++;
        databaseManager.getDataFromDatabase(idQuestion);
        gameWindow.setText(databaseManager.getMyQuestionAndAnswers());
        gameWindow.setDefaultButtonBackground();
        myQuestionTimer.restartTimer();
        return true;

    }

    @Override
    public boolean badAnswer() {
        myQuestionTimer.stopTimer();
        new FinalScoreWindow(idQuestion);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.setProgressBarValue(myQuestionTimer.getCounter(), (myQuestionTimer.MAX_TIME - 1));
    }
}
