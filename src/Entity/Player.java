package Entity;

import Characters.Knight;

import java.awt.*;
import java.util.Arrays;

import Main.Game;
import Tile.TileManager.*;
import static utilz.HelpMethods.*;

import static Characters.Constants.PlayerStance.*;

public class Player extends Entity{
    Knight knight = new Knight();
    private int aniTick, aniIndex, aniSpeed=10;
    private int playerStance = IDLE;
    private boolean playerMoving = false, playerAttacking  = false;
    private boolean up,down,left,right;
    int playerSpeed = 2;
    private int[][] levelData;
    private float xDrawOffset = 24 * Game.SCALE;
    private float yDrawOffset = 60 * Game.SCALE;

    public Player(int deltaX, int deltaY,int width, int height) {
        super(deltaX, deltaY,width,height );
        initHitbox(deltaX,deltaY,40*Game.SCALE,54*Game.SCALE);

    }
    public void updateGame(){
        updatePos();
        updateAnimationIndex();
        setAnimation();


    }

    public void render(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        try{
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width,height, null);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            aniIndex = 0;
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width,height, null);
        }
        drawHitbox(g2D);

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

        if(!left && !right && !up && !down)
            return;

        int xSpeed = 0, ySpeed = 0;

        if (left && !right)
            xSpeed += -playerSpeed;
        else if ( !left && right)
            xSpeed += playerSpeed;

        if (up && !down)
            ySpeed += -playerSpeed;
        else if(!up && down)
            ySpeed += playerSpeed;

        if(canMoveHere((int) (hitbox.x + xSpeed), (int) (hitbox.y + ySpeed), hitbox.width,hitbox.height,levelData )){
            hitbox.x += xSpeed;
            hitbox.y += ySpeed;
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

    public void loadLevelData(int[][] mapTiles){
        this.levelData = mapTiles;

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
