package entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.Stack;

import javax.swing.DefaultListModel;

/**
 * Represents all entity information for level model.
 */

public abstract class LevelModel implements Serializable {
   
	/** Level Board. */
    Board board;
    /** Goals for each level. */
    Goal goals;
	/** Keeps track of move made for selecting tiles. */    
    Stack<Move> history;
	/** Keeps track for current and best score. */
    Score bestScore, currentScore;
	/** Keeps track of original best score. */
    Score startingBestScore;
	/** Controls whether level is unlocked. */
    Boolean isUnlocked;
	/** Name of level type based on level variation. */
    String type;
	/** Keep track of words. */
    DefaultListModel<String> wordList;
   
    
	/** 
	 * Construct full level with the board, goals, and specific level type parameters.
	 * 
	 * Initial value is given.
	 * @param b    Arrangement of tiles in board
	 * @param g    Goals for the level
	 * @param type Type of level (Puzzle, Lightning, Theme)
	 */
    
    LevelModel(Board b, Goal g, String type) {
        this.board = b;
        this.goals = g;
        bestScore = new Score();
        currentScore = new Score();
        startingBestScore = new Score();
        isUnlocked = false;
        this.type = type;
        history = new Stack<Move>();
        wordList = new DefaultListModel<String>();  
    }

    /**
     * Initializes the dictionary to be used for checking words in level.
     */
    void initializeWordTable() {
    	try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Called whenever level is loaded from Map.
     */
    public void initializeLevel() {
    	initializeWordTable();
    	// keep track of what the best score was when the level is opened.
    	startingBestScore.setScore(bestScore.getScore());
    	startingBestScore.setStar(bestScore.getStar());
        resetLevel();
    }
    
    /**
     * Called whenever player hits reset button, or level is initialized.
     */
    public void resetLevel() {
    	board.reset(); // reset board
    	currentScore = new Score(); // set currentScore to 0;
    	history.clear(); // clear move history
    	wordList.clear();
    }
    
    /**
     * Called whenever player requests to leave level or level is over
     * updates best score if current score is better.
     */
    public void updateBestScore() {
    	if (currentScore.getScore() > bestScore.getScore()) {
    		bestScore.setScore(currentScore.getScore());
    		bestScore.setStar(currentScore.getStar());
    	}
    }

    /**
     * Called when user clicks undo button.
     */
    boolean undoMove() {
        return false;
    }
    
    /**
     * Called whenever player clicks reset button, or level is initialized.
     */
    boolean updateScreen() {
        return false;
    }
    
    /**
     * Retrieves name of level type.
     */
    public String getType() {
    	return type;
    }

    /**
     * Checks whether Level is unlocked.
     */
    public boolean getIsUnlocked() {
    	return isUnlocked;
    }
 
    /**
     * Retrieves the highest score achieved.
     */
    public Score getBestScore() {
    	return bestScore;
    }
    
    /**
     * Retrieves the current level score.
     */
    public Score getCurrentScore() {
    	return currentScore;
    }
    
    /**
     * Retrieves Board for level.
     */
    public Board getBoard() {
    	return board;
    }
    
    /**
     * Retrieves wordlist functionality for level.
     */
    public DefaultListModel<String> getWordList() {
    	return wordList;
    }

    /**
     * Retrieves goals for level.
     */
    public Goal getGoals() {
    	return goals;
    }

    /**
     * Retrieves amount of valid moves made in the level.
     */
    public int getHistorySize() {
    	return history.size();
    }
 
    /**
     * Adds a move to stack of valid moves.
     */
    public void pushToHistory(Move move) {
    	history.push(move);
    }
    
    /**
     * Removes most recent move from stack of valid moves.
     */    
    public Move popFromHistory() {
    	return history.pop();
    }
    
    /**
     * Unlocks a level.
     */    
    public void unlock() {
        isUnlocked = true;
    }
  
    /**
     * Checks whether level is unlocked.
     */    
    public boolean getLockStatus() {
        return isUnlocked;
    }
    
    /**
     * Keeps track of highest score for level.
     */    
    public Score getStartingBestScore() {
    	return startingBestScore;
    }

    
}
