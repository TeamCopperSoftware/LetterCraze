package entities;

public class PuzzleLevel extends LevelModel {
    
    int moveLimit;
    int movesDone;

    public PuzzleLevel(Board b, Goal g, int moveLimit) {
        super(b, g, "Puzzle");
        this.moveLimit = moveLimit;
    }
    
    public int getMoveLimit() {
        return moveLimit;
    }
    
    public int getMovesDone() {
        return movesDone;
    }

}
