package entities;

public class Word {

    Square square;
    String letters;
    int value;

    public Word(Square s) {
        this.square = s;
        //perhaps
        //      letters = "";
        //      appendSquare(s);
        //would be better
        //or figure out how to keep appended squares
        
    }

    void appendSquare (Square s) {
        //TODO
    }

    boolean isValid () {
        //TODO
        return false;
    }

}
