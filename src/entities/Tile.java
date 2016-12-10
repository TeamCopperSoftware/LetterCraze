package entities;

import java.util.HashMap;

public class Tile {

    String letter;
    int value;

    public Tile (String letter) {
        this.letter = letter.toUpperCase();
        this.value = LetterInfo.getLetterValue(letter);
    }

    public String toString () {
        return letter.toUpperCase();
    }

    public int getPoints() {
        // TODO Auto-generated method stub
        return value;
    }
    
    public boolean isValid() {
    	if (letter.equals(letter.toUpperCase()) & (LetterInfo.getLetterValue(letter) == value)) 
    			{ return true; }
    	else if (this == null) { return false; }
    	else {return false;}
    	
    }
    
    public String getLetter() {
    	return letter;
    }
}

