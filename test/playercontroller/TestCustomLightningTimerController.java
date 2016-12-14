package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.ThemeLevel;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.LightningLevelApplication;
import playerboundary.ThemeLevelApplication;
import playermain.Main;

public class TestCustomLightningTimerController extends TestCase {
	
	public void testNavigation() {
		Main main = new Main();
		Model model = main.getModel();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(1);
		
		LightningLevel ligtLvl = new LightningLevel(lvlMod.getBoard(), lvlMod.getGoals(), 2);
		Application app = main.getApp();
		assertNotNull(app.getCustomLevelApplications());
		Timer t1 = new Timer(2, null);
		LightningLevelApplication ligtLvlApp = new LightningLevelApplication(ligtLvl, t1);
		app.getCustomLevelApplications().add(ligtLvlApp);
		app.getCustomLevelApplications().add(ligtLvlApp);
		app.getCustomLevelApplications().add(ligtLvlApp);
		
		CustomLightningTimerController cltc = new CustomLightningTimerController(app, model, 1);
		JButton butt = ligtLvlApp.getConfirmButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		cltc.actionPerformed(ae);
		
	}

}
