package entities;

import javax.swing.Timer;

import playercontroller.LightningTimerController;

public class LightningLevel extends LevelModel {

    Timer timer;
    int timeLimit;
    
    public LightningLevel(Board b, Goal g, int timeLimit) {
        super(b, g, "Lightning");
        this.timeLimit = timeLimit;              
    }
    
    public int getTimeLimit() {
        return timeLimit;
    }

}
