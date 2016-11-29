package playercontroller;

import entities.Model;
import playerboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomMenuApplicationBackButtonController implements ActionListener {
	
	Application app;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getMainMenu());
	}
	
	public CustomMenuApplicationBackButtonController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}