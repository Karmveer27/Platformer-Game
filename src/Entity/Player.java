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
    float playerSpeed = 0.75F * SCALE;
    //Variables for Gravity
    private boolean jump;
    private float airSpeed = 0f;
    private float gravity = 0.04f * SCALE;
    private float jumpSpeed = -2.75f * SCALE;
    private float fallSpeedAfterCollision = 0.5f * SCALE;
    private boolean inAir = false;



    public Player(float x, float y ,int width, int height) {
        super(x, y,width,height);
        playerRender = new PlayerRender(this);
        // Player hitbox
        initHitbox(x, y, 33* SCALE, 38* SCALE);

    }
    public void updateGame(){
        updatePos();
        playerRender.updateAnimationIndex();
        playerRender.setAnimation();


    }
    // Depending on input, updatePos() will send out the future value to updateXPos --> isSolid() to confirm player can move to that value
    public void updatePos(){
        playerRender.setMoving(false);
        if(jump)
            jump();
        if (!left && !right && !inAir)
            return;
        float xSpeed = 0;

        if (left && !right){
            xSpeed -= playerSpeed;
            updateXPos(xSpeed);
        }
        else if (!left && right){
            xSpeed += playerSpeed;
            updateXPos(xSpeed);
        }

        if(!inAir)
            updateYPosNotInAir();


        if (inAir){
            updateYPosInAir(xSpeed);
        }
        else
            updateXPos(xSpeed);
        //playerRender.setMoving(true);

    }
    public void updateXPos(float xSpeed){
        if (left && !right){
            Point point1 = new Point((int) (hitbox.x + xSpeed),(int) (hitbox.y ));
            Point point2 = new Point((int) (hitbox.x + xSpeed), (int) (hitbox.y+hitbox.height ));
            if(isSolid(point1,point2,levelData) == false){
                    hitbox.x += xSpeed;
                    playerRender.setMoving(true);
                }
        }
        if (!left && right){
            Point point1 = new Point((int) (hitbox.x + hitbox.width + xSpeed),(int) (hitbox.y ));
            Point point2 = new Point((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y+hitbox.height ));
            if(isSolid(point1,point2,levelData) == false){
                    hitbox.x += xSpeed;
                    playerRender.setMoving(true);
                }
        }
    }

    public void updateYPosNotInAir(){
        Point point1 = new Point((int) hitbox.x, (int) (hitbox.getY()+hitbox.getHeight()+1));
        Point point2 = new Point((int) (hitbox.getX()+hitbox.getWidth()), (int) (hitbox.getY()+hitbox.getHeight()+1));
        if(!isSolid(point1,point2,levelData))
            inAir = true;

    }

    public void updateYPosInAir(float xSpeed){
        Point point1 = new Point((int) (hitbox.x),(int) (hitbox.y + airSpeed));
        Point point2 = new Point((int) (hitbox.x + hitbox.width),(int) (hitbox.y +hitbox.height + airSpeed ));
        if(isSolid(point1,point2,levelData) == false) {
            hitbox.y += airSpeed;
            airSpeed += gravity;
            updateXPos(xSpeed);
        }
        else {
            hitbox.y = Collision.GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed) + Game.getTilesSize();
            if (airSpeed > 0)
                resetInAir();

            else
                airSpeed = fallSpeedAfterCollision;
            updateXPos(xSpeed);
        }

    }


    // Predictive method to check if the future tile is a solid or note
    public boolean isSolid(Point point1,Point point2, int[][] levelData){
        boolean solid = false;
        if(Collision.checkIfSolid(point1,point2,levelData,this)==true)
            solid = true;
        return solid;

    }
    private void resetInAir(){
        inAir = false;
        airSpeed = 0;
    }
    private void jump(){
        if(inAir)
            return;
        inAir = true;
        airSpeed = jumpSpeed;
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
    public void setJump(boolean x){
        this.jump = x;
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
