package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.Move;
import entities.ThemeLevel;
import entities.Word;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.LevelApplication;
import playerboundary.LightningLevelApplication;
import playerboundary.ThemeLevelApplication;

public class TestSelectLetterController extends TestCase {

	public void testClickOneValid() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
		//Now actually try to press button from here
		JButton butt = temeLvlApp.getButtonList()[2][0];
		SelectLetterController slc = new SelectLetterController(temeLvlApp, lvlMod, 0, 2, 0);
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		slc.actionPerformed(ae);
		assertEquals(lvlMod.getBoard().getWord().toString(), "R");
	}
	
	public void testClickOneInvalid() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
		//JButton butt1 = temeLvlApp.getButtonList()[-2][0];
		//Auto throws OutOfBoundsException, don't need to test further
		
		//JButton butt2 = temeLvlApp.getButtonList()[4][9];
		//Also auto throws OutOfBoundsException, don't need to test further
	}
	
	public void testClickManyThenDisselect() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
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
		assertEquals(lvlMod.getBoard().getWord().toString(), "BE");
		//Button 3
		JButton butt3 = temeLvlApp.getButtonList()[3][0];
		SelectLetterController slc3 = new SelectLetterController(temeLvlApp, lvlMod, 0, 3, 0);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		assertEquals(lvlMod.getBoard().getWord().toString(), "BEA");
		//Button 4
		JButton butt4 = temeLvlApp.getButtonList()[4][1];
		SelectLetterController slc4 = new SelectLetterController(temeLvlApp, lvlMod, 0, 4, 1);
		ActionEvent ae4 = new ActionEvent(butt4, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt4"); //want butt.doClick or butt.doClick()
		slc4.actionPerformed(ae4);
		assertEquals(lvlMod.getBoard().getWord().toString(), "BEAN");
		//Disselect button 4
		slc4.actionPerformed(ae4);
		assertEquals(lvlMod.getBoard().getWord().toString(), "BEA");
		//^^ should not fail once disselecting a Tile reflects in Word
	}
	
	public void testClickManyThenRemoveValidWord() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
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
		assertEquals(lvlMod.getBoard().getWord().toString(), "BE");
		//Button 3
		JButton butt3 = temeLvlApp.getButtonList()[3][0];
		SelectLetterController slc3 = new SelectLetterController(temeLvlApp, lvlMod, 0, 3, 0);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		assertEquals(lvlMod.getBoard().getWord().toString(), "BEA");
		//Button 4
		JButton butt4 = temeLvlApp.getButtonList()[4][1];
		SelectLetterController slc4 = new SelectLetterController(temeLvlApp, lvlMod, 0, 4, 1);
		ActionEvent ae4 = new ActionEvent(butt4, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt4"); //want butt.doClick or butt.doClick()
		slc4.actionPerformed(ae4);
		assertEquals(lvlMod.getBoard().getWord().toString(), "BEAN");
		//Remove selected VALID word
		assertEquals(lvlMod.getBoard().lookUpSquare(3, 0).getTile().toString(), "A");
		Move move = new Move (lvlMod.getBoard().getWord(), lvlMod);
		assertTrue(move.doMove());
		assertNotSame(lvlMod.getBoard().lookUpSquare(3, 0).getTile().toString(), "A");
		
	}
	
	public void testClickManyThenRemoveInvalidWord() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
		//Button 1
		JButton butt1 = temeLvlApp.getButtonList()[0][0];
		SelectLetterController slc1 = new SelectLetterController(temeLvlApp, lvlMod, 0, 0, 0);
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt1"); //want butt.doClick or butt.doClick()
		slc1.actionPerformed(ae1);
		assertEquals(lvlMod.getBoard().getWord().toString(), "N");
		//Button 2
		JButton butt2 = temeLvlApp.getButtonList()[1][0];
		SelectLetterController slc2 = new SelectLetterController(temeLvlApp, lvlMod, 0, 1, 0);
		ActionEvent ae2 = new ActionEvent(butt2, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc2.actionPerformed(ae2);
		assertEquals(lvlMod.getBoard().getWord().toString(), "NC");
		//Button 3
		JButton butt3 = temeLvlApp.getButtonList()[2][0];
		SelectLetterController slc3 = new SelectLetterController(temeLvlApp, lvlMod, 0, 2, 0);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		assertEquals(lvlMod.getBoard().getWord().toString(), "NCR");
		//Remove selected INVALID word
		assertEquals(lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString(), "R");
		Move move = new Move (lvlMod.getBoard().getWord(), lvlMod);
		assertFalse(move.doMove());
		assertEquals(lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString(), "R");			
	}
	
	public void testClickTooFarAway() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
		//Button 1
		JButton butt1 = temeLvlApp.getButtonList()[0][0];
		SelectLetterController slc1 = new SelectLetterController(temeLvlApp, lvlMod, 0, 0, 0);
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt1"); //want butt.doClick or butt.doClick()
		slc1.actionPerformed(ae1);
		assertEquals(lvlMod.getBoard().getWord().toString(), "N");
		//Button 2
		JButton butt2 = temeLvlApp.getButtonList()[2][0];
		SelectLetterController slc2 = new SelectLetterController(temeLvlApp, lvlMod, 0, 2, 0);
		ActionEvent ae2 = new ActionEvent(butt2, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc2.actionPerformed(ae2);
		assertNotSame(lvlMod.getBoard().getWord().toString(), "NR");
				
	}
	
	public void testClickInEveryDirection() {
		//want to check .actionPerformed very thuroughly.
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN"); 
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		Application app = new Application(model);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
						
		//Button 1
		JButton butt1 = temeLvlApp.getButtonList()[0][0];
		SelectLetterController slc1 = new SelectLetterController(temeLvlApp, lvlMod, 0, 0, 0);
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt1"); //want butt.doClick or butt.doClick()
		slc1.actionPerformed(ae1);
		assertEquals(lvlMod.getBoard().getWord().toString(), "N");
		//Button 2
		JButton butt2 = temeLvlApp.getButtonList()[1][0];
		SelectLetterController slc2 = new SelectLetterController(temeLvlApp, lvlMod, 0, 1, 0);
		ActionEvent ae2 = new ActionEvent(butt2, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc2.actionPerformed(ae2);
		//Button 3
		JButton butt3 = temeLvlApp.getButtonList()[1][1];
		SelectLetterController slc3 = new SelectLetterController(temeLvlApp, lvlMod, 0, 1, 1);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		//Button 4
		JButton butt4 = temeLvlApp.getButtonList()[0][1];
		SelectLetterController slc4 = new SelectLetterController(temeLvlApp, lvlMod, 0, 0, 1);
		ActionEvent ae4 = new ActionEvent(butt4, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc4.actionPerformed(ae4);
		//Button 5
		JButton butt5 = temeLvlApp.getButtonList()[1][2];
		SelectLetterController slc5 = new SelectLetterController(temeLvlApp, lvlMod, 0, 1, 2);
		ActionEvent ae5 = new ActionEvent(butt5, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc5.actionPerformed(ae5);
		//Button 6
		JButton butt6 = temeLvlApp.getButtonList()[2][1];
		SelectLetterController slc6 = new SelectLetterController(temeLvlApp, lvlMod, 0, 2, 1);
		ActionEvent ae6 = new ActionEvent(butt6, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc6.actionPerformed(ae6);
		//Button 7
		JButton butt7 = temeLvlApp.getButtonList()[2][2];
		SelectLetterController slc7 = new SelectLetterController(temeLvlApp, lvlMod, 0, 2, 2);
		ActionEvent ae7 = new ActionEvent(butt7, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc7.actionPerformed(ae7);
		//Button 8
		JButton butt8 = temeLvlApp.getButtonList()[1][3];
		SelectLetterController slc8 = new SelectLetterController(temeLvlApp, lvlMod, 0, 1, 3);
		ActionEvent ae8 = new ActionEvent(butt8, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc8.actionPerformed(ae8);
		//Button 9
		JButton butt9 = temeLvlApp.getButtonList()[0][2];
		SelectLetterController slc9 = new SelectLetterController(temeLvlApp, lvlMod, 0, 0, 2);
		ActionEvent ae9 = new ActionEvent(butt9, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc9.actionPerformed(ae9);
		//Remove selected (incredibly likely) INVALID word
		assertEquals(lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString(), "R");
		Move move = new Move (lvlMod.getBoard().getWord(), lvlMod);
		assertFalse(move.doMove());
		assertEquals(lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString(), "R");			
	}
	
	public void testClickAroundEdgeOfBoard() {
		//TODO: Can't find tiles on these squares???
		//want to check .actionPerformed very thuroughly.
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(1); 
		LightningLevel ligtLvl = new LightningLevel(lvlMod.getBoard(), lvlMod.getGoals(), 120);
		Application app = new Application(model);
		Timer timer = new Timer(1000, null);
		LightningLevelApplication ligtLvlApp = new LightningLevelApplication(ligtLvl, timer);
						
		//Button 1
		JButton butt1 = ligtLvlApp.getButtonList()[0][0];
		SelectLetterController slc1 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 0);
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt1"); //want butt.doClick or butt.doClick()
		slc1.actionPerformed(ae1);
		//Button 2
		JButton butt2 = ligtLvlApp.getButtonList()[0][1];
		SelectLetterController slc2 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 1);
		ActionEvent ae2 = new ActionEvent(butt2, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc2.actionPerformed(ae2);
		//Button 3
		JButton butt3 = ligtLvlApp.getButtonList()[0][2];
		SelectLetterController slc3 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 2);
		ActionEvent ae3 = new ActionEvent(butt3, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc3.actionPerformed(ae3);
		//Button 4
		JButton butt4 = ligtLvlApp.getButtonList()[0][3];
		SelectLetterController slc4 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 3);
		ActionEvent ae4 = new ActionEvent(butt4, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc4.actionPerformed(ae4);
		//Button 5
		JButton butt5 = ligtLvlApp.getButtonList()[0][4];
		SelectLetterController slc5 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 4);
		ActionEvent ae5 = new ActionEvent(butt5, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc5.actionPerformed(ae5);
		//Button 6
		JButton butt6 = ligtLvlApp.getButtonList()[0][5];
		SelectLetterController slc6 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 5);
		ActionEvent ae6 = new ActionEvent(butt6, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc6.actionPerformed(ae6);
		//Button 7
		JButton butt7 = ligtLvlApp.getButtonList()[1][5];
		SelectLetterController slc7 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 1, 5);
		ActionEvent ae7 = new ActionEvent(butt7, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc7.actionPerformed(ae7);
		//Button 8
		JButton butt8 = ligtLvlApp.getButtonList()[2][5];
		SelectLetterController slc8 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 2, 5);
		ActionEvent ae8 = new ActionEvent(butt8, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slc8.actionPerformed(ae8);
		//Button 9
		JButton butt9 = ligtLvlApp.getButtonList()[3][5];
		SelectLetterController slc9 = new SelectLetterController(ligtLvlApp, lvlMod, 0, 3, 5);
		ActionEvent ae9 = new ActionEvent(butt9, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slc9.actionPerformed(ae9);
		//Button A
		JButton buttA = ligtLvlApp.getButtonList()[4][5];
		SelectLetterController slcA = new SelectLetterController(ligtLvlApp, lvlMod, 0, 4, 5);
		ActionEvent aeA = new ActionEvent(buttA, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slcA.actionPerformed(aeA);
		//Button B
		JButton buttB = ligtLvlApp.getButtonList()[5][5];
		SelectLetterController slcB = new SelectLetterController(ligtLvlApp, lvlMod, 0, 5, 5);
		ActionEvent aeB = new ActionEvent(buttB, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slcB.actionPerformed(aeB);
		//Button C
		JButton buttC = ligtLvlApp.getButtonList()[5][4];
		SelectLetterController slcC = new SelectLetterController(ligtLvlApp, lvlMod, 0, 5, 4);
		ActionEvent aeC = new ActionEvent(buttC, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slcC.actionPerformed(aeC);
		//Button D
		JButton buttD = ligtLvlApp.getButtonList()[5][3];
		SelectLetterController slcD = new SelectLetterController(ligtLvlApp, lvlMod, 0, 5, 3);
		ActionEvent aeD = new ActionEvent(buttD, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slcD.actionPerformed(aeD);
		//Button E
		JButton buttE = ligtLvlApp.getButtonList()[5][2];
		SelectLetterController slcE = new SelectLetterController(ligtLvlApp, lvlMod, 0, 5, 2);
		ActionEvent aeE = new ActionEvent(buttE, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slcE.actionPerformed(aeE);
		//Button F
		JButton buttF = ligtLvlApp.getButtonList()[5][1];
		SelectLetterController slcF = new SelectLetterController(ligtLvlApp, lvlMod, 0, 5, 1);
		ActionEvent aeF = new ActionEvent(buttF, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slcF.actionPerformed(aeF);
		//Button G
		JButton buttG = ligtLvlApp.getButtonList()[5][0];
		SelectLetterController slcG = new SelectLetterController(ligtLvlApp, lvlMod, 0, 5, 0);
		ActionEvent aeG = new ActionEvent(buttG, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slcG.actionPerformed(aeG);
		//Button H
		JButton buttH = ligtLvlApp.getButtonList()[4][0];
		SelectLetterController slcH = new SelectLetterController(ligtLvlApp, lvlMod, 0, 4, 0);
		ActionEvent aeH = new ActionEvent(buttH, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slcH.actionPerformed(aeH);
		//Button I
		JButton buttI = ligtLvlApp.getButtonList()[3][0];
		SelectLetterController slcI = new SelectLetterController(ligtLvlApp, lvlMod, 0, 3, 0);
		ActionEvent aeI = new ActionEvent(buttI, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slcI.actionPerformed(aeI);
		//Button J
		JButton buttJ = ligtLvlApp.getButtonList()[2][0];
		SelectLetterController slcJ = new SelectLetterController(ligtLvlApp, lvlMod, 0, 2, 0);
		ActionEvent aeJ = new ActionEvent(buttJ, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slcJ.actionPerformed(aeJ);
		//Button K
		JButton buttK = ligtLvlApp.getButtonList()[1][0];
		SelectLetterController slcK = new SelectLetterController(ligtLvlApp, lvlMod, 0, 1, 0);
		ActionEvent aeK = new ActionEvent(buttK, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt2"); //want butt.doClick or butt.doClick()
		slcK.actionPerformed(aeK);
		//Button L
		JButton buttL = ligtLvlApp.getButtonList()[0][0];
		SelectLetterController slcL = new SelectLetterController(ligtLvlApp, lvlMod, 0, 0, 0);
		ActionEvent aeL = new ActionEvent(buttL, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt3"); //want butt.doClick or butt.doClick()
		slcL.actionPerformed(aeL);
		////Remove selected (incredibly likely) INVALID word
		//String letter = lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString();
		//assertEquals(lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString(), letter);
		//Move move = new Move (lvlMod.getBoard().getWord(), lvlMod);
		//assertFalse(move.doMove());
		//assertEquals(lvlMod.getBoard().lookUpSquare(2, 0).getTile().toString(), letter);			
	}
}
