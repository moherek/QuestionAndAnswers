package pl.spamsoftware.paralex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    public static JButton aButton;
    private JButton bButton;
    private JButton cButton;

    public ButtonPanel(){
        aButton = new JButton("A");
        bButton = new JButton("B");
        cButton = new JButton("C");

        aButton.addActionListener(this);
        bButton.addActionListener(this);
        cButton.addActionListener(this);

        setLayout(new GridLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(aButton);
        add(bButton);
        add(cButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == aButton)
            aButton.setBackground(Color.GREEN);
        else if(source == bButton)
            bButton.setBackground(Color.GREEN);
        else if(source == cButton)
            cButton.setBackground(Color.GREEN);

    }

}
