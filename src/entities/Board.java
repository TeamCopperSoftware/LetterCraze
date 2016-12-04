package entities;

import java.util.Hashtable;

public class Board {

    //Hashtable<Position, Square> squares;
    Square[][] squares;
    Word currentWord;

    public Board () {
    }

    public Board (Square[] squares) {
    	int n = 0;
        this.squares = new Square[6][6];
        for (int y = 0; y < 6; y++) {
        	for (int x = 0; x < 6; x++) {
        		this.squares[x][y] = squares[n];
        		n++;
        	}
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

    public Square lookUpSquare (int x, int y) {
    	return squares[x][y];
    }
    
    public Square lookUpSquare (Position pos) {
        return lookUpSquare(pos.column, pos.row);
    }
    
    void removeWord (Word w) {
        for (int i = 0; i < w.letters.length(); i++) {
            removeTile(w.squares.get(i));
        }
    }
    
    Tile removeTile (Square sq) {
        return sq.tilePop();
    }
    
    
    void repopulate () {
        //TODO implement
    }

}
