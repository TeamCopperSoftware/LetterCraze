package entities;

public class Tile {

    String letter;
    int value;

    public Tile (String letter, int value) {
        this.letter = letter.toUpperCase();
        this.value = value;
    }

    public String toString () {
        return letter.toUpperCase();
    }

    public int getPoints() {
        // TODO Auto-generated method stub
        return value;
    }
}

