package buildercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;
import builderboundary.EditSavedLevelApplication;
import entities.Board;
import entities.BuilderModel;
import entities.Goal;
import entities.LightningLevel;
import entities.Position;
import entities.PuzzleLevel;
import entities.Square;
import entities.ThemeLevel;
import entities.Tile;
import playerboundary.LightningLevelApplication;
import playerboundary.PuzzleLevelApplication;
import playerboundary.ThemeLevelApplication;

public class PreviewController implements ActionListener {

	Application application;
	BuilderModel model;
	int levelNumber;
	
	public PreviewController(Application app, BuilderModel model, int levelNumber) {
		this.application = app;
		this.model = model;
		this.levelNumber = levelNumber;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (levelNumber == -1) {
			CreateNewLevelApplication level = application.getCreateNewLevelApplication();
			
			// create board
			Square[] squareArray = new Square[36];
			int i = 0;
			for (int y = 0; y < 6; y++) {
				for (int x = 0; x < 6; x++) {
					// if button is selected, square is enabled
					if (level.getSquareButtons()[x][y].getBackground().equals(Color.WHITE)) {
						squareArray[i] = new Square(new Position(x,y), true, new Tile((String)level.getLetterBoxes()[x][y].getSelectedItem()));
					}
					else {
						squareArray[i] = new Square(new Position(x, y), false, new Tile((String)level.getLetterBoxes()[x][y].getSelectedItem()));
					}
					i++;
				}
			}
			Board b = new Board(squareArray);
			Goal g = new Goal(level.getStarGoals()[0], level.getStarGoals()[1], level.getStarGoals()[2]);
			
			if (level.getLevelType().equals("Puzzle")) {
				int moveLimit = (int)level.getNumMovesSpinner().getValue();
				PuzzleLevel pl = new PuzzleLevel(b, g, moveLimit);
				pl.getBoard().reset();
				PuzzleLevelApplication pa = new PuzzleLevelApplication(pl);
				pa.refreshPanel(pl);
				pa.getExitButton().addActionListener(new ExitPreviewController(application, model, levelNumber));
				application.setContentPane(pa);
			}
			else if (level.getLevelType().equals("Lightning")) {
				int timeLimit = (int)level.getTimeSpinner().getValue();
				LightningLevel ll = new LightningLevel(b, g, timeLimit);
				ll.getBoard().reset();
				LightningLevelApplication la = new LightningLevelApplication(ll, new Timer(0, null));
				la.refreshPanel(ll);
				la.getExitButton().addActionListener(new ExitPreviewController(application, model, levelNumber));
				application.setContentPane(la);
			}
			else if (level.getLevelType().equals("Theme")) {
				String theme = level.getThemeField().getText();
				ArrayList<String> words = new ArrayList<String>();
				for (int j = 0; j < level.getWordList().getModel().getSize(); j++) {
					words.add((String)level.getWordList().getModel().getElementAt(j));
				}
				ThemeLevel tl = new ThemeLevel(b, g, theme, words);
				ThemeLevelApplication ta = new ThemeLevelApplication(tl);
				ta.refreshPanel(tl);
				ta.refreshObjective(tl);
				ta.getExitButton().addActionListener(new ExitPreviewController(application, model, levelNumber));
				application.setContentPane(ta);
			}
		}
		else {
			EditSavedLevelApplication level = application.getEditSavedLevelApplications().get(levelNumber);

			// create board
			Square[] squareArray = new Square[36];
			int i = 0;
			for (int y = 0; y < 6; y++) {
				for (int x = 0; x < 6; x++) {
					// if button is selected, square is enabled
					if (level.getSquareButtons()[x][y].getBackground().equals(Color.WHITE)) {
						squareArray[i] = new Square(new Position(x,y), true, new Tile((String)level.getLetterBoxes()[x][y].getSelectedItem()));
					}
					else {
						squareArray[i] = new Square(new Position(x, y), false, new Tile((String)level.getLetterBoxes()[x][y].getSelectedItem()));
					}
					i++;
				}
			}
			Board b = new Board(squareArray);
			Goal g = new Goal(level.getStarGoals()[0], level.getStarGoals()[1], level.getStarGoals()[2]);
			
			if (level.getLevelType().equals("Puzzle")) {
				int moveLimit = (int)level.getNumMovesSpinner().getValue();
				PuzzleLevel pl = new PuzzleLevel(b, g, moveLimit);
				pl.getBoard().reset();
				PuzzleLevelApplication pa = new PuzzleLevelApplication(pl);
				pa.refreshPanel(pl);
				pa.getExitButton().addActionListener(new ExitPreviewController(application, model, levelNumber));
				application.setContentPane(pa);
			}
			else if (level.getLevelType().equals("Lightning")) {
				int timeLimit = (int)level.getTimeSpinner().getValue();
				LightningLevel ll = new LightningLevel(b, g, timeLimit);
				ll.getBoard().reset();
				LightningLevelApplication la = new LightningLevelApplication(ll, new Timer(0, null));
				la.refreshPanel(ll);
				la.getExitButton().addActionListener(new ExitPreviewController(application, model, levelNumber));
				application.setContentPane(la);
			}
			else if (level.getLevelType().equals("Theme")) {
				String theme = level.getThemeField().getText();
				ArrayList<String> words = new ArrayList<String>();
				for (int j = 0; j < level.getWordList().getModel().getSize(); j++) {
					words.add((String)level.getWordList().getModel().getElementAt(j));
				}
				ThemeLevel tl = new ThemeLevel(b, g, theme, words);
				ThemeLevelApplication ta = new ThemeLevelApplication(tl);
				ta.refreshPanel(tl);
				ta.refreshObjective(tl);
				ta.getExitButton().addActionListener(new ExitPreviewController(application, model, levelNumber));
				application.setContentPane(ta);
			}
		}
		
		
	}

}
