package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions for viewing Main Menu in LetterCraze Builder.
 * <p>
 */
public class ViewMainMenuController implements ActionListener {
	
    /** The main frame for LevelCraze. */
	Application app;
	/** Builder Model/Level information. */
	BuilderModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.setContentPane(app.getInitializeBuilderApplication());
	}
	
	/** 
	 * Constructs ViewMainMenuController.
	 * 
	 * Initial value is given.
	 * @param app			Main frame of LetterCraze
	 * @param m     		Model information for Builder
	 */
	public ViewMainMenuController(Application app, BuilderModel m) {
		this.app = app;
		this.model = m;
	}

}