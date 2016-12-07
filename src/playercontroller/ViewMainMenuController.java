package playercontroller;

import entities.Model;
import playerboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions when initializing Main menu
 * <p>
 */

public class ViewMainMenuController implements ActionListener {
	
	Application app;
	Model model;
	
	/**
	 * Provides main menu to application
	 * <p>
	 * @param ae ActionEvent
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getMainMenu());
	}
	
	/**
	 * Sets parameters for ViewMainMenuController
	 * <p>
	 * @param app Application, m model
	 */
	
	public ViewMainMenuController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}