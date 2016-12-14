package buildercontroller;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import entities.BuilderModel;
import entities.LevelModel;
import entities.Model;
import entities.PuzzleLevel;
import junit.framework.TestCase;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;
import builderboundary.EditSavedLevelApplication;

public class TestSaveEditedController extends TestCase {
	
	public void testPuzzle() {
		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		ArrayList<LevelModel> lvlList = model.getSavedLevels();
		
		lvlList.add(null);
		lvlList.add(null);
		EditSavedLevelApplication level = new EditSavedLevelApplication(model, 1);
		
		JButton butt0 = level.getSquareButtons()[2][2];
		JComboBox box0 = level.getLetterBoxes()[2][2];
		LevelButtonController lbc = new LevelButtonController(model, app, butt0, box0, 1);
		ActionEvent ae0 = new ActionEvent(butt0, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt");
		lbc.actionPerformed(ae0);
		
		SaveEditedController sec = new SaveEditedController(model, app, level, 1);
		JButton butt1 = level.getBackButton();
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		sec.actionPerformed(ae1);
		level.resetPanel();
		
	}
	
	public void testLightning() {
		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		ArrayList<LevelModel> lvlList = model.getSavedLevels();
		
		lvlList.add(null);
		lvlList.add(null);
		EditSavedLevelApplication level = new EditSavedLevelApplication(model, 1);
		
		JButton butt0 = level.getSquareButtons()[2][2];
		JComboBox box0 = level.getLetterBoxes()[2][2];
		LevelButtonController lbc = new LevelButtonController(model, app, butt0, box0, 1);
		ActionEvent ae0 = new ActionEvent(butt0, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt");
		lbc.actionPerformed(ae0);
		
		JComboBox box5 = level.getGameModeComboBox();
		GameModeSelectionController gmsc = new GameModeSelectionController(model, app, 1);
		ItemEvent ae5 = new ItemEvent(box5, (int) ItemEvent.MOUSE_EVENT_MASK, "Lightning", ItemEvent.SELECTED);
		gmsc.itemStateChanged(ae5);
		ItemEvent ae6 = new ItemEvent(box5, (int) ItemEvent.MOUSE_EVENT_MASK, "Theme", ItemEvent.SELECTED);
		gmsc.itemStateChanged(ae6);
		
		SaveEditedController sec = new SaveEditedController(model, app, level, 1);
		JButton butt1 = level.getBackButton();
		ActionEvent ae1 = new ActionEvent(butt1, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		sec.actionPerformed(ae1);
		level.resetPanel();
		
	}

}
