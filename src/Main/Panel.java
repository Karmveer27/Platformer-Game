package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;


import javax.swing.*;
import java.awt.*;
import Characters.*;
import Tile.TileManager;


import static Characters.Constants.Directions.*;
import static Characters.Constants.PlayerStance.IDLE;
import static Characters.Constants.PlayerStance.RUN;
import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;


public class Panel extends JPanel {
    TileManager tileManger = new TileManager(this);
    Game game;




    public Panel(Game game){
        this.game = game;
    MouseInputs mouseInputs = new MouseInputs(this);
    addKeyListener(new KeyboardInputs(this));
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);
    setPanelSize();
    setFocusable(true);


    }



    private void setPanelSize() {
        this.setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
    }





    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D =  (Graphics2D) g;
        tileManger.draw(g2D);
        game.render(g);


    }

    public Game getGame(){
        return this.game;
    }








}
