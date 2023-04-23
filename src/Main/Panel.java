package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;


import javax.swing.*;
import java.awt.*;
import Characters.*;

import static Characters.Constants.Directions.*;
import static Characters.Constants.PlayerStance.IDLE;
import static Characters.Constants.PlayerStance.RUN;


public class Panel extends JPanel {
    Knight knight = new Knight();
    private int deltaX = 100;
    private int deltaY = 100;
    private int PANEL_HEIGHT = 800;
    private int PANEL_WIDTH = 1280;
    private int aniTick, aniIndex, aniSpeed=10;
    private int playerStance = IDLE;
    private int playerDir = -1;
    private boolean playerMoving = false;



    public Panel(){
    MouseInputs mouseInputs = new MouseInputs(this);
    addKeyListener(new KeyboardInputs(this));
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);
    setPanelSize();


    }



    private void setPanelSize() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
    }



    public void paintComponent(Graphics g){
        updateAnimationIndex();
        setAnimation();
        updatePos();
        super.paintComponent(g);
        Graphics2D g2D =  (Graphics2D) g;
        try{
            g2D.drawImage(knight.knightStances.get(playerStance)[aniIndex].getImage(),deltaX,deltaY, 200,200, null);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            aniIndex = 0;
            g2D.drawImage(knight.knightStances.get(playerStance)[aniIndex].getImage(),deltaX,deltaY, 200,200, null);
        }









    }

    private void setAnimation() {
        if(playerMoving)
            playerStance = RUN;
        else
            playerStance = IDLE;
    }

    public void setDirection(int direction){
        this.playerDir = direction;
        playerMoving = true;
    }

    public void setMoving(boolean moving){
        this.playerMoving = moving;

    }

    public void updatePos(){
        if(playerMoving){
            switch(playerDir){
                case UP:
                    deltaY += -5;
                    break;
                case DOWN:
                    deltaY += 5;
                    break;
                case LEFT:
                    deltaX += -5;
                    break;
                case RIGHT:
                    deltaX += 5;
                    break;
            }

        }
    }

    private void updateAnimationIndex() {
        aniTick++;
        if (aniTick > aniSpeed){
            aniTick = 0;
            aniIndex ++;
            try{
                knight.knightStances.get(playerStance)[aniIndex].getImage();
                }

            catch (ArrayIndexOutOfBoundsException e) {
                aniIndex = 0;
            }


        }
    }






}
