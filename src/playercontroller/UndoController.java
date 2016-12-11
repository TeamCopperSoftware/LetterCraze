package playercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import entities.*;
import playerboundary.Application;
import playerboundary.LevelApplication;

/**
 * Controls all actions to do with mouse events over the Undo Button in all levels.
 * <p>
 */

public class UndoController implements ActionListener {
	Application topLevelApp;
	LevelApplication level;
	public LevelModel model;

	

	public void actionPerformed(ActionEvent ae) {
		
		if (model.getHistorySize() > 0) {
			Move m = model.popFromHistory();
			boolean undoPerformed = m.undoMove();
			if (undoPerformed) {
				// remove undone word from completed words list
				level.getListModel().removeElementAt(model.getWordList().size());
				// if it is puzzle
				if (model.getType().equals("Puzzle")) {
					PuzzleLevel thisLevel1 = (PuzzleLevel)(model);
					level.incrementObjectiveValue();
					level.refreshPanel(model);
				}
				// if it is lightning
				if (model.getType().equals("Lightning")) {
					level.refreshPanel(model);
				}
				// if it is theme
				if (model.getType().equals("Theme")) {
					ThemeLevel thisLevel3 = (ThemeLevel)(model);
					level.incrementObjectiveValue();
					level.refreshPanel(model);

				}
			}
			
			
		}
		
		

	}

	public UndoController(Application topLevelApp, LevelApplication level, LevelModel model) {
		this.topLevelApp = topLevelApp;
		this.level = level;
		this.model = model;
	}


}