package Inputs;

import Main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Characters.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {
    private Panel panel;
    public KeyboardInputs(Panel panel){
        this.panel = panel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W:
                        panel.setDirection(UP);
                        break;
                case KeyEvent.VK_A:
                    panel.setDirection(LEFT);
                    break;
                case KeyEvent.VK_S:
                    panel.setDirection(DOWN);
                    break;
                case KeyEvent.VK_D:
                    panel.setDirection(RIGHT);
                    break;

            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                panel.setMoving(false);
                break;

        }

    }
}
