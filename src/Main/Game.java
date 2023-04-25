package Main;

import Entity.*;
import Tile.TileManager;

import java.awt.*;
import java.sql.SQLOutput;

public class Game implements Runnable {
    private Panel panel;
    TileManager tileManger;
    private Frame frame;
    private Thread gameThread;
    private int frames = 0;
    private int updates = 0;
    double FPS_Set = 120;
    double UPS_Set = 200;
    private Player player;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int  TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE *TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game(){
        initClasses();// This needs to be first otherwise you get null pointer exception
        this.panel = new Panel(this);
        Frame gameFrame = new Frame(panel);
        player.loadLevelData(panel.tileManger.getLevelData());




        startGameLoop(); // This must be last
    }

    private void initClasses() {
        TileManager tileManger = new TileManager(panel);
        player = new Player(100,100, (int) (128*SCALE), (int) (128*SCALE));

    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    public void update() {
        player.updateGame();
    }

    public void render(Graphics g){
        player.render(g);
    }




    @Override
    public void run() {
        long previousTime = System.nanoTime();
        double timePerFrame = 1000000000.0/FPS_Set;
        double timePerUpdate = 1000000000.0/UPS_Set;
        double lastChecked = System.currentTimeMillis();
        double deltaU = 0;
        double deltaF = 0;


        while (true) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
            if(deltaU >= 1){
                update();
                updates++;
                deltaU --;
            }

            if (deltaF >= 1){
                panel.repaint();
                frames++;
                deltaF --;
            }

            if (System.currentTimeMillis() - lastChecked >= 1000) {
                lastChecked = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "| UPS: " + updates);
                frames = 0;
                updates = 0;


            }
        }
    }

    public Player getPlayer(){
        return this.player;
    }


}
