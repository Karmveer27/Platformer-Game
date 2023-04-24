package Entity;

import Characters.Knight;

import java.awt.*;

import static Characters.Constants.PlayerStance.*;

public class Player extends Entity{
    Knight knight = new Knight();
    private int aniTick, aniIndex, aniSpeed=10;
    private int playerStance = IDLE;
    private boolean playerMoving = false, playerAttacking  = false;
    private boolean up,down,left,right;
    public Player(int deltaX, int deltaY) {
        super(deltaX, deltaY);
    }
    public void updateGame(){
        updatePos();
        updateAnimationIndex();
        setAnimation();


    }

    public void render(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        try{
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(),deltaX,deltaY, 200,200, null);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            aniIndex = 0;
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(),deltaX,deltaY, 200,200, null);
        }

    }

    private void setAnimation() {
        int startAnimation = playerStance;
        if(playerMoving)
            playerStance = RUN;
        else
            playerStance = IDLE;
        if (playerAttacking)
            playerStance = ATTACK;

        if (startAnimation != playerStance)
            resetAniTick();

    }

    private void resetAniTick() {
        aniIndex = 0;
        aniTick = 0;
    }


    public void setMoving(boolean moving){
        this.playerMoving = moving;

    }

    public void updatePos(){
        playerMoving = false;
        if (left && !right){
            deltaX += -2;
            playerMoving = true;
        }else if ( !left && right){
            deltaX += 2;
            playerMoving = true;
        }

        if (up && !down){
            deltaY += -2;
            playerMoving = true;
        } else if(!up && down){
            deltaY += 2;
            playerMoving = true;
        }


    }

    private void updateAnimationIndex() {
        aniTick++;
        if (aniTick > aniSpeed){
            aniTick = 0;
            aniIndex ++;
            try{
                knight.stances.get(playerStance)[aniIndex].getImage();
            }

            catch (ArrayIndexOutOfBoundsException e) {
                aniIndex = 0;
                playerAttacking  = false;
            }


        }
    }

    public void setUp(boolean x){
        this.up = x;
    }
    public void setDown(boolean x){
        this.down = x;
    }
    public void setLeft(boolean x){
        this.left = x;
    }
    public void setRight(boolean x){
        this.right = x;
    }
    public void setAllDir(boolean x){
        this.right = x;
        this.left = x;
        this.up = x;
        this.down = x;
    }

    public void setPlayerAttacking(boolean attacking){
        this.playerAttacking = attacking;

    }





}
