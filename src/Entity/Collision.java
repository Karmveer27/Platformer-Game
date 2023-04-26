package Entity;

import Main.Game;

public class Collision {

    public static boolean checkIfSolid(int x, int y, int[][] levelData,Player player){
        boolean isSolid = false;
        int xValue = x/ Game.TILES_SIZE;
        int yValue = y/Game.TILES_SIZE;
        System.out.println("X Value " + xValue + "Y Value "+ yValue);
        System.out.println(levelData[xValue][yValue]);

        if(player.left && !player.right) {
            if (levelData[xValue][yValue] != 0)
                isSolid = true;
            System.out.println("Collison class " + isSolid);

        }
        return isSolid;




    }
}
