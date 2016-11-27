package entities;

import java.util.Hashtable;

public class Board {

    Hashtable<Position, Square> squares;
    Word currentWord;

    public Board () {
        //TODO
        //is this constructor necessary?
    }

    public Board (Square[] squares) {
        //TODO
        //single array or double array?
        //how would this work with a hashtable?
    }

    Square lookUpSquare (Position pos) {
        //TODO implement
        return new Square();
    }

    Square lookUpSquare (int x, int y) {
        return lookUpSquare(new Position(x, y));
    }
    
    void removeWord (Word w) {
        //TODO implement
    }
    
    

}
