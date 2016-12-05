package entities;

import java.util.ArrayList;

public class Word {

    private ArrayList<Square> squares;
    private String letters;
    private int value;

    public Word(Square s) {
    	squares = new ArrayList<Square>();
    	letters = "";
    	appendSquare(s);
    }
    

    void appendSquare (Square s) {
        squares.add(s);
        letters += (s.tilePeek().toString()); 
    }
    
    public String toString () {
        return letters;
    }

    boolean isValid (String s) {
        return WordTable.isWord(letters);
    }
    
    ArrayList<Square> getSquares() {
        return squares;
    }

}
