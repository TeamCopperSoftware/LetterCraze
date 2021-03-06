package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import entities.LevelModel;
import entities.Model;
import entities.Move;
import entities.ThemeLevel;
import entities.Word;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.ThemeLevelApplication;

public class TestUndoController extends TestCase {
	
	public void testInThemeLvl() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		Application app = new Application(model);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN");
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
		
		//Simulate model.getBoard().getWord(); to test
		//Button 1
		JButton butt1 = temeLvlApp.getButtonList()[2][2];
		SelectLetterController slc1 = new SelectLetterController(temeLvlApp, lvlMod, 0, 2, 2);
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt1"); //want butt.doClick or butt.doClick()
		slc1.actionPerformed(ae1);
		assertEquals(lvlMod.getBoard().getWord().toString(), "B");
		//Button 2
		JButton butt2 = temeLvlApp.getButtonList()[3][1];
		SelectLetterController slc2 = new SelectLetterController(temeLvlApp, lvlMod, 0, 3, 1);
		ActionEvent ae2 = new ActionEvent(butt2, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc2.actionPerformed(ae2);
		//Button 3
		JButton butt3 = temeLvlApp.getButtonList()[3][0];
		SelectLetterController slc3 = new SelectLetterController(temeLvlApp, lvlMod, 0, 3, 0);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		//Button 4
		JButton butt4 = temeLvlApp.getButtonList()[4][1];
		SelectLetterController slc4 = new SelectLetterController(temeLvlApp, lvlMod, 0, 4, 1);
		ActionEvent ae4 = new ActionEvent(butt4, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt4"); //want butt.doClick or butt.doClick()
		slc4.actionPerformed(ae4);
		assertEquals(lvlMod.getBoard().getWord().toString(), "BEAN");
		assertTrue(lvlMod.getBoard().getWord().isValid());
		
		AddWordController awc = new AddWordController(app, app.getMapApplication(), temeLvlApp, lvlMod);
		JButton butt6 = temeLvlApp.getConfirmButton();
		butt6.addActionListener(awc);
		ActionEvent ae6 = new ActionEvent(butt6, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		awc.actionPerformed(ae6);
		//assertEquals(lvlMod.getHistorySize(), 1);
			
		UndoController ucon = new UndoController(app, temeLvlApp, lvlMod);
		JButton butt9 = temeLvlApp.getUndoButton();
		butt9.addActionListener(ucon);
		ActionEvent ae9 = new ActionEvent(butt9, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		ucon.actionPerformed(ae9);
		
	}

}
