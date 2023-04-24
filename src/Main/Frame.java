package Main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Frame extends JFrame {
    public Frame(Panel panel){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                panel.getGame().getPlayer().setAllDir(false);
            }

            @Override
            public void windowLostFocus(WindowEvent e) {

            }
        });









        frame.setVisible(true);


    }


}
