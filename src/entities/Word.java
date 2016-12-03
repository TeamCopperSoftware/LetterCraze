package entities;

import java.util.ArrayList;

public class Word {

    ArrayList<Square> square;
    String letters;
    int value;

    public Word(Square s) {
        appendSquare (s);
    }
    

    void appendSquare (Square s) {
        square.add(s);
        letters.concat(s.tilePeek().toString());
    }
    
    public String toString () {
        return letters;
    }

    boolean isValid (String s) {
        //TODO
        return false;
    }

}
