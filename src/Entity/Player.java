package Entity;

import Characters.Knight;
import Main.Game;

import java.awt.*;

import static Characters.Constants.PlayerStance.*;

public class Player extends Entity{
    protected boolean up,down,left,right;
    // X and Y offset is the distance of the player picture edge and height respectively to the edge of the player
    float SCALE = Game.getScale();
    protected float xDrawOffset = 30 * SCALE;
    protected float yDrawOffset = 68 * SCALE;
    public int[][] levelData; // Text file that stores tile information regarding location
    PlayerRender playerRender;
    float playerSpeed = 1.5F * SCALE;
    //Variables for Gravity
    private float airSpeed = 0f;
    private float gravity = 0.04f * SCALE;
    private float jumpSpeed = -2.25f * SCALE;
    private float fallSpeedAfterCollision = 0.5f * SCALE;
    private boolean inAir = false;

    public Player(float x, float y ,int width, int height) {
        super(x, y,width,height);
        playerRender = new PlayerRender(this);
        // Player hitbox
        initHitbox(x, y, 33 * SCALE, 38 * SCALE);
    }
    public void updateGame(){
        updatePos();
        playerRender.updateAnimationIndex();
        playerRender.setAnimation();


    }
    // Depending on input, updatePos() will send out the future value to isSolid() to confirm player can move to that value
    public void updatePos(){
        playerRender.setMoving(false);
        if (!left && !right && !up && !down)
            return;
        float xSpeed = 0, ySpeed = 0;

        if (left && !right){
            xSpeed -= playerSpeed;
            if(isSolid((int) (hitbox.x + xSpeed), (int) (hitbox.y + ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + xSpeed), (int) (hitbox.y+hitbox.height + ySpeed),levelData) == false){
                    hitbox.x += xSpeed;
                    playerRender.setMoving(true);
            }
        }else if ( !left && right){
            xSpeed += playerSpeed;
            if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y + ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y+hitbox.height + ySpeed),levelData) == false){
                    hitbox.x += xSpeed;
                    playerRender.setMoving(true);
                }
        }

        if (up && !down){
            ySpeed -= playerSpeed;
            if(isSolid((int) (hitbox.x +  xSpeed), (int) (hitbox.y + ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y + ySpeed),levelData) == false){
                    hitbox.y += ySpeed;
                    playerRender.setMoving(true);
                }

        } else if(!up && down){
            ySpeed += playerSpeed;
            if(isSolid((int) (hitbox.x +  xSpeed), (int) (hitbox.y +hitbox.height+ ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y +hitbox.height + ySpeed),levelData) == false){
                    hitbox.y += ySpeed;
                    playerRender.setMoving(true);
                }
        }





    }
    // Predictive method to check if the future tile is a solid or note
    public boolean isSolid(int x,int y, int[][] levelData){
        boolean solid = false;
        if(Collision.checkIfSolid(x,y,levelData,this)==true)
            solid = true;
        return solid;

    }


    public void loadData(int[][] levelData){
        this.levelData = levelData;

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

    public PlayerRender getPlayerRender(){
        return playerRender;
    }

}
