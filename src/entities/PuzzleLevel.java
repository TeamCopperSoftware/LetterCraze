package entities;

public class PuzzleLevel extends LevelModel {
    
    int moveLimit;
    int movesDone;

    public PuzzleLevel(Board b, Goal g, int moveLimit) {
        super(b, g);
        this.moveLimit = moveLimit;
    }
    
    int getMoveLimit() {
        return moveLimit;
    }
    
    int getMovesDone() {
        return movesDone;
    }

}
