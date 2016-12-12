package entities;

import javax.swing.Timer;

import playercontroller.LightningTimerController;

/**
 * Represents all entity information for lightning levels.
 */

public class LightningLevel extends LevelModel {

	/** Swing component of Timer. */
    Timer timer;
	/** Amount of time in lightning level (seconds). */
    int timeLimit;
    

	/** 
	 * Constructs full lightning level with timer.
	 * 
	 * Initial value is given.
	 * @param b    Arrangement of tiles in board
	 * @param g    Goals for the lightning level (Amount of time left)
	 * @param timeLimit Adds a timer to only lightning levels
	 */
    public LightningLevel(Board b, Goal g, int timeLimit) {
        super(b, g, "Lightning");
        this.timeLimit = timeLimit;              
    }
    
    /**
     * Retrieves time limit for lightning level.
     */
    public int getTimeLimit() {
        return timeLimit;
    }

}
