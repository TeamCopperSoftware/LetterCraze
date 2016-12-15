package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents all entity information for Word.
 */
public class Word implements Serializable {

    /** List of squares that forms a word. */
    private ArrayList<Square> squares;
    /** Formed word from list of letters. */
    private String letters;
    /** Score value of formed word. */
    private int value;

    /** 
     * Constructs Word.
     * 
     * Initial value is given.
     * @param s    Letter to be added until word is formed
     */

    public Word(Square s) {
        squares = new ArrayList<Square>();
        letters = "";
        if (s.getTile() != null) {
            appendSquare(s);
        }
        value = s.tilePeek().getPoints();
    }

    /** Adds square to word. 
     * 
     * @param s    Square to be appended
     */
    public void appendSquare (Square s) {
        squares.add(s);
        letters += (s.tilePeek().toString());
        value = 0;
        for (int i = 0; i < squares.size(); i++) {
            value += squares.get(i).tilePeek().getPoints();
        }
        value = value * (letters.length()-2);
    }

    /** Removes most recently added square to word. 
     * @param s    Square to be removed
     */
    public void removeSquare (Square s) {
        squares.remove(s);
        letters = "";
        value = 0;
        for (int i = 0; i < squares.size(); i++) {
            letters += squares.get(i).tilePeek().letter;
            value += squares.get(i).tilePeek().getPoints();
        }
        value = value * (letters.length()-2);
    }

    /** Returns formed word from list of letters. */
    public String toString () {
        return letters;
    }

    /** Checks if word is equal to or more than three letters.
     * @return validity of whether formed word is more than three tiles
      */
    public boolean isValid () {
        if (WordTable.isWord(letters)) {
            if (letters.length() >= 3) { return true; }
        }
        return false;
    }

    /** Retrieves list of squares.
     * @return  formed list of squares
     */
    public ArrayList<Square> getSquares() {
        return squares;
    }

    /** Retrieves score number.
     * @return number of points earned from formed word
     */
    public int getScore() {
        return value;
    }

}
