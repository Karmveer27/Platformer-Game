package Main;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(Panel panel){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);









        frame.setVisible(true);


    }


}
