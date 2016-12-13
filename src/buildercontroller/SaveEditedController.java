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
import builderboundary.EditSavedLevelApplication;

/**
 * Controls all actions for editing saving levels in LetterCraze Builder.
 * <p>
 */
public class SaveEditedController implements ActionListener {

	/** Builder Model/Level information. */
    public BuilderModel model;
    /** The main frame for LevelCraze. */
    public Application app;
    /** Frame for saved level. */
    public EditSavedLevelApplication level;
    /** The position of the level in the model's ArrayList of saved levels, or -1 if creating a new level */
    int levelNumber;


	/** 
	 * Constructs SaveEditedController.
	 * 
	 * Initial value is given.
	 * @param m     		Model information for Builder
	 * @param app			Main frame of LetterCraze
	 * @param level			Frame for saved level
	 * @param levelNumber	Position of Level in list of levels
	 */
   public SaveEditedController(BuilderModel m, Application app, EditSavedLevelApplication level, int levelNumber) {
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
    		}
    		// if editing a saved level, overwrite that saved level
    		else if (levelNumber >= 0 && levelNumber <= 15) {
    			model.getSavedLevels().remove(levelNumber);
    			model.getSavedLevels().add(levelNumber, pl);
				JOptionPane.showConfirmDialog(null, "Custom level " + (levelNumber+1) + " updated.", "Save Successful", JOptionPane.DEFAULT_OPTION);

    		}
    		else {
    			// do nothing, user is limited to 15 custom levels (for now)
    		}
    	}
    	else if (level.getLevelType().equals("Lightning")) {
    		int timeLimit = (int)level.getTimeSpinner().getValue();
    		LightningLevel ll = new LightningLevel(b, g, timeLimit);
    		// if creating a new level, add to next spot in saved levels ArrayList (if spot is available)
    		if (levelNumber == -1 && model.getSavedLevels().size() < 15) {
    			model.getSavedLevels().add(ll);
    		}
    		// if editing a saved level, overwrite that saved level
    		else if (levelNumber >= 0 && levelNumber <= 15) {
    			model.getSavedLevels().remove(levelNumber);
    			model.getSavedLevels().add(levelNumber, ll);
				JOptionPane.showConfirmDialog(null, "Custom level " + (levelNumber+1) + " updated.", "Save Successful", JOptionPane.DEFAULT_OPTION);

    		}
    		else {
    			// do nothing, user is limited to 15 custom levels (for now)
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
    		}
    		// if editing a saved level, overwrite that saved level
    		else if (levelNumber >= 0 && levelNumber <= 15) {
    			model.getSavedLevels().remove(levelNumber);
    			model.getSavedLevels().add(levelNumber, tl);
				JOptionPane.showConfirmDialog(null, "Custom level " + (levelNumber+1) + " updated.", "Save Successful", JOptionPane.DEFAULT_OPTION);

    		}
    		else {
    			// do nothing, user is limited to 15 custom levels (for now)
    		}

    	}

    }

}