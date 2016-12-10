package playercontroller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.LevelApplication;
import playerboundary.LightningLevelApplication;
import playerboundary.PuzzleLevelApplication;
import playerboundary.ThemeLevelApplication;

public class TestResetBoardController extends TestCase {

	public void testOnPuzzle() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(0);
		Application app = new Application(model);
		PuzzleLevel puzzLvl = new PuzzleLevel(lvlMod.getBoard(), lvlMod.getGoals(), 1);
		PuzzleLevelApplication puzzLvlApp = new PuzzleLevelApplication(puzzLvl);
		
		ResetBoardController rbc = new ResetBoardController(puzzLvlApp, lvlMod);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		rbc.actionPerformed(ae);
		
	}
	
	public void testOnLightning() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(1);
		Application app = new Application(model);
		LightningLevel ligtLvl = new LightningLevel(lvlMod.getBoard(), lvlMod.getGoals(), 120);
		LightningLevelApplication ligtLvlApp = (LightningLevelApplication) app.getLevelApplications().get(1);
		
		ResetBoardController rbc = new ResetBoardController(ligtLvlApp, lvlMod);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		rbc.actionPerformed(ae);
		
	}
	
	public void testOnTheme() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		Application app = new Application(model);
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("BEAN");
		ThemeLevel temeLvl = new ThemeLevel(lvlMod.getBoard(), lvlMod.getGoals(), "Vegetables", wordList);
		ThemeLevelApplication temeLvlApp = new ThemeLevelApplication(temeLvl);
		
		ResetBoardController rbc = new ResetBoardController(temeLvlApp, lvlMod);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		rbc.actionPerformed(ae);
		
	}
	
}
