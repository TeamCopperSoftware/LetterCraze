package entities;

import java.util.ArrayList;

public class Word {

    private ArrayList<Square> squares;
    private String letters;
    private int value; //TODO

    public Word(Square s) {
    	squares = new ArrayList<Square>();
    	letters = "";
    	if (s.getTile() != null) {
    		appendSquare(s);
    	}
    	value = s.tilePeek().getPoints();
    }
    

    public void appendSquare (Square s) {
        squares.add(s);
        letters += (s.tilePeek().toString());
        value = 0;
        for (int i = 0; i < squares.size(); i++) {
        	value += squares.get(i).tilePeek().getPoints();
        }
        value = value * (squares.size()-2);
    }
    
    public void removeSquare (Square s) {
        squares.remove(s);
        letters = "";
        value = 0;
        for (int i = 0; i < squares.size(); i++) {
        	letters += squares.get(i).tilePeek().letter;
        	value += squares.get(i).tilePeek().getPoints();
        }
        value = value * (squares.size()-2);
    }
    
    public String toString () {
        return letters;
    }

    public boolean isValid () {
   		if (WordTable.isWord(letters)) {
   			if (letters.length() >= 3) { return true; }
   		}
   		return false;
    }
    
    public ArrayList<Square> getSquares() {
        return squares;
    }
    
    public int getScore() {
    	return value;
    }

}
