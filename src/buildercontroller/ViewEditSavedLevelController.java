package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEditSavedLevelController implements ActionListener {
	
	Application app;
	BuilderModel model;
	int levelNumber;

	@Override
	public void actionPerformed(ActionEvent e) {
		// if level exists open it, otherwise do nothing
		if (levelNumber < model.getSavedLevels().size()) {
			app.getEditSavedLevelApplications().get(levelNumber).resetPanel();
			app.setContentPane(app.getEditSavedLevelApplications().get(levelNumber));
		}
	}
	
	public ViewEditSavedLevelController(Application app, BuilderModel m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}