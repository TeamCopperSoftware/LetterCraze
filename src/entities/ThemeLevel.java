package entities;

import java.io.IOException;
import java.util.ArrayList;

public class ThemeLevel extends LevelModel {

    String theme;
    ArrayList<String> validWords;
    Board startingBoard; // keeps track of the initial Board setup in case player wants to reset board;
    
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
    
    @Override
    void initializeWordTable() {
    	WordTable.loadWordTable(validWords);
    }
    
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
    
    public String getTheme() {
        return theme;
    }
    
    public ArrayList<String> getValidWords() {
    	return validWords;
    }
    
    public Board getStartingBoard() {
    	return startingBoard;
    }
    
}
