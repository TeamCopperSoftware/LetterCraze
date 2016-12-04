package entities;

import java.util.ArrayList;

public class Word {

    ArrayList<Square> squares;
    String letters;
    int value;

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
        //TODO
        return false;
    }

}
