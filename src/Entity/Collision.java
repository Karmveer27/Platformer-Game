package Entity;

import Main.Game;

public class Collision {

    public static boolean checkIfSolid(int x, int y, int[][] levelData,Player player){
        boolean isSolid = false;
        int xValue = x/ Game.getTilesSize();
        int yValue = y/Game.getTilesSize();
            try {
                if (levelData[xValue][yValue] != 0)
                    isSolid = true;

            }catch(ArrayIndexOutOfBoundsException e){
                isSolid = true;
            }
        return isSolid;
    }
}
