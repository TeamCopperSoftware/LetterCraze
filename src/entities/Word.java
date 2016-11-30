package entities;

import java.util.ArrayList;

public class Word {

    ArrayList<Square> square;
    String letters;
    int value;

    public Word(Square s) {
        appendSquare (s);
    }
    
    public Word() {
    }

    void appendSquare (Square s) {
        square.add(s);
        letters.concat(s.tilePeek().toString());
    }
    
    public String toString () {
        return letters;
    }

    boolean isValid () {
        //TODO
        return false;
    }

}
