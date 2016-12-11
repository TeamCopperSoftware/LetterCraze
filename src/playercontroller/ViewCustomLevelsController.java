package playercontroller;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.Application;
import playerboundary.LevelApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions when initializing custom levels controller.
 * <p>
 */

public class ViewCustomLevelsController implements ActionListener {
	
	Application app;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Deselect all tiles when we exit to MapApplication
		for (int i = 0; i < model.getCustomLevels().size(); i++) {
			LevelApplication levelapp = app.getCustomLevelApplications().get(i);
			LevelModel level = levelapp.getLevelModel();
			level.resetLevel();
			if (level.getType().equals("Puzzle")) {
				PuzzleLevel plevel = (PuzzleLevel)level;
				levelapp.resetObjectiveValue(plevel.getMoveLimit());
			}
			if (level.getType().equals("Lightning")) {
				LightningLevel llevel = (LightningLevel)level;
				levelapp.resetObjectiveValue(llevel.getTimeLimit());
			}
			if (level.getType().equals("Theme")) {
				ThemeLevel tlevel = (ThemeLevel)level;
				levelapp.resetObjectiveValue(tlevel.getValidWords().size());
			}


		}

		app.getViewCustomLevelsApplication().refreshPanel(); // refresh content before displaying panel
		app.setContentPane(app.getViewCustomLevelsApplication()); // display panel

		// Deselect all tiles and clear word list when we exit to MapApplication
		for (int i = 0; i < app.getCustomLevelApplications().size(); i++) {
			app.getCustomLevelApplications().get(i).deselectButtons();
			app.getCustomLevelApplications().get(i).clearList();
		}

	}
	
	/**
	 * Sets parameters for ViewCustomLevelsController.
	 * <p>
	 * @param app Application, m model, levelNumber int
	 */
	
	
	public ViewCustomLevelsController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}