package playercontroller;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.Application;
import playerboundary.LightningLevelApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomLevelController implements ActionListener {
	
	Application app;
	Model model;
	int levelNumber;

	@Override
	public void actionPerformed(ActionEvent e) {
		LevelModel level = model.getCustomLevels().get(levelNumber);
		if (level.getIsUnlocked()) {
			if (level.getType().equals("Puzzle")) {
				level.initializeLevel();
				app.getCustomLevelApplications().get(levelNumber).refreshPanel((PuzzleLevel)level);
				app.setContentPane(app.getCustomLevelApplications().get(levelNumber));
			}
			else if (level.getType().equals("Lightning")) {
				LightningLevelApplication l = (LightningLevelApplication)app.getLevelApplications().get(levelNumber);
				l.refreshPanel((LightningLevel)level);
				l.initializeTimeLeft();
				l.getTimer().start();
				app.setContentPane(l);
			}
			else {
				app.getCustomLevelApplications().get(levelNumber).refreshPanel((ThemeLevel)level);
				app.setContentPane(app.getCustomLevelApplications().get(levelNumber));
			}
		}
	}
	
	public ViewCustomLevelController(Application app, Model m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}