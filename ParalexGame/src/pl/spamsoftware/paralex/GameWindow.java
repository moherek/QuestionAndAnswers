package pl.spamsoftware.paralex;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener {

    private static JTextField questionPanel;
    private static JButton buttonA;
    private static JButton buttonB;
    private static JButton buttonC;
    private static JPanel jPanel;
    private static String correctAnswer;
    private static JProgressBar jProgressBar;
    private static DatabaseInterface databaseInterface;


    public GameWindow(DatabaseInterface databaseInterface){
        super("Quizzowanie!");
        this.databaseInterface = databaseInterface;
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout());
        /* Window with questions */
        questionPanel = new MyQuestionPanel();
        questionPanel.setPreferredSize(new Dimension(600,200));
        add(questionPanel,BorderLayout.NORTH);

        /* Window with progressbar */
        jProgressBar = new JProgressBar();
        add(jProgressBar, BorderLayout.AFTER_LAST_LINE);

        /* Window with answers */
        jPanel.setPreferredSize(new Dimension(600,200));
        buttonA = new JButton();
        buttonB = new JButton();
        buttonC = new JButton();

        jPanel.add(buttonA);
        jPanel.add(buttonB);
        jPanel.add(buttonC);

        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);


        jProgressBar.setPreferredSize(new Dimension(600,50));
        add(jPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void setText(MyQuestionAndAnswers myQuestionAndAnswers) {
        questionPanel.setText(myQuestionAndAnswers.getQuestion());
        buttonA.setText(myQuestionAndAnswers.getAnswer1());
        buttonB.setText(myQuestionAndAnswers.getAnswer2());
        buttonC.setText(myQuestionAndAnswers.getAnswer3());
        correctAnswer = myQuestionAndAnswers.getCorrectAnswer();
    }
    public void setDefaultButtonBackground(){
        /* Set to default background */
        buttonA.setBackground(null);
        buttonB.setBackground(null);
        buttonC.setBackground(null);

    }
    public void setProgressBarValue(int value, int maxValue){
        jProgressBar.setMaximum(maxValue);
        jProgressBar.setValue(value);
    }
    private void setButtonBackgroundToGreen(JButton jButton, DatabaseInterface databaseInterface){
        ButtonBackgroundToGreenDelayTimer buttonBackgroundToGreenDelayTimer = new ButtonBackgroundToGreenDelayTimer(jButton, databaseInterface);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonA) {
            if (correctAnswer.equals("A")) setButtonBackgroundToGreen(buttonA, databaseInterface);
            else {
                buttonA.setBackground(Color.RED);
                databaseInterface.badAnswer();
            }
        }

        else if(source == buttonB) {
            if(correctAnswer.equals("B")) setButtonBackgroundToGreen(buttonB, databaseInterface);
            else{
                buttonB.setBackground(Color.RED);
                databaseInterface.badAnswer();
            }
        }
        else if(source == buttonC) {
            if(correctAnswer.equals("C"))setButtonBackgroundToGreen(buttonC, databaseInterface);
            else {
                buttonC.setBackground(Color.RED);
                databaseInterface.badAnswer();
            }
        }
    }
}

