package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import entities.LevelModel;
import entities.Model;
import junit.framework.TestCase;
import playerboundary.Application;

public class TestViewMainMenuController extends TestCase {

	public void testNavigation() {
		Model model = new Model();
		Application app = new Application(model);
		ViewMainMenuController vmmc = new ViewMainMenuController(app, model);
		//ActionEvent e = app.mainMenu;
		//vmmc.actionPerformed(e);
		
		TestViewMainMenuController.java
	}
	
}
