package entities;

import java.util.ArrayList;

public class Word {

    private ArrayList<Square> squares;
    private String letters;
    private int value; //TODO

    public Word(Square s) {
    	squares = new ArrayList<Square>();
    	letters = "";
    	if (s.getTile() != null) {
    		appendSquare(s);
    	}
    }
    

    public void appendSquare (Square s) {
        squares.add(s);
        letters += (s.tilePeek().toString()); 
    }
    
    public String toString () {
        return letters;
    }

    public boolean isValid () {
   		if (WordTable.isWord(letters)) {
   			if (letters.length() >= 3) { return true; }
   		}
   		return false;
    }
    
    public ArrayList<Square> getSquares() {
        return squares;
    }
    
    public int getScore() {
    	int score = 0;
    	if (squares.size() < 1) {
    		return 0;
    	}
    	for (int i = 0; i < squares.size(); i++) {
    		score += squares.get(i).getTile().getPoints();
    	}
    	return score;
    }

}
