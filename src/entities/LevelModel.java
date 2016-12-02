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
        
        // Instead of setting Dictionary, load the default WordTable
        try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
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
