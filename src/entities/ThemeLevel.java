package entities;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents all entity information for theme levels.
 */
public class ThemeLevel extends LevelModel {

	/** Name of the theme for each levels. */
    String theme;
	/** List of valid words based on theme. */
    ArrayList<String> validWords;
	/** Keeps track of the initial Board setup in case player wants to reset board. */
    Board startingBoard; 
    

	/** 
	 * Constructs full theme level.
	 * 
	 * Initial value is given.
	 * @param b    Arrangement of tiles in board
	 * @param g    Goals for the theme level (Amount of words found)
	 * @param theme Adds Theme description
	 * @param validWords Adds valid words based on theme description
	 */
    public ThemeLevel(Board b, Goal g, String theme, ArrayList<String> validWords) {
        super(b, g, "Theme");
        this.theme = theme;
        this.validWords = validWords;
        Square[] squares = new Square[36];
        int i = 0;
        for (int y = 0; y < 6; y++) {
        	for (int x = 0; x < 6; x++) {
        		if (b.lookUpSquare(x, y).enabled) {
        			squares[i] = new Square(b.lookUpSquare(x, y).position, b.lookUpSquare(x, y).enabled, new Tile(b.lookUpSquare(x, y).tilePeek().letter));
        		}
        		else {
        			squares[i] = new Square(b.lookUpSquare(x, y).position, false);
        		}
        		i++;
        	}
        }
        this.startingBoard = new Board(squares);
    }
    
    /**
     * Initializes valid words for each theme level.
     */
    @Override
    void initializeWordTable() {
    	WordTable.loadWordTable(validWords);
    }
    
    
    /**
     * Resets all entities in level.
     */
    @Override
    public void resetLevel() {
    	Square[] squares = new Square[36];
    	int i = 0;
    	for (int y = 0; y < 6; y++) {
    		for (int x = 0; x < 6; x++) {
    			if (startingBoard.lookUpSquare(x, y).enabled) {
    				squares[i] = new Square(startingBoard.lookUpSquare(x, y).position, startingBoard.lookUpSquare(x, y).enabled, new Tile(startingBoard.lookUpSquare(x, y).tilePeek().letter));
    			}
    			else {
    				squares[i] = new Square(startingBoard.lookUpSquare(x, y).position, false);
    			}
    			i++;
    		}
    	}
    	this.board = new Board(squares);
    	currentScore = new Score(); // set currentScore to 0;
    	history.clear(); // clear move history
    	wordList.clear();
    }
    
    
    /**
     * Retrieves theme description.
     */
    public String getTheme() {
        return theme;
    }
    
    /**
     * Retrieves valid words for each theme level.
     */
    public ArrayList<String> getValidWords() {
    	return validWords;
    }
    
    /**
     * Retrieves the starting theme board.
     */
    public Board getStartingBoard() {
    	return startingBoard;
    }
    
}
