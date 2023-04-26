package Entity;

import Main.Game;

public class Collision {

    public static boolean checkIfSolid(int x, int y, int[][] levelData,Player player){
        boolean isSolid = false;
        int xValue = x/ Game.TILES_SIZE;
        int yValue = y/Game.TILES_SIZE;


            if (levelData[xValue][yValue] != 0)
                isSolid = true;



        return isSolid;




    }
}
