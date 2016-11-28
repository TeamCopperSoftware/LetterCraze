package playercontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerboundary.Application;
import playerboundary.SplashScreenApplication;

public class SplashScreenTimerController implements ActionListener {
	
	Application app;
	Model model;

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
	
	public SplashScreenTimerController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}