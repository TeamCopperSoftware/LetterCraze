package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.LevelModel;

/**
 * Controls all actions for Creating a New Level Button in LetterCraze Builder Main Menu.
 * <p>
 */
public class ViewCreateLevelController implements ActionListener {
	
	/** The main frame for LevelCraze. */
	Application app;
	/** Builder Model/Level information. */
	BuilderModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.getCreateNewLevelApplication().resetPanel();
		app.setContentPane(app.getCreateNewLevelApplication());
	}
	
	/** 
	 * Constructs ViewCreateLevelController.
	 * 
	 * Initial value is given.
	 * @param app			Main frame of LetterCraze
	 * @param m     		Model information for Builder
	 */
	public ViewCreateLevelController(Application app, BuilderModel m) {
		this.app = app;
		this.model = m;
	}

}
