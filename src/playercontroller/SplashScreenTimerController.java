package playercontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerboundary.Application;
import playerboundary.SplashScreenApplication;

/**
 * Controls length of time Splash screen appears on screen
 * when running the application.
 * <p>
 */

public class SplashScreenTimerController implements ActionListener {
	
	Application app;
	Model model;

	/**
	 * Provides action that controls time of splash screen.
	 * <p>
	 * @param ae ActionEvent
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(app.getDisplayTime() == 0)
        {
            app.getSplashScreenTimer().stop();
            app.setContentPane(app.getMainMenu());
        }
        else
        {
            app.decrementDisplayTime();
        }
	}

	/**
	 * Sets parameters for SplashScreenTimerController.
	 * <p>
	 * @param app Application, m Model
	 */
	
	public SplashScreenTimerController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}