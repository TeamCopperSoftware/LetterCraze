package buildercontroller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

import entities.BuilderModel;
import entities.Model;
import junit.framework.TestCase;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

public class TestSaveController extends TestCase {
	
	public void testNavigation() {
		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		CreateNewLevelApplication level = app.getCreateNewLevelApplication();
		
		JButton butt0 = level.getSquareButtons()[2][2];
		JComboBox box0 = level.getLetterBoxes()[2][2];
		LevelButtonController lbc = new LevelButtonController(model, app, butt0, box0, 1);
		ActionEvent ae0 = new ActionEvent(butt0, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt");
		lbc.actionPerformed(ae0);
		
		SaveController savc = new SaveController(model, app, level, 1);
		JButton butt1 = level.getBackButton();
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		//savc.actionPerformed(ae1);
		level.resetPanel();
		
	}

}
