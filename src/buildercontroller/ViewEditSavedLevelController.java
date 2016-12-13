package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions for viewing editing saving levels in LetterCraze Builder.
 * <p>
 */
public class ViewEditSavedLevelController implements ActionListener {
	
    /** The main frame for LevelCraze. */
	Application app;
	/** Builder Model/Level information. */
	BuilderModel model;
    /** The position of the level in the model's ArrayList of saved levels, or -1 if creating a new level */
	int levelNumber;

	@Override
	public void actionPerformed(ActionEvent e) {
		// if level exists open it, otherwise do nothing
		if (levelNumber < model.getSavedLevels().size()) {
			app.getEditSavedLevelApplications().get(levelNumber).resetPanel();
			app.setContentPane(app.getEditSavedLevelApplications().get(levelNumber));
		}
	}
	
	/** 
	 * Constructs ViewEditSavedLevelController.
	 * 
	 * Initial value is given.
	 * @param app			Main frame of LetterCraze
	 * @param m     		Model information for Builder
	 * @param levelNumber	Position of Level in list of levels
	 */
	public ViewEditSavedLevelController(Application app, BuilderModel m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}