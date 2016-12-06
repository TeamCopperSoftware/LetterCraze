package entities;

public class Board {

	//Hashtable<Position, Square> squares;
	Square[][] squares;
	Word currentWord;  //TODO: Never used anywhere???

	public Board () {
	}

	public Board (Square[] squares) {

		this.squares = new Square[6][6];

		for (int n = 0; n < squares.length; n++) {
			this.squares[squares[n].position().getX()][squares[n].position().getY()] = squares[n];
		}
	}

	public Square makeSquare (int x, int y) {
		//TODO Need a check to ensure new pos is valid
		return makeSquare (new Position(x, y));
	}

	public Square makeSquare (Position pos) {
		//TODO Need a check to ensure new pos is valid
		return new Square(pos, true);
	}

	public Square lookUpSquare (int x, int y) {
		return squares[x][y];
	}

	public Square lookUpSquare (Position pos) {
		return lookUpSquare(pos.getX(), pos.getY());
	}

	public void removeWord (Word w) {
		for (int i = 0; i < w.toString().length(); i++) {
			removeTile(w.getSquares().get(i));
		}
	}

	public Tile removeTile (Square sq) {
		return sq.tilePop();
	}

	/**
	 * floats tiles up and repopulates empty squares with random generated tiles
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

	public Word getWord() {
		return currentWord;
	}

	public void setWord(Word word) {
		this.currentWord = word;
	}

	/**
	 * generates a new tile for each square on the board
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
	 * @param b
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
	 * Just float the tiles up (used for theme levels)
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
