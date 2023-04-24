package Tile;

import Main.Panel;

import javax.swing.*;
import java.awt.*;
import static Main.Game.TILES_SIZE;


public class TileManager {
    Panel panel;
    Tile[] tiles;
    public TileManager(Panel panel){
        this.panel = panel;
        tiles = new Tile[10];
        setPanelTypes();
    }

    private void setPanelTypes() {
        tiles[0]  = new Tile();
        tiles[0].image = new ImageIcon("resFolder/Project Game Images/pixel-art-forest-platformer-tileset/Tiles/Ground_grass_0000_tile.png");

    }

    public void draw(Graphics2D g2D){
        g2D.drawImage(tiles[0].image.getImage(), 0,0,TILES_SIZE,TILES_SIZE,null);
    }
}
