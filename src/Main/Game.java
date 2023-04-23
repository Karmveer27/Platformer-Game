package Main;

import java.sql.SQLOutput;

public class Game implements Runnable {
    private Panel panel;
    private Frame frame;
    private Thread gameThread;
    private int frames = 0;
    long now;
    double FPS_Set = 120;

    public Game(){
        this.panel = new Panel();
        Frame gameFrame = new Frame(panel);
        panel.requestFocus();
        startGameLoop();
    }
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();

    }




    @Override
    public void run() {
        now = System.nanoTime();
        long lastFrame = System.nanoTime();
        double timePerFrame = 1000000000.0/FPS_Set;
        double lastChecked = System.currentTimeMillis();
        while (true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                panel.repaint();
                lastFrame = now;
                frames++;
            }


            if (System.currentTimeMillis() - lastChecked >= 1000) {
                lastChecked = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;


            }
        }
    }
}
