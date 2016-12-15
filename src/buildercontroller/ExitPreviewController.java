package buildercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderboundary.Application;
import entities.BuilderModel;

/**
 * Controls all actions when exiting out of preview mode in LetterCraze Builder.
 */

public class ExitPreviewController implements ActionListener {
	
	Application application;
	BuilderModel model;
	int levelNumber;
	
	public ExitPreviewController(Application app, BuilderModel model, int levelNumber) {
		this.application = app;
		this.model = model;
		this.levelNumber = levelNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if creating a new level go back to CreateNewLevelApplication
		if (levelNumber == -1) {
			application.setContentPane(application.getCreateNewLevelApplication());
		}
		// if editing a saved level go back to EditSavedLevelApplication
		else {
			application.setContentPane(application.getEditSavedLevelApplications().get(levelNumber));
		}
		
	}

}
