package pl.spamsoftware.paralex;

import java.awt.*;

public class MainMenu {

    public static void main(String []arg){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Game();

            }
        });

    }
}
