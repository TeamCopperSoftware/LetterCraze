package entities;

import java.util.Timer;

public class LightningLevel extends LevelModel {

    
    Timer timer;
    int timeLimit;
    
    public LightningLevel(Board b, Goal g, Dictionary d, int timeLimit) {
        super(b, g, d);
        this.timeLimit = timeLimit;
        timer = new Timer();    //TODO fix the timer class. 
                                //I don't think Java.util is the right one
    }
    
    int getTimeLimit() {
        return timeLimit;
    }
    
    

}
