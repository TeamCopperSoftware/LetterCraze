package entities;

import java.util.Hashtable;

public class Board {

    Hashtable<Position, Square> squares;
    Word currentWord;

    public Board () {
    }

    public Board (Square[] squares) {
        this.squares = new Hashtable<Position, Square>(squares.length);
        for (int i = 0; i < squares.length; i++) {
            this.squares.put(squares[i].position, squares[i]);
        }
    }
    
    Square makeSquare (int x, int y) {
        //TODO Need a check to ensure new pos is valid
        return makeSquare (new Position(x, y));
    }

    Square makeSquare (Position pos) {
    	//TODO Need a check to ensure new pos is valid
        return new Square(pos, true);
    }

    Square lookUpSquare (int x, int y) {
    	return lookUpSquare (new Position(x, y));
    }
    
    Square lookUpSquare (Position pos) {
        return squares.get(pos);
    }
    
    void removeWord (Word w) {
        for (int i = 0; i < w.letters.length(); i++) {
            removeTile(w.square.get(i));
        }
    }
    
    Tile removeTile (Square sq) {
        return sq.tilePop();
    }
    
    
    void repopulate () {
        //TODO implement
    }

}
