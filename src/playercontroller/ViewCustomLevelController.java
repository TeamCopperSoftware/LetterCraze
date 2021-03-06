package playercontroller;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.Application;
import playerboundary.LightningLevelApplication;
import playerboundary.ThemeLevelApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions when initializing custom level views.
 */


public class ViewCustomLevelController implements ActionListener {
	
	/** The main frame for LevelCraze. */
	Application app;
	/** LetterCraze information. */
	Model model;
	/** The level number. */
	int levelNumber;

	/**
	 * Provides all actions to level when accessed.
	 * <p>
	 * @param e ActionEvent
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LevelModel level = model.getCustomLevels().get(levelNumber);
		if (level.getIsUnlocked()) {
			level.initializeLevel();
			if (level.getType().equals("Puzzle")) {
				app.getCustomLevelApplications().get(levelNumber).refreshPanel((PuzzleLevel)level);
				app.setContentPane(app.getCustomLevelApplications().get(levelNumber));
			}
			else if (level.getType().equals("Lightning")) {
				LightningLevelApplication l = (LightningLevelApplication)app.getCustomLevelApplications().get(levelNumber);
				l.refreshPanel((LightningLevel)level);
				l.initializeTimeLeft();
				l.getTimer().start();
				app.setContentPane(l);
			}
			else {
				app.getCustomLevelApplications().get(levelNumber).refreshPanel((ThemeLevel)level);
				((ThemeLevelApplication) app.getCustomLevelApplications().get(levelNumber)).refreshObjective((ThemeLevel)level);
				app.setContentPane(app.getCustomLevelApplications().get(levelNumber));
			}
		}
	}
	
	/**
	 * Sets parameters for ViewCustomLevelController.
	 * <p>
	 * @param app Application
	 * @param m model
	 * @param levelNumber level number
	 */
	
	public ViewCustomLevelController(Application app, Model m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}