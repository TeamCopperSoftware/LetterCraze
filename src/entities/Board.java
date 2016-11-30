package entities;

import java.util.Hashtable;

public class Board {

    Hashtable<Position, Square> squares;
    Word currentWord;

    public Board () {
    }

    public Board (Square[] squares) {
        //TODO single array to hashtable
    }

    Square makeSquare (Position pos) {
        //TODO implement
    	int x = pos.row;
    	int y = pos.column;
    	
    	//Need a check to ensure new pos is valid
        return new Square(pos, true);
    }

    Square lookUpSquare (int x, int y) {
        //TODO implement
    	return null;
    }
    
    void removeWord (Word w) {
        //TODO implement
    }
    
    void repopulate () {
        //TODO implement
    }

}
