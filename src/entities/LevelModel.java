package entities;

public abstract class LevelModel {
    
    Board board;
    Goal goals;
    Dictionary dictionary;
    
    History history;
    Score bestScore, currentScore;
    Boolean isUnlocked;
    
    LevelModel(Board b, Goal g, Dictionary d) {
        this.board = b;
        this.goals = g;
        this.dictionary = d;
    }
    
    void removeWord(Board b) {
        //TODO double check this method header
    }
    
    void initializeLevel() {
        
    }
    
    void resetBoard() {
        
    }
    
    boolean undoMove() {
        return false;
    }
    
    boolean updateScreen() {
        return false;
    }
    
}
