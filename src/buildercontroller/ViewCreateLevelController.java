package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.LevelModel;

public class ViewCreateLevelController implements ActionListener {
	
	Application app;
	BuilderModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.getCreateNewLevelApplication().resetPanel();
		app.setContentPane(app.getCreateNewLevelApplication());
	}
	
	public ViewCreateLevelController(Application app, BuilderModel m) {
		this.app = app;
		this.model = m;
	}

}
