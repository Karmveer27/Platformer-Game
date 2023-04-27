package Entity;

import Characters.Knight;
import Main.Game;

import java.awt.*;

import static Characters.Constants.PlayerStance.*;

public class PlayerRender {
    Knight knight = new Knight();
    private int aniTick, aniIndex, aniSpeed=10;
    Player player;
    private int playerStance = IDLE;
    private boolean playerMoving = false, playerAttacking  = false;

    public PlayerRender(Player player){
        this.player = player;


    }
    // Draw image
    public void render(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        try{
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(),(int) (player.hitbox.x - player.xDrawOffset), (int) (player.hitbox.y - player.yDrawOffset), (int) (Game.getScale() * 128), (int) (Game.getScale()*128), null);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            aniIndex = 0;
            g2D.drawImage(knight.stances.get(playerStance)[aniIndex].getImage(),(int) (player.hitbox.x - player.xDrawOffset), (int) (player.hitbox.y - player.yDrawOffset), 200,200, null);
        }
        player.drawHitbox(g);
        int x = (int) (player.hitbox.x / Game.getTilesSize());
        int y = (int) (player.hitbox.y / Game.getTilesSize());


    }
    //Setting animation based current playerStance
    protected void setAnimation() {
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

    protected void updateAnimationIndex() {
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

    public void setPlayerAttacking(boolean attacking){
        this.playerAttacking = attacking;

    }

    public void setMoving(boolean moving){
        this.playerMoving = moving;

    }
}
