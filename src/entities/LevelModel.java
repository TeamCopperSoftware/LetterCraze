package entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.Stack;

import javax.swing.DefaultListModel;

public abstract class LevelModel implements Serializable {
    
    Board board;
    Goal goals;
    
    Stack<Move> history;
    Score bestScore, currentScore;
    Score startingBestScore;
    Boolean isUnlocked;
    String type;
    DefaultListModel<String> wordList;
    
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
    
    void initializeWordTable() {
    	try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * called whenever level is loaded from Map
     */
    public void initializeLevel() {
    	initializeWordTable();
    	// keep track of what the best score was when the level is opened.
    	startingBestScore.setScore(bestScore.getScore());
    	startingBestScore.setStar(bestScore.getStar());
        resetLevel();
    }
    
    /**
     * called whenever player hits reset button, or level is initialized
     */
    public void resetLevel() {
    	board.reset(); // reset board
    	currentScore = new Score(); // set currentScore to 0;
    	history.clear(); // clear move history
    	wordList.clear();
    }
    
    /**
     * called whenever player requests to leave level or level is over
     * updates best score if current score is better
     */
    public void updateBestScore() {
    	if (currentScore.getScore() > bestScore.getScore()) {
    		bestScore.setScore(currentScore.getScore());
    		bestScore.setStar(currentScore.getStar());
    	}
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
    
    public Score getCurrentScore() {
    	return currentScore;
    }
    
    public Board getBoard() {
    	return board;
    }
    
    public DefaultListModel<String> getWordList() {
    	return wordList;
    }
    
    public Goal getGoals() {
    	return goals;
    }
    
    public int getHistorySize() {
    	return history.size();
    }
    
    public void pushToHistory(Move move) {
    	history.push(move);
    }
    
    public Move popFromHistory() {
    	return history.pop();
    }
    
    public void unlock() {
        isUnlocked = true;
    }
    
    public boolean getLockStatus() {
        return isUnlocked;
    }
    
    public Score getStartingBestScore() {
    	return startingBestScore;
    }

    
}
