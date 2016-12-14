package playercontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.LevelModel;
import entities.Model;
import playerboundary.Application;
import playerboundary.LightningLevelApplication;
import playerboundary.SplashScreenApplication;

/**
 * Controls all actions to do with Timer functionality in lightning levels.
 * <p>
 */

public class LightningTimerController implements ActionListener {
	
	Application app;
	Model model;
	int levelNumber;

	/**
	 * Provides all actions to timer in lightning levels. Includes timer kicking user out
	 * of level when time runs out, refreshing level, and keeping track of best time.
	 * <p>
	 * @param e ActionEvent
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LightningLevelApplication l = (LightningLevelApplication) app.getLevelApplications().get(levelNumber);
		if(l.getTimeLeft() == 0)
        {
            l.getTimer().stop();
            // make sure we're still in the level before kicking us out to main menu
            // if we're somewhere else do't do anything
            if (app.getContentPane().equals(l)) {
            	
            	// Let the player know they have run out of time
				JOptionPane.showConfirmDialog(null, 
						"Time up!", "",
						JOptionPane.DEFAULT_OPTION);
				
            	l.clearList();
                l.getLevelModel().updateBestScore();
                LevelModel lm = model.getMainLevels().getLevels().get(levelNumber);
                System.out.println("Score: " + lm.getBestScore().getScore());
				System.out.println("Stars: " + lm.getBestScore().getStar());
				model.getMainLevels().unlockNextLevel(); //possibly unlock next level
                app.getMapApplication().refreshPanel();
            	app.setContentPane(app.getMapApplication());
            }
        }
        else
        {
           l.decrementTimeLeft();
           l.resetObjectiveValue(l.getTimeLeft());
        }
	}
	
	/**
	 * Sets parameters for LightningTimerController.
	 * <p>
	 * @param app Application, m Model, levelNumber int
	 */
	
	public LightningTimerController(Application app, Model m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}