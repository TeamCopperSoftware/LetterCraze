package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import entities.LevelModel;
import entities.Model;
import entities.PuzzleLevel;
import entities.Word;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.LevelApplication;
import playerboundary.PuzzleLevelApplication;

public class TestSelectLetterController extends TestCase {

	public void testClickOne() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(0);
		PuzzleLevel puzzLvl = new PuzzleLevel(lvlMod.getBoard(), null, 1);
		Application app = new Application(model);
		PuzzleLevelApplication puzzLvlApp = new PuzzleLevelApplication(puzzLvl);
						
		//Now actually try to press button from here
		JButton butt = puzzLvlApp.getButtonList()[2][0];
		SelectLetterController slc = new SelectLetterController(puzzLvlApp, lvlMod, 0, 2, 0);
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		slc.actionPerformed(ae);
		assertEquals(lvlMod.getBoard().getWord().toString(), "R");
	}
	
	public void testClickManyThenDisselect() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(0);
		PuzzleLevel puzzLvl = new PuzzleLevel(lvlMod.getBoard(), null, 1);
		Application app = new Application(model);
		PuzzleLevelApplication puzzLvlApp = new PuzzleLevelApplication(puzzLvl);
						
		//Button 1
		JButton butt1 = puzzLvlApp.getButtonList()[0][0];
		SelectLetterController slc1 = new SelectLetterController(puzzLvlApp, lvlMod, 0, 0, 0);
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt1"); //want butt.doClick or butt.doClick()
		slc1.actionPerformed(ae1);
		assertEquals(lvlMod.getBoard().getWord().toString(), "W");
		//Button 2
		JButton butt2 = puzzLvlApp.getButtonList()[1][0];
		SelectLetterController slc2 = new SelectLetterController(puzzLvlApp, lvlMod, 0, 1, 0);
		ActionEvent ae2 = new ActionEvent(butt2, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc2.actionPerformed(ae2);
		assertEquals(lvlMod.getBoard().getWord().toString(), "WO");
		//Button 3
		JButton butt3 = puzzLvlApp.getButtonList()[2][0];
		SelectLetterController slc3 = new SelectLetterController(puzzLvlApp, lvlMod, 0, 2, 0);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		assertEquals(lvlMod.getBoard().getWord().toString(), "WOR");
		//Button 4
		JButton butt4 = puzzLvlApp.getButtonList()[2][0];
		SelectLetterController slc4 = new SelectLetterController(puzzLvlApp, lvlMod, 0, 3, 0);
		ActionEvent ae4 = new ActionEvent(butt4, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt4"); //want butt.doClick or butt.doClick()
		slc4.actionPerformed(ae4);
		assertEquals(lvlMod.getBoard().getWord().toString(), "WORD");
		//Disselect button 4
		slc4.actionPerformed(ae4);
		//assertEquals(lvlMod.getBoard().getWord().toString(), "WOR");
		//^^ should not fail once disselecting a Tile reflects in Word
	}
	
}
