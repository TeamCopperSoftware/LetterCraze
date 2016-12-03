package entities;

import java.io.IOException;

public abstract class LevelModel {
    
    Board board;
    Goal goals;
    
    History history;
    Score bestScore, currentScore;
    Boolean isUnlocked;
    
    LevelModel(Board b, Goal g) {
        this.board = b;
        this.goals = g;
        bestScore = new Score();
        currentScore = new Score();
        isUnlocked = false;
    }
    
    void initializeWordTable() {
    	try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
