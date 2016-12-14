package entities;

import java.io.Serializable;

/**
 * Represents all entity information for square.
 */


public class Square implements Serializable {

    /** Location of each square based on (X,Y) Coordinates. */
    Position position;
    /** Tile for each square. */
    Tile tile;
    /** Enables square. */
    boolean enabled;

    /** 
     * Constructs square.
     * 
     * Initial value is given.
     * @param p    		Position of the square
     * @param enabled   Whether the square is enabled
     * @param t 		Adds tile and its properties to each square
     */
    public Square(Position p, boolean enabled, Tile t) {
        this.position = p;
        this.enabled = enabled;
        this.tile = t;
    }

    /** 
     * Constructs square.
     * 
     * Initial value is given.
     * @param p    		Position of the square
     * @param enabled   Whether the square is enabled
     */
    public Square(Position p, boolean enabled) {
        this.position = p;
        this.enabled = enabled;
        this.tile = null;
    }

    public Square() {}

    /** Sets frequency of each letter appearing randomly in puzzle or lightning level. */
    void generateRandomTile () {
        int[] weights = {12702,
                9056,
                8167,
                7507,
                6966,
                6749,
                6327,
                6094,
                5987,
                4253,
                4025,
                2782,
                2758,
                2406,
                2360,
                2228,
                2015,
                1974,
                1929,
                1492,
                978,
                772,
                153,
                150,
                95,
                74};

        String[] letters = {"E",
                "T",
                "A",
                "O",
                "I",
                "N",
                "S",
                "H",
                "R",
                "D",
                "L",
                "C",
                "U",
                "M",
                "W",
                "F",
                "G",
                "Y",
                "P",
                "B",
                "V",
                "K",
                "J",
                "X",
                "QU",
        "Z"};
        int[] values = {
                1, 
                1,
                2,
                2,
                2,
                2,
                2,
                2,
                2,
                3,
                3,
                3,
                3,
                3,
                3, 
                4,
                4, 
                4, 
                4, 
                4, 
                5, 
                5, 
                7, 
                7, 
                8, 
                8, 
        };
        int totalWeight = 99999; // this is the sum of the weights above (don't know if it should be 100000)
        int random = (int)(Math.floor(Math.random() * totalWeight));
        int sum = 0;
        Tile t = new Tile("");
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (random < sum) {
                t = new Tile(letters[i]);
                break;
            }
        }
        this.tile = t;


    }

    /** Adds tile. 
     *  @param t   the Tile to be added to the square 
     */
    void tileAdd (Tile t) {
        this.tile = t;
    }

    /** Returns the current tile. 
     * @return     returns the current tile
     */
    public Tile tilePeek () {
        return tile;
    }

    /** Removes and returns the current tile. */
    Tile tilePop () {
        Tile t = tile;
        tileRemove();
        return t;
    }

    /** Sets tile to null. */
    void tileRemove () {
        tile = null;
    }

    /** Position of square. */
    Position position() {
        return position;

    }

    /** Checks if square is enabled. 
     * 
     * @return     <code>true</code> if enabled; <code>false</code> if not. 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /** Checks if square has tile. */
    public boolean hasTile() {
        return tile != null;
    }

    /** Retrieves tile. */
    public Tile getTile() {
        return tile;
    }

}
