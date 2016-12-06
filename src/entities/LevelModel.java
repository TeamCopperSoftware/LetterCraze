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
    
    /**
     * called whenever level is loaded from Map
     */
    public void initializeLevel() {
    	initializeWordTable();
        resetBoard();
    }
    
    /**
     * called whenever player hits reset button, or level is initialized
     */
    void resetBoard() {
    	board.reset(); // reset board
    	currentScore = new Score(); // set currentScore to 0;
    	history.clear(); // clear move history
    	
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
