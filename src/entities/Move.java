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
		return false;
	}
	
	public boolean undoMove() {
		return false;
	}
	
	public boolean isValidMove() {
		if (WordTable.isWord(word.toString())) {
			return true;
		}
		return false;
	}

}
