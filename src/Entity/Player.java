package Entity;

import Characters.Knight;
import Main.Game;

import java.awt.*;

import static Characters.Constants.PlayerStance.*;

public class Player extends Entity{
    Knight knight = new Knight();
    private int aniTick, aniIndex, aniSpeed=10;
    float playerSpeed = 2;
    private int playerStance = IDLE;
    private boolean playerMoving = false, playerAttacking  = false;
    public boolean up,down,left,right;
    private float xDrawOffset = 30 * Game.SCALE;
    private float yDrawOffset = 68 * Game.SCALE;
    public int[][] levelData;

    public Player(float x, float y ,int width, int height) {
        super(x, y,width,height);
        initHitbox(x, y, 33 * Game.SCALE, 38 * Game.SCALE);
    }
    public void updateGame(){
        updatePos();
        updateAnimationIndex();
        setAnimation();


    }

    public void render(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        try{
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(),(int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), 200,200, null);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            aniIndex = 0;
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(),(int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), 200,200, null);
        }
        drawHitbox(g);
        int x = (int) (hitbox.x / Game.TILES_SIZE);
        int y = (int) (hitbox.y / Game.TILES_SIZE);


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
        if (!left && !right && !up && !down)
            return;
        float xSpeed = 0, ySpeed = 0;

        if (left && !right){
            xSpeed -= playerSpeed;
            if(isSolid((int) (hitbox.x + xSpeed), (int) (hitbox.y + ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + xSpeed), (int) (hitbox.y+hitbox.height + ySpeed),levelData) == false){
                    hitbox.x += xSpeed;
                    playerMoving = true;
            }
        }else if ( !left && right){
            xSpeed += playerSpeed;
            if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y + ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y+hitbox.height + ySpeed),levelData) == false){
                    hitbox.x += xSpeed;
                    playerMoving = true;
                }
        }

        if (up && !down){
            ySpeed -= playerSpeed;
            if(isSolid((int) (hitbox.x +  xSpeed), (int) (hitbox.y + ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y + ySpeed),levelData) == false){
                    hitbox.y += ySpeed;
                    playerMoving = true;
                }

        } else if(!up && down){
            ySpeed += playerSpeed;
            if(isSolid((int) (hitbox.x +  xSpeed), (int) (hitbox.y +hitbox.height+ ySpeed),levelData) == false)
                if(isSolid((int) (hitbox.x + hitbox.width + xSpeed), (int) (hitbox.y +hitbox.height + ySpeed),levelData) == false){
                    hitbox.y += ySpeed;
                    playerMoving = true;
                }
        }





    }

    public boolean isSolid(int x,int y, int[][] levelData){
        boolean solid = false;
        if(Collision.checkIfSolid(x,y,levelData,this)==true)
            solid = true;
        return solid;

    }
    public boolean isSolid(){
        return false;
    }

    public void loadData(int[][] levelData){
        this.levelData = levelData;

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
