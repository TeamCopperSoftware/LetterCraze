package entities;

import java.io.IOException;

public abstract class LevelModel {
    
    Board board;
    Goal goals;
    Dictionary dictionary; // now that we have WordTable we probably don't need a dictionary class anymore
    
    History history;
    Score bestScore, currentScore;
    Boolean isUnlocked;
    
    LevelModel(Board b, Goal g, Dictionary d) {
        this.board = b;
        this.goals = g;
        this.dictionary = d; // instead of setting dictionary we should call method initializeWordTable()
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
