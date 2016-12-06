package playercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import entities.*;
import playerboundary.Application;
import playerboundary.LevelApplication;

public class AddWordController implements ActionListener {
	Application topLevelApp;
	LevelApplication level;
	public LevelModel model;

	public void actionPerformed(ActionEvent ae) {
		Word wordObject = model.getBoard().getWord();

		if (model.getBoard().getWord().isValid()) {
			Move move = new Move(wordObject, model);
			move.doMove();
			model.pushToHistory(move);
			
			// add word to list of found words
			level.getListModel().addElement(wordObject.toString());
			
			// decrement objectiveView if it is puzzle
			if (model.getType().equals("Puzzle")) {
				level.updateObjectiveValue(-1);
				int currentLabel = level.getObjectiveValue();
				if (currentLabel == 0) {
					model.exitLevel();
					// reset levelModel
					model.resetLevel();
					// reset application views
					PuzzleLevel thisLevel = (PuzzleLevel)(model);
					thisLevel.resetMovesDone();
					level.resetObjectiveValue(thisLevel.getMoveLimit());
					level.clearList();
					// return to mainmenu
					topLevelApp.getMapApplication().refreshPanel();
					topLevelApp.setContentPane(topLevelApp.getMapApplication());
				}
			}

			// decrement objectiveView if it is theme
			if (model.getType().equals("Theme")) {
				level.updateObjectiveValue(-1);
				int currentLabel = level.getObjectiveValue();
				if (currentLabel == 0) {
					model.exitLevel();
					// reset levelModel
					model.resetLevel();
					// reset application views
					ThemeLevel thisLevel = (ThemeLevel)(model);
					//TODO
					level.resetObjectiveValue(thisLevel.getWordList().size());
					level.clearList();
					// return to main menu
					topLevelApp.getMapApplication().refreshPanel();
					topLevelApp.setContentPane(topLevelApp.getMapApplication());
				}
			}
			
			// (HACK) set the current word to a placeholder that isn't valid
			// this is to make sure you can't keep playing the same word without making a new selection
			model.getBoard().setWord(new Word(new Square(new Position(0, 0), false, new Tile("", 0))));
		}

		// refresh board and update numScore
		level.refreshPanel(model);

	}

	public AddWordController(Application topLevelApp, LevelApplication level, LevelModel model) {
		this.topLevelApp = topLevelApp;
		this.level = level;
		this.model = model;
	}


}
