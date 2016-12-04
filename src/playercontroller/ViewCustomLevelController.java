package playercontroller;

import entities.LevelModel;
import entities.Model;
import playerboundary.Application;
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
				app.getCustomPuzzleLevelApplication().refreshPanel(levelNumber);
				app.setContentPane(app.getCustomPuzzleLevelApplication());
			}
			else if (level.getType().equals("Lightning")) {
				app.getCustomLightningLevelApplication().refreshPanel(levelNumber);
				app.setContentPane(app.getCustomLightningLevelApplication());
			}
			else {
				app.getCustomThemeLevelApplication().refreshPanel(levelNumber);
				app.setContentPane(app.getCustomThemeLevelApplication());
			}
		}
	}
	
	public ViewCustomLevelController(Application app, Model m, int levelNumber) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
	}

}