package entities;

public class Move {
	
	/**
	 * the selected word
	 */
	Word word;
	
	/**
	 * the selected word
	 */
	LevelModel level;
	
	/**
	 * Constructor for Move
	 * 
	 * @param word the selected word
	 * @param level the level in which the move is made
	 */
	public Move(Word word, LevelModel level) {
		this.word = word;
		this.level = level;
	}
	
	public boolean doMove() {
		if (isValidMove()) {
			//TODO: do Move
			//Get point value of the word
			//Remove word from board
			//Add word to completed word list
			//Fill empty squares with floating physics
			//Repopulate empty squares w/ rando letters (IF NOT A THEME LEVEL)
			return true;
		}
		return false;
	}
	
	public boolean undoMove() {
		return false;
	}
	
	public boolean isValidMove() {
		if (word.isValid()) {
		//are there any more stipulations? Check if timer has run out/etc.?
		return true;
		}
		else return false;
	}

}
