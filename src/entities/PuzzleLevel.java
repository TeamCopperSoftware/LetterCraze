package entities;

/**
 * Represents all entity information for puzzle levels.
 */
public class PuzzleLevel extends LevelModel {

	/** The number of words a user can add in puzzle level. */
    int moveLimit;
	/** The amount of valid words a user has added. */
    int movesDone;

	/** 
	 * Constructs full puzzle level with move limit.
	 * 
	 * Initial value is given.
	 * @param b    Arrangement of tiles in board
	 * @param g    Goals for puzzle level (Highest Score)
	 * @param moveLimit Adds a limit to the amount of words added in puzzle levels
	 */
    public PuzzleLevel(Board b, Goal g, int moveLimit) {
        super(b, g, "Puzzle");
        this.moveLimit = moveLimit;
        movesDone = 0;
    }
    
    /**
     * Retrieves move limit for each puzzle level.
     */
    public int getMoveLimit() {
        return moveLimit;
    }
    
    /**
     * Retrieves the amount of valid words added by user for each puzzle level.
     */
    public int getMovesDone() {
    	return movesDone;
    }
    
    /**
     * Resets number of words added by player back to zero.
     */
    public void resetMovesDone() {
    	movesDone = 0;
    }

}
