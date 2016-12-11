package playercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.LevelModel;
import entities.LightningLevel;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.LevelApplication;

/**
 * Controls all actions to do with Reseting Board in all levels.
 * <p>
 */

public class ResetBoardController implements ActionListener {

	LevelApplication app;
	LevelModel m;

	/**
	 * Provides all actions that reset board in level. Resets board with random letters
	 * and random words based on level type. Also resets score and list of words found.
	 * <p>
	 * @param ae ActionEvent
	 */

	public void actionPerformed(ActionEvent ae) {

		// Reset current score to 0 and best score to what it was when level opened
		m.getCurrentScore().setScore(0);
		m.getCurrentScore().setStar(0);
		m.getBestScore().setScore(m.getStartingBestScore().getScore());
		m.getBestScore().setStar(m.getStartingBestScore().getStar());

		// reset board with new letters if it's not a theme level
		if (!m.getType().equals("Theme")) {
			m.getBoard().reset();
		} else {
			ThemeLevel themeLevel = (ThemeLevel)(m);
			m.getBoard().resetToBoard(themeLevel.getStartingBoard());
		}
		// clear list
		app.clearList();
		m.getWordList().clear();
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
			app.refreshPanel(m);
		}
		// if it is theme
		if (m.getType().equals("Theme")) {
			ThemeLevel thisLevel3 = (ThemeLevel)(m);
			app.resetObjectiveValue(thisLevel3.getValidWords().size());
			app.refreshPanel(m);

		}
	}

	/**
	 * Sets parameters for ResetBoardController.
	 * <p>
	 * @param app LevelApplication, m LevelModel
	 */

	public ResetBoardController(LevelApplication app, LevelModel m) {
		this.app = app;
		this.m = m;
	}
}
