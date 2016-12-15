package playercontroller;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.Application;
import playerboundary.LevelApplication;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions when interacting with Adventure Map interface.
 */

public class ViewAdventureMapController implements ActionListener {
	
	/** The main frame for LevelCraze. */
	Application app;
	/** Player Model/Level information. */
	Model model;

	/**
	 * Provides all actions to the main map. Resets levels when user exits.
	 * Controls whether a level is accessible based on score.
	 * <p>
	 * @param e ActionEvent
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Deselect all tiles when we exit to MapApplication
		for (int i = 0; i < model.getMainLevels().getLevels().size(); i++) {
			LevelApplication levelapp = app.getLevelApplications().get(i);
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
		
		model.getMainLevels().unlockNextLevel();
		app.getMapApplication().refreshPanel(); // refresh content before displaying panel
		app.setContentPane(app.getMapApplication()); // display panel
		
		// Deselect all tiles when we exit to MapApplication
		for (int i = 0; i < app.getLevelApplications().size(); i++) {
			app.getLevelApplications().get(i).deselectButtons();
		}
		
		// Clear word list 
		for (int i = 0; i < app.getLevelApplications().size(); i++) {
			app.getLevelApplications().get(i).clearList();
		}
		
		
	}
	
	/**
	 * Sets parameters for ViewAdventureMapController.
	 * @param app Application
	 * @param m Model
	 */
	
	
	public ViewAdventureMapController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}