package playercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.LevelModel;
import entities.LightningLevel;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.LevelApplication;

public class ResetBoardController implements ActionListener {

	LevelApplication app;
	LevelModel m;
	
	public void actionPerformed(ActionEvent ae) {
		// reset board with new letters if it's not a theme level
		if (!m.getType().equals("Theme")) {
			m.getBoard().reset();
		} else {
			ThemeLevel themeLevel = (ThemeLevel)(m);
			m.getBoard().resetToBoard(themeLevel.getStartingBoard());
		}
		// clear list
		app.clearList();
		// clear score
		m.getCurrentScore().setScore(0);
		m.getCurrentScore().setStar(0);
		// clear objective (reset it)
		// if it is a puzzle
		if (m.getType().equals("Puzzle")) {
			PuzzleLevel thisLevel1 = (PuzzleLevel)(m);
			app.resetObjectiveValue(thisLevel1.getMoveLimit());
			app.refreshPanel(m);
		}
		// if it is lightning
		if (m.getType().equals("Lightning")) {
			LightningLevel thisLevel2 = (LightningLevel)(m);
			app.resetObjectiveValue(thisLevel2.getTimeLimit());
			app.refreshPanel(m);
		}
		// if it is theme
		if (m.getType().equals("Theme")) {
			ThemeLevel thisLevel3 = (ThemeLevel)(m);
			app.resetObjectiveValue(thisLevel3.getValidWords().size());
			app.refreshPanel(m);
			
		}
	}
	
	public ResetBoardController(LevelApplication app, LevelModel m) {
		this.app = app;
		this.m = m;
	}
}
