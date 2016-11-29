package buildercontroller;

import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCreateLevelController implements ActionListener {
	
	Application app;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getCreateNewLevelApplication());
	}
	
	public ViewCreateLevelController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}
