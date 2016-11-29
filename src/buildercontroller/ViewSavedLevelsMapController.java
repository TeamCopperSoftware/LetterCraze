package buildercontroller;

import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSavedLevelsMapController implements ActionListener {
	
	Application app;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getSavedLevelsMapApplication());
	}
	
	public ViewSavedLevelsMapController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}