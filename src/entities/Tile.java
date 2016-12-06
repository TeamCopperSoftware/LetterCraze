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
}

