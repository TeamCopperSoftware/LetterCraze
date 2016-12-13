package buildercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entities.*;
import playerboundary.LevelApplication;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

/**
 * 
 */
public class SaveController implements ActionListener {

	/**
	 * 
	 */
	public BuilderModel model;

	/**
	 * 
	 */
	public Application app;

	/**
	 * 
	 */
	public CreateNewLevelApplication level;

	/**
	 * The position of the level in the model's ArrayList of saved levels, or -1 if creating a new level
	 */
	int levelNumber;


	/**
	 * @param LevelModel m 
	 * @param CreateNewLevelApplication app
	 */
	public SaveController(BuilderModel m, Application app, CreateNewLevelApplication level, int levelNumber) {
		this.model = m;
		this.app = app;
		this.level = level;
		this.levelNumber = levelNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// create board
		Square[] squareArray = new Square[36];
		int i = 0;
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				// if button is selected, square is enabled
				if (level.getSquareButtons()[x][y].getBackground().equals(Color.WHITE)) {
					squareArray[i] = new Square(new Position(x,y), true, new Tile((String)level.getLetterBoxes()[x][y].getSelectedItem()));
				}
				else {
					squareArray[i] = new Square(new Position(x, y), false, new Tile((String)level.getLetterBoxes()[x][y].getSelectedItem()));
				}
				i++;
			}
		}
		Board b = new Board(squareArray);
		Goal g = new Goal(level.getStarGoals()[0], level.getStarGoals()[1], level.getStarGoals()[2]);

		// create objects specific to Puzzle, Lightning, or Theme Levels
		if (level.getLevelType().equals("Puzzle")) {
			int moveLimit = (int)level.getNumMovesSpinner().getValue();
			PuzzleLevel pl = new PuzzleLevel(b, g, moveLimit);
			// if creating a new level, add to next spot in saved levels ArrayList (if spot is available)
			if (levelNumber == -1 && model.getSavedLevels().size() < 15) {
				model.getSavedLevels().add(pl);
				JOptionPane.showConfirmDialog(null, "Level saved to spot " + model.getSavedLevels().size() + ".", "Save Successful", JOptionPane.DEFAULT_OPTION);
			}
			// if editing a saved level, overwrite that saved level
			else if (levelNumber >= 0 && levelNumber <= 15) {
				model.getSavedLevels().remove(levelNumber);
				model.getSavedLevels().add(levelNumber, pl);
				JOptionPane.showConfirmDialog(null, "Custom level " + levelNumber + " updated.", "Save Successful", JOptionPane.DEFAULT_OPTION);
			}
			else {
				// do nothing, user is limited to 15 custom levels (for now)
				JOptionPane.showConfirmDialog(null, 
						"Level cannot be saved.\n"
								+ "You may only save up to 15 custom levels. You need\n"
								+ "to delete a saved level before you can save this one.", "Save Error", JOptionPane.DEFAULT_OPTION);
			}
		}
		else if (level.getLevelType().equals("Lightning")) {
			int timeLimit = (int)level.getTimeSpinner().getValue();
			LightningLevel ll = new LightningLevel(b, g, 30);
			// if creating a new level, add to next spot in saved levels ArrayList (if spot is available)
			if (levelNumber == -1 && model.getSavedLevels().size() < 15) {
				model.getSavedLevels().add(ll);
				JOptionPane.showConfirmDialog(null, "Custom level saved to spot " + model.getSavedLevels().size() + ".", "Save Successful", JOptionPane.DEFAULT_OPTION);

			}
			// if editing a saved level, overwrite that saved level
			else if (levelNumber >= 0 && levelNumber <= 15) {
				model.getSavedLevels().remove(levelNumber);
				model.getSavedLevels().add(levelNumber, ll);
				JOptionPane.showConfirmDialog(null, "Custom level " + levelNumber + " updated.", "Save Successful", JOptionPane.DEFAULT_OPTION);

			}
			else {
				// do nothing, user is limited to 15 custom levels (for now)
				JOptionPane.showConfirmDialog(null, 
						"Level cannot be saved.\n"
								+ "You may only save up to 15 custom levels. You need\n"
								+ "to delete a saved level before you can save this one.", "Save Error", JOptionPane.DEFAULT_OPTION);
			}
		}
		else if (level.getLevelType().equals("Theme")) {
			String theme = level.getThemeField().getText();
			ArrayList<String> words = new ArrayList<String>();
			for (int j = 0; j < level.getWordList().getModel().getSize(); j++) {
				words.add((String)level.getWordList().getModel().getElementAt(j));
			}
			ThemeLevel tl = new ThemeLevel(b, g, theme, words);
			// if creating a new level, add to next spot in saved levels ArrayList (if spot is available)
			if (levelNumber == -1 && model.getSavedLevels().size() < 15) {
				model.getSavedLevels().add(tl);
				JOptionPane.showConfirmDialog(null, "Custom level saved to spot " + model.getSavedLevels().size() + ".", "Save Successful", JOptionPane.DEFAULT_OPTION);

			}
			// if editing a saved level, overwrite that saved level
			else if (levelNumber >= 0 && levelNumber <= 15) {
				model.getSavedLevels().remove(levelNumber);
				model.getSavedLevels().add(levelNumber, tl);
				JOptionPane.showConfirmDialog(null, "Level " + levelNumber + " updated.", "Save Successful", JOptionPane.DEFAULT_OPTION);

			}
			else {
				// do nothing, user is limited to 15 custom levels (for now)
				JOptionPane.showConfirmDialog(null, 
						"Level cannot be saved.\n"
								+ "You may only save up to 15 custom levels. You need\n"
								+ "to delete a saved level before you can save this one.", "Save Error", JOptionPane.DEFAULT_OPTION);
			}

		}
		// reset panel for next level
		app.getCreateNewLevelApplication().resetPanel();

	}

}