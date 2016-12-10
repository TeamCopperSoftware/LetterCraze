package playercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import entities.*;
import playerboundary.Application;
import playerboundary.LevelApplication;

/**
 * Controls all actions to do with mouse events over the Add Word Button in all levels.
 * <p>
 */

public class AddWordController implements ActionListener {
	Application topLevelApp;
	LevelApplication level;
	public LevelModel model;

	/**
	 * Provides all actions to add word button. Adds words to lists that were found.
	 * Updates history of added words when board is refreshed and score updates
	 * <p>
	 * @param ae ActionEvent
	 */

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
					
					// reset levelModel
					model.resetLevel();
					// reset application views
					PuzzleLevel thisLevel = (PuzzleLevel)(model);
					thisLevel.resetMovesDone();
					level.resetObjectiveValue(thisLevel.getMoveLimit());
					level.clearList();

					// return to mainmenu
					System.out.println("Score: " + thisLevel.getBestScore().getScore());
					System.out.println("Stars: " + thisLevel.getBestScore().getStar());
					topLevelApp.getModel().getMainLevels().unlockNextLevel(); //possibly unlock next level
					topLevelApp.getMapApplication().refreshPanel();
					topLevelApp.setContentPane(topLevelApp.getMapApplication());
				}
			}

			// decrement objectiveView if it is theme
			if (model.getType().equals("Theme")) {
				level.updateObjectiveValue(-1);
				int currentLabel = level.getObjectiveValue();
				if (currentLabel == 0) {
					
					// reset levelModel
					model.resetLevel();
					// reset application views
					ThemeLevel thisLevel = (ThemeLevel)(model);
					//TODO
					level.resetObjectiveValue(thisLevel.getWordList().size());
					level.clearList();
					// return to main menu
					System.out.println("Score: " + thisLevel.getBestScore().getScore());
					System.out.println("Stars: " + thisLevel.getBestScore().getStar());
					topLevelApp.getModel().getMainLevels().unlockNextLevel(); //possibly unlock next level
					topLevelApp.getMapApplication().refreshPanel();
					topLevelApp.setContentPane(topLevelApp.getMapApplication());
				}
			}

			// (HACK) set the current word to a placeholder that isn't valid
			// this is to make sure you can't keep playing the same word without making a new selection
			model.getBoard().setWord(new Word(new Square(new Position(0, 0), false, new Tile(""))));
		}

		// refresh board and update numScore
		level.refreshPanel(model);

	}


	/**
	 * Sets parameters for AddWordController setting up application, abstract level application
	 * and all levels in model
	 * <p>
	 * @param topLevelApp Application, level LevelApplication, model LevelModel
	 */
	
	public AddWordController(Application topLevelApp, LevelApplication level, LevelModel model) {
		this.topLevelApp = topLevelApp;
		this.level = level;
		this.model = model;
	}


}
