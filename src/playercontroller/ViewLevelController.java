package playercontroller;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;
import playerboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewLevelController implements ActionListener {
	
	Application app;
	Model model;
	int levelNumber;

	@Override
	public void actionPerformed(ActionEvent e) {
		LevelModel level = model.getMainLevels().getLevels().get(levelNumber);
		if (level.getIsUnlocked()) {
			level.initializeLevel();
			if (level.getType().equals("Puzzle")) {
				app.getLevelApplications().get(levelNumber).refreshPanel((PuzzleLevel)level);
				app.setContentPane(app.getLevelApplications().get(levelNumber));
			}
			else if (level.getType().equals("Lightning")) {
				app.getLevelApplications().get(levelNumber).refreshPanel((LightningLevel)level);
				app.setContentPane(app.getLevelApplications().get(levelNumber));
			}
			else {
				app.getLevelApplications().get(levelNumber).refreshPanel((ThemeLevel)level);
				app.setContentPane(app.getLevelApplications().get(levelNumber));
			}
		}
	}
	
	public ViewLevelController(Application app, Model m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}