package buildercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import entities.BuilderModel;
import entities.LevelModel;
import entities.Model;
import entities.ThemeLevel;
import junit.framework.TestCase;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;
import buildercontroller.AddWordController;

public class TestAddWordController extends TestCase {
	

	public void testInThemeLvl() {
		//TODO: Change to BuiderModel and such
		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		CreateNewLevelApplication lvlApp = app.getCreateNewLevelApplication();
		
		//make level a theme by selecting it
		JComboBox box = lvlApp.getGameModeComboBox();
		ActionEvent ae4 = new ActionEvent(box, (int) ActionEvent.MOUSE_EVENT_MASK, "change to theme"); //want butt.doClick or butt.doClick()
		box.actionPerformed(ae4);
		lvlApp.setLevelType("Theme");
		assertEquals(lvlApp.getLevelType(), "Theme");
		
		JTextField jtextbox = lvlApp.getWordField();
		jtextbox.setText("Testing");
		JButton butt0 = lvlApp.getAddWordButton();
		AddWordController awc = new AddWordController(model, app, 1);
		ActionEvent ae0 = new ActionEvent(butt0, (int) ActionEvent.MOUSE_EVENT_MASK, "change to theme"); //want butt.doClick or butt.doClick()
		awc.actionPerformed(ae0);
		assertNotSame(lvlApp.getWordList(), null);

	}

	
}
