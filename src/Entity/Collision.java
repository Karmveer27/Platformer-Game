package Entity;

import Main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Collision {
    // To fix issue< i think we use point objects, send two in the paramters, then parse through the values for example for(x = point1.x, x < point2.x)

    public static boolean checkIfSolid(Point point1, Point point2, int[][] levelData,Player player){
        boolean isSolid = false;
        int xValue1 = point1.x/ Game.getTilesSize();
        int yValue1 = point1.y/Game.getTilesSize();
        int xValue2 = point2.x/ Game.getTilesSize();
        int yValue2 = point2.y/Game.getTilesSize();
        for(int xValue = xValue1 ; xValue <= xValue2;xValue++)
            for(int yValue = yValue1 ; yValue <= yValue2;yValue++) {
                try {
                    if (levelData[xValue][yValue] != 0)
                        isSolid = true;


                } catch (ArrayIndexOutOfBoundsException e) {
                    isSolid = true;
                    return isSolid;
                }
            }
        return isSolid;
    }

    /*public static boolean checkIfOnFloor(Rectangle2D hitbox, int[][] levelData, Player player){
        boolean onFloor = true;
        if(!checkIfSolid((int) hitbox.getX(), (int) (hitbox.getY()+hitbox.getHeight()+1),levelData,player))
            if(!checkIfSolid((int) (hitbox.getX()+hitbox.getWidth()), (int) (hitbox.getY()+hitbox.getHeight()+1),levelData,player))
                 onFloor = false;




        return onFloor;
    }*/

    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        int currentTile = (int) (hitbox.y / Game.getTilesSize());
        if (airSpeed > 0) {
            // Falling - touching floor
            int tileYPos = currentTile * Game.getTilesSize();
            int yOffset = (int) (Game.getTilesSize() - hitbox.height);
            return tileYPos + yOffset - 1;
        } else
            // Jumping
            return currentTile * Game.getTilesSize() - Game.getTilesSize();

    }
}
