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
        this.startingBoard = b;
    }
    
    @Override
    void initializeWordTable() {
    	WordTable.loadWordTable(validWords);
    }
    
    @Override
    public void resetLevel() {
    	this.board = startingBoard;
    	currentScore = new Score(); // set currentScore to 0;
    	history.clear(); // clear move history
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
