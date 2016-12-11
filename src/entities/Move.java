package entities;

import playerboundary.LevelApplication;

import java.io.Serializable;

import entities.PuzzleLevel;

public class Move implements Serializable {
	
	/**
	 * the selected word
	 */
	Word word;
	
	/**
	 * the selected word
	 */
	LevelModel model;
	
	LevelApplication app;
	
	Tile[][] tileSetup;
	
	/**
	 * Constructor for Move
	 * 
	 * @param word the selected word
	 * @param level the level in which the move is made
	 */
	public Move(Word word, LevelModel model) {
		this.word = word;
		this.app = app;
		this.model = model;
		tileSetup = new Tile[6][6];
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				if (model.getBoard().lookUpSquare(x, y).isEnabled() && model.getBoard().lookUpSquare(x, y).hasTile()) {
					tileSetup[x][y] = new Tile(model.getBoard().lookUpSquare(x, y).tilePeek().getLetter());
				}
			}
		}
	}
	
	public boolean doMove() {
		if (isValidMove()) {
			//TODO: do Move
			
			// add word to model's word list
			model.getWordList().addElement(word.toString());
			
			// update numscore
			if (!model.getType().equals("Theme")) {
				int wordScore = word.getScore();
				model.getCurrentScore().updateScore(wordScore);
			}
			// in theme levels score is based on how many words you find
			else {
				model.getCurrentScore().updateScore(1);
			}
			
			
			// update star score (if necessary)
			// if current score is greater than star1 goal
			if (model.getCurrentScore().getScore() >= model.getGoals().getStar3()) {
				model.getCurrentScore().setStar(3);
			} else if (model.getCurrentScore().getScore() >= model.getGoals().getStar2()) {
				model.getCurrentScore().setStar(2);
			} else if (model.getCurrentScore().getScore() >= model.getGoals().getStar1()) {
				model.getCurrentScore().setStar(1);
			}
			
			// possibly update Best Score
			model.updateBestScore();
			
			// remove word from board
			model.getBoard().removeWord(word);
			
			// repopulate tiles if its a puzzle or lightning
			if (!model.getType().equals("Theme")) {
				// repopulate regularly
				model.getBoard().repopulate();
			} else {
				//System.out.println("THEMEFLOAT");
				// only want to float letters up, not generate new ones
				model.getBoard().justFloatUp();
			}
			
			// move completed
			return true;
		}
		return false;
	}
	
	public boolean undoMove() {
		
		if (model.getWordList().isEmpty()) {
			return false;
		}

		// remove word from model's word list
		int wordListSize = model.getWordList().size();
		model.getWordList().removeElementAt(wordListSize-1);

		// update numscore
		if (!model.getType().equals("Theme")) {
			int wordScore = word.getScore();
			model.getCurrentScore().updateScore(-1*wordScore);
			if (model.getBestScore().getScore() > model.getStartingBestScore().getScore()) {
				model.getBestScore().updateScore(-1*wordScore);
			}
		}
		// in theme levels score is based on how many words you find
		else {
			model.getCurrentScore().updateScore(-1);
			if (model.getBestScore().getScore() > model.getStartingBestScore().getScore()) {
				model.getBestScore().updateScore(-1);
			}
		}


		// update star score for current score (if necessary)
		if (model.getCurrentScore().getScore() < model.getGoals().getStar1()) {
			model.getCurrentScore().setStar(0);
		} else if (model.getCurrentScore().getScore() < model.getGoals().getStar2()) {
			model.getCurrentScore().setStar(1);
		} else if (model.getCurrentScore().getScore() < model.getGoals().getStar3()) {
			model.getCurrentScore().setStar(2);
		}
		else {
			model.getCurrentScore().setStar(3);
		}
		
		// update star score for best score (if necessary)
		if (model.getBestScore().getScore() < model.getGoals().getStar1()) {
			model.getBestScore().setStar(0);
		} else if (model.getBestScore().getScore() < model.getGoals().getStar2()) {
			model.getBestScore().setStar(1);
		} else if (model.getBestScore().getScore() < model.getGoals().getStar3()) {
			model.getBestScore().setStar(2);
		}
		else {
			model.getBestScore().setStar(3);
		}

		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				if (tileSetup[x][y] != null) {
					model.getBoard().lookUpSquare(x, y).tileAdd(tileSetup[x][y]);
				}
			}
		}

		return true;
	}

	
	public boolean isValidMove() {
		if (word.isValid()) {
			//if(model.getType() == "Theme") {
			//	if (themelvl.wordList) {return true;}
			//	else {return false;}
			//}  TODO: works in practice, but fails in tests
		return true;
		}
		else return false;
	}

}
