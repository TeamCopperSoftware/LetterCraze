package buildercontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import builderboundary.SplashScreenApplication;

/**
 * Controls all actions for Splash Screen properties in LetterCraze Builder.
 */
public class SplashScreenTimerController implements ActionListener {

	/** The main frame for LevelCraze. */
	Application app;
	/** Builder Model/Level information. */
	BuilderModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(app.getDisplayTime() == 0)
        {
            app.getSplashScreenTimer().stop();
            app.setContentPane(app.getInitializeBuilderApplication());
        }
        else
        {
            app.decrementDisplayTime();
        }
	}
	
	/** 
	 * Constructs SplashScreenTimerController.
	 * 
	 * Initial value is given.
	 * @param app			Main frame of LetterCraze
	 * @param m     		Model information for Builder
	 */	
	public SplashScreenTimerController(Application app, BuilderModel m) {
		this.app = app;
		this.model = m;
	}

}