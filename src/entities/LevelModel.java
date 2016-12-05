package entities;

import java.io.IOException;
import java.util.Stack;

public abstract class LevelModel {
    
    Board board;
    Goal goals;
    
    Stack<Move> history;
    Score bestScore, currentScore;
    Boolean isUnlocked;
    String type;
    
    LevelModel(Board b, Goal g, String type) {
        this.board = b;
        this.goals = g;
        bestScore = new Score();
        currentScore = new Score();
        isUnlocked = false;
        this.type = type;
        history = new Stack<Move>();
        
    }
    
    void initializeWordTable() {
    	try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    void removeWord() {
    	// Not sure at all if this is correct 
        Move m = new Move(board.currentWord, this);
        if (m.doMove()) {
        	history.push(m);
        }
    }
    
    // call this whenever a level is loaded from Map
    public void initializeLevel() {
    	initializeWordTable();
        board.repopulate();
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
