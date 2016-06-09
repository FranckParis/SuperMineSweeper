package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by franck on 6/2/16.
 */
public class Timer extends Thread {
    
    //Attributs
    private boolean running = true;
    private GameModel gm;
    
    //Constructeurs
    public Timer (GameModel gm){
        this.gm = gm;
    }
    
    //Méthodes
    public void run(){
        while(running){
            try {
                sleep(1000);
                gm.updateTime();
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setRunning(boolean b) {
        this.running = b;
    }
}
