package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEditSavedLevelController implements ActionListener {
	
	Application app;
	BuilderModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getEditSavedLevelApplication());
	}
	
	public ViewEditSavedLevelController(Application app, BuilderModel m) {
		this.app = app;
		this.model = m;
	}

}