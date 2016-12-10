package playercontroller;

import entities.Model;
import playerboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions when initializing custom levels controller
 * <p>
 */

public class ViewCustomLevelsController implements ActionListener {
	
	Application app;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getViewCustomLevelsApplication());
	}
	
	/**
	 * Sets parameters for ViewCustomLevelsController
	 * <p>
	 * @param app Application, m model, levelNumber int
	 */
	
	
	public ViewCustomLevelsController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}