package pl.spamsoftware.paralex;

import javax.swing.*;

public class MyQuestionPanel extends JTextField{
    @Override
    public void setEditable(boolean b) {
        super.setEditable(false);
    }

    @Override
    public void setText(String t) {
        super.setText(t);
    }
}
