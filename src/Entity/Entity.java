package Entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float deltaX;
    protected float deltaY;
    protected int height;
    protected int width;
    protected Rectangle2D.Float hitbox;
    public Entity(int deltaX,int deltaY,int width,int height){
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.width  = width;
        this.height =  height;


    }

    protected void initHitbox(float x, float y,float width, float height) {
        hitbox = new Rectangle2D.Float(x,y,width,height);
    }

    protected void drawHitbox(Graphics2D g2D){
        //For debugging purposes
        g2D.setColor(Color.PINK);
        g2D.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);

    }

    /*protected void updateHitbox(){
        hitbox.x =  deltaX;
        hitbox.y =  deltaY;
    }*/

    public Rectangle2D.Float getHitbox(){
        return hitbox;
    }




}
