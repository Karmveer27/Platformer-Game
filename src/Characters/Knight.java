package Characters;

import javax.swing.*;
import java.util.ArrayList;

public class Knight {
    public ArrayList<ImageIcon[]> stances = new ArrayList<ImageIcon[]>();
    public Knight() {




     ImageIcon[] idleStance = new ImageIcon[12];
     for (int i = 1; i < 13; i ++) {
      String imageTest = String.format("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle%d.png", i);
      ImageIcon temp = new ImageIcon(imageTest);
      idleStance[i-1] = temp;
     }

     ImageIcon[] runningStance = new ImageIcon[8];
     for (int i = 1; i < 9; i ++) {
      String imageTest = String.format("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run%d.png", i);
      ImageIcon temp = new ImageIcon(imageTest);
      runningStance[i-1] = temp;
     }

     ImageIcon[] attackStance = new ImageIcon[4];
     for (int i = 0; i < 4; i ++) {
      String imageTest = String.format("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Attack/attack%d.png", i);
      ImageIcon temp = new ImageIcon(imageTest);
      attackStance[i] = temp;
     }

     ImageIcon[] jumpStance = new ImageIcon[3];
        for (int i = 1; i < 4; i ++) {
            String imageTest = String.format("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Jump/jump%d.png", i);
            ImageIcon temp = new ImageIcon(imageTest);
            jumpStance[i-1] = temp;
        }

        ImageIcon[] fallStance = new ImageIcon[4];
        for (int i = 1; i < 5; i ++) {
            String imageTest = String.format("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Fall/Fall %d.png", i);
            ImageIcon temp = new ImageIcon(imageTest);
            fallStance[i-1] = temp;
        }





        stances.add(idleStance);
        stances.add(runningStance);
        stances.add(attackStance);
        stances.add(jumpStance);
        stances.add(fallStance);



    }



}
