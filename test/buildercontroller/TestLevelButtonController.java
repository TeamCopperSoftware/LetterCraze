package buildercontroller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;
import entities.BuilderModel;
import junit.framework.TestCase;

public class TestLevelButtonController extends TestCase {
	
	public void testNavigation() {
		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		CreateNewLevelApplication level = new CreateNewLevelApplication(model);
		
		JButton butt0 = level.getSquareButtons()[2][2];
		JComboBox box0 = level.getLetterBoxes()[2][2];
		LevelButtonController lbc = new LevelButtonController(model, app, butt0, box0, 1);
		ActionEvent ae0 = new ActionEvent(butt0, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt");
		lbc.actionPerformed(ae0);
		lbc.actionPerformed(ae0);
	}
	
	public void testNavigation2() {
		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		CreateNewLevelApplication level = new CreateNewLevelApplication(model);
		
		JButton butt0 = level.getSquareButtons()[2][2];
		JComboBox box0 = level.getLetterBoxes()[2][2];
		level.setLevelType("Theme");
		LevelButtonController lbc = new LevelButtonController(model, app, butt0, box0, -1);
		ActionEvent ae0 = new ActionEvent(butt0, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt");
		lbc.actionPerformed(ae0);
		lbc.actionPerformed(ae0);
	}

}
