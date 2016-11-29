package buildercontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import builderboundary.Application;
import builderboundary.SplashScreenApplication;

public class SplashScreenTimerController implements ActionListener {
	
	Application app;
	Model model;

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
	
	public SplashScreenTimerController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

}