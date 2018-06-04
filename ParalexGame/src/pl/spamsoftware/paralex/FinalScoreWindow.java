package pl.spamsoftware.paralex;

import javax.swing.*;
import java.awt.*;

public class FinalScoreWindow extends JFrame {

    FinalScoreWindow(int finalScore){
        super("Koniec gry!");
        new JFrame();
        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText("Przegrałeś :( Twój wynik to: " + (finalScore - 1));


        setPreferredSize(new Dimension(300,200));
        add(jTextField);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
