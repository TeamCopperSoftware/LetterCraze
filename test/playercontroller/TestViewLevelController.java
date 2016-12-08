package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import entities.LevelModel;
import entities.Model;
import junit.framework.TestCase;
import playerboundary.Application;

public class TestViewLevelController extends TestCase {

	public void testPuzzle() {
		Model model = new Model();
		Application app = new Application(model);
		ViewLevelController vlc = new ViewLevelController(app, model, 0);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		vlc.actionPerformed(ae);
		
	}
	
	public void testLightning() {
		Model model = new Model();
		Application app = new Application(model);
		ViewLevelController vlc = new ViewLevelController(app, model, 1);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		vlc.actionPerformed(ae);
		
	}
	
	public void testTheme() {
		Model model = new Model();
		Application app = new Application(model);
		ViewLevelController vlc = new ViewLevelController(app, model, 2);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		vlc.actionPerformed(ae);
		
	}
	
}
