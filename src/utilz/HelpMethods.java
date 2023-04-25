package utilz;

import Main.Game;

public class HelpMethods {
    public static boolean canMoveHere(float deltaX, float deltaY, float width, float height, int[][] levelData){
        if(!isSolid(deltaX,deltaY,levelData))
            if(!isSolid(deltaX+width,deltaY + height, levelData))
                if(!isSolid(deltaX+width,deltaY,levelData))
                    if(!isSolid(deltaX,deltaY+height,levelData))
                        return true;
        return false;

    }

    private static boolean isSolid(float deltaX, float deltaY, int[][] levelData){
        if (deltaX < 0 || deltaX >= Game.GAME_WIDTH)
            return true;
        if (deltaY < 0 || deltaY >= Game.GAME_HEIGHT )
            return true;



        float xIndex = deltaX / Game.TILES_SIZE;
        float yIndex = deltaY / Game.TILES_SIZE;

        int value = levelData[(int)yIndex][(int)xIndex];
        System.out.println("xindex = "+ xIndex);
        System.out.println("yindex = "+ yIndex);
        System.out.println("value = "+ value);
        if (value != 00)
            return true;
        return false;
        //Think about it, rn its gettingn if leveldata [y][x] but what does that give it some random value, thing is x and y coords r ddiffeerent so we might havve to scale it to like x and y / some scale
    }

}
