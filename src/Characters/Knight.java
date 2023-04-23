package Characters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight {
    public ArrayList<ImageIcon[]> knightStances = new ArrayList<ImageIcon[]>();
    public Knight() {

     ImageIcon knightIdle1 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle1.png");
     ImageIcon knightIdle2 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle2.png");
     ImageIcon knightIdle3 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle3.png");
     ImageIcon knightIdle4 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle4.png");
     ImageIcon knightIdle5 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle5.png");
     ImageIcon knightIdle6 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle6.png");
     ImageIcon knightIdle7 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle7.png");
     ImageIcon knightIdle8 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle8.png");
     ImageIcon knightIdle9 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle9.png");
     ImageIcon knightIdle10 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle10.png");
     ImageIcon knightIdle11 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle11.png");
     ImageIcon knightIdle12 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Idle/idle12.png");
     ImageIcon[] idleStance = {knightIdle1,knightIdle2,knightIdle3,knightIdle4,knightIdle5,knightIdle6,knightIdle7,knightIdle8,knightIdle9,knightIdle10,knightIdle11,knightIdle12};

     ImageIcon knightRunning1 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run1.png");
     ImageIcon knightRunning2 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run2.png");
     ImageIcon knightRunning3 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run3.png");
     ImageIcon knightRunning4 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run4.png");
     ImageIcon knightRunning5 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run5.png");
     ImageIcon knightRunning6 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run6.png");
     ImageIcon knightRunning7 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run7.png");
     ImageIcon knightRunning8 = new ImageIcon("resFolder/Project Game Images/pixel-art-characters-for-platformer-games/PNG/Knight/Run/run8.png");
     ImageIcon[] runningStance = {knightRunning1,knightRunning2,knightRunning3,knightRunning4,knightRunning5,knightRunning6,knightRunning7,knightRunning8};



        knightStances.add(idleStance);
        knightStances.add(runningStance);


    }



}
