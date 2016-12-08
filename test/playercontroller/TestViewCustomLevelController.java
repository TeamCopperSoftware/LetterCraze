package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import junit.framework.TestCase;
import playerboundary.Application;

public class TestViewCustomLevelController extends TestCase {

	public void testPuzzle() {
		Model model = new Model();
		Application app = new Application(model);
		ViewCustomLevelController vclc = new ViewCustomLevelController(app, model, 0);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		vclc.actionPerformed(ae);
		
	}
	
	
}
