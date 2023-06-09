package Tile;

import Main.Game;
import Main.Panel;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

import static Main.Game.*;


public class TileManager {
    Panel panel;
    Tile[] tiles;
    public int[][] mapTiles;
    public TileManager(Panel panel){
        this.panel = panel;
        tiles = new Tile[50];
        mapTiles = new int[Game.getTilesInWidth()][Game.getTilesInHeight()];
        setPanelTypes();
        loadMap();
    }

    private void setPanelTypes() {
        tiles[0]  = new Tile();
        tiles[0].image = new ImageIcon("");


        for (int i = 1; i < 48; i++){
            tiles[i] = new Tile();
            String filepath = String.format("resFolder/Project Game Images/pixel-art-forest-platformer-tileset/Tiles/Tiles (%d).png",i);
            tiles[i].image = new ImageIcon(filepath);


        }

    }

    public void loadMap(){
        Scanner br = null;
        try{
        br = new Scanner(new File("resFolder/maps/map1.txt"));

        int col = 0;
        int row = 0;

        while(col < Game.getTilesInWidth() && row < Game.getTilesInHeight()) {
            String line = br.nextLine();
            while (col < Game.getTilesInWidth()) {
                String[] numbers = line.split(" ");

                int num = Integer.parseInt(numbers[col]);

                mapTiles[col][row] = num;
                col++;

            }
            if (col == Game.getTilesInWidth()){
                col = 0;
                row++;

            }
        }
        br.close();


        }catch(FileNotFoundException e){
            System.out.println("file not found");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void draw(Graphics2D g2D){
        ImageIcon backround = new ImageIcon("resFolder/Project Game Images/pixel-art-forest-platformer-tileset/Background/Bright/Background.png");
        g2D.drawImage(backround.getImage(),0,0,Game.getTilesSize()*Game.getTilesInWidth(),Game.getTilesSize()*Game.getTilesInHeight(),null);

        //Drawing Map Tile
        int col =0 ;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col < Game.getTilesInWidth() && row < Game.getTilesInHeight()){
            int tileNum = mapTiles[col][row];
            g2D.drawImage(tiles[tileNum].image.getImage(),x,y,Game.getTilesSize(),Game.getTilesSize(),null );
            col++;
            x += Game.getTilesSize();
            if (col == Game.getTilesInWidth()){
                col = 0;
                x = 0;
                row++;
                y+= Game.getTilesSize();

            }



        }
    }
}
