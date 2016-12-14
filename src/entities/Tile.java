package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Represents all entity information for Tile.
 */

public class Tile implements Serializable {

    /** Letter of the tile. */
    String letter;
    /** Value of each tile for score. */
    int value;

    /** 
     * Constructs Tile.
     * 
     * Initial value is given.
     * @param letter    letter of the tile
     */
    public Tile (String letter) {
        this.letter = letter.toUpperCase();
        this.value = LetterInfo.getLetterValue(letter);
    }

    /** Converts all letters to upper case. */
    public String toString () {
        return letter.toUpperCase();
    }

    /** Retrieves points for each tile. */
    public int getPoints() {
        // TODO Auto-generated method stub
        return value;
    }

    /** Checks if tile value is equal the letter value. */
    public boolean isValid() {
        if (letter.equals(letter.toUpperCase()) & (LetterInfo.getLetterValue(letter) == value)) 
        { return true; }
        else if (this == null) { return false; }
        else {return false;}

    }

    /** Retrieves letter for tile. */
    public String getLetter() {
        return letter;
    }
}

