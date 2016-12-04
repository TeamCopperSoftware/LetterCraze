package entities;

import java.io.IOException;

public abstract class LevelModel {
    
    Board board;
    Goal goals;
    
    History history;
    Score bestScore, currentScore;
    Boolean isUnlocked;
    String type;
    
    LevelModel(Board b, Goal g, String type) {
        this.board = b;
        this.goals = g;
//        bestScore = new Score();
//        currentScore = new Score();
        isUnlocked = false;
        this.type = type;
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
    
    public String getType() {
    	return type;
    }
    
    public boolean getIsUnlocked() {
    	return isUnlocked;
    }
    
    public Score getBestScore() {
    	return bestScore;
    }
    
    public Board getBoard() {
    	return board;
    }
    
}
