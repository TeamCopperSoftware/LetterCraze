package entities;

import java.util.ArrayList;

public class Word {

    ArrayList<Square> squares;
    Square s;
    String letters;
    int value;

    public Word(Square s) {
    	this.s = s;
    	appendSquare(s);
    }
    

    void appendSquare (Square s) {
        squares.add(s);
        if (!(squares.isEmpty())) { letters.concat(s.tilePeek().toString()); }
    }
    
    public String toString () {
        return letters;
    }

    boolean isValid (String s) {
        //TODO
        return false;
    }

}
