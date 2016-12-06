package entities;

import java.util.ArrayList;

public class Word {

    private ArrayList<Square> squares;
    private String letters;
    private int value; //TODO

    public Word(Square s) {
    	squares = new ArrayList<Square>();
    	letters = "";
    	appendSquare(s);
    }
    

    public void appendSquare (Square s) {
        squares.add(s);
        letters += (s.tilePeek().toString()); 
    }
    
    public String toString () {
        return letters;
    }

    boolean isValid () {
   		if (WordTable.isWord(letters)) {
   			if (letters.length() >= 3) { return true; }
   		}
   		return false;
    }
    
    ArrayList<Square> getSquares() {
        return squares;
    }

}
