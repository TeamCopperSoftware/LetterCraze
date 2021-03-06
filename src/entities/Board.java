package entities;

import java.io.Serializable;

/**
 * Represents all entity information for the level boards.
 */

public class Board implements Serializable {

    Square[][] squares;
    Word currentWord; 

    public Board () {

    }

    /** 
     * Construct board capable of retaining value in squares.
     * 
     * Initial value is given.
     * @param squares    36 valid tiles for all level boards
     */

    public Board (Square[] squares) {

        this.squares = new Square[6][6];

        for (int n = 0; n < squares.length; n++) {
            this.squares[squares[n].position().getX()][squares[n].position().getY()] = squares[n];
        }
    }

    /**
     * Makes new position of Square.
     * 
     * @param x    x position of square
     * @param y    y position of square
     * @return 		Square with new set coordinate position
     */

    public Square makeSquare (int x, int y) {
        //TODO Need a check to ensure new pos is valid
        return makeSquare (new Position(x, y));
    }

    /**
     * Makes a square appear on the board
     * 
     * @param pos    Position of Square
     * @return 		 Valid Square with position
     */

    public Square makeSquare (Position pos) {
        //TODO Need a check to ensure new pos is valid
        return new Square(pos, true);
    }

    /**
     * Looks up position of Square.
     * 
     * @param x    x position of square
     * @param y    y position of square
     * @return		Square position
     */


    public Square lookUpSquare (int x, int y) {
        return squares[x][y];
    }

    /**
     * Looks up if square should appear on board with position
     * 
     * @param pos    Position of Square
     * @return 		Square positions
     */

    public Square lookUpSquare (Position pos) {
        return lookUpSquare(pos.getX(), pos.getY());
    }

    /**
     * Removes all tiles that formed valid word on the board once added
     * 
     * @param w    Selected group of tiles that form a valid word
     */

    public void removeWord (Word w) {
        for (int i = 0; i < w.getSquares().size(); i++) {
            removeTile(w.getSquares().get(i));
        }
    }

    /**
     * Floats tiles up and repopulates empty squares with random generated tiles.
     * @param sq   Most recent square selected
     * @return removed tile
     */

    public Tile removeTile (Square sq) {
        return sq.tilePop();
    }

    /**
     * Floats tiles up and repopulates empty squares with random generated tiles.
     */

    public void repopulate () {
        // Iterate over every square on board (except bottom row)
        // don't need to check bottom squares because we know they don't have squares beneath them to take tiles from
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 6; x++) {
                // if square is enabled but doesn't have tile iterate over the squares underneath it
                if (squares[x][y].enabled && !squares[x][y].hasTile()) {
                    for (int y2 = y+1; y2 < 6; y2++) {
                        // if lower square is enabled and has a tile, remove it and add it to 1st square
                        if(squares[x][y2].enabled && squares[x][y2].hasTile()) {
                            Tile t = squares[x][y2].tilePop();
                            squares[x][y].tileAdd(t);
                            break;
                        }
                    }
                }
            }
        }

        // Iterate over every square on board
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                // if square is enabled and doesn't have a tile generate a new one
                if (squares[x][y].enabled && !squares[x][y].hasTile()) {
                    squares[x][y].generateRandomTile();
                }
            }
        }
    }

    /**
     * Returns the current word
     * @return formed word
     */

    public Word getWord() {
        return currentWord;
    }

    /**
     * Sets the current word
     * @param word  current word
     */

    public void setWord(Word word) {
        this.currentWord = word;
    }

    /**
     * Generates a new tile for each square on the board.
     */

    public void reset() {
        // Iterate over every square on board
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (squares[x][y].enabled) {
                    squares[x][y].generateRandomTile();	
                }
            }
        }
    }

    /**
     * Resets the board to the board given by b.
     * Used for themeLevels
     * @param b    board to be reset to
     */
    public void resetToBoard(Board b) {
        // Iterate over every square on board
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (squares[x][y].enabled) {
                    squares[x][y].tileAdd(b.lookUpSquare(x, y).getTile());
                }
            }
        }
    }

    /** 
     * Just float the tiles up (used for theme levels).
     */
    public void justFloatUp() {
        // Iterate over every square on board (except bottom row)
        // don't need to check bottom squares because we know they don't have squares beneath them to take tiles from
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 6; x++) {
                // if square is enabled but doesn't have tile iterate over the squares underneath it
                if (squares[x][y].enabled && !squares[x][y].hasTile()) {
                    for (int y2 = y+1; y2 < 6; y2++) {
                        // if lower square is enabled and has a tile, remove it and add it to 1st square
                        if(squares[x][y2].enabled && squares[x][y2].hasTile()) {
                            Tile t = squares[x][y2].tilePop();
                            squares[x][y].tileAdd(t);
                            break;
                        }
                    }
                }
            }
        }
    }

}
