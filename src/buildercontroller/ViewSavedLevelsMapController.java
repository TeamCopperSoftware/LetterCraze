package buildercontroller;

import entities.BuilderModel;
import entities.Model;
import builderboundary.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls all actions for viewing edit saving levels map in LetterCraze Builder.
 * <p>
 */
public class ViewSavedLevelsMapController implements ActionListener {
	
    /** The main frame for LevelCraze. */
	Application app;
	/** Builder Model/Level information. */
	BuilderModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		app.getSavedLevelsMapApplication().refreshPanel();
		app.setContentPane(app.getSavedLevelsMapApplication());
	}
	
	/** 
	 * Constructs ViewSavedLevelsMapController.
	 * 
	 * Initial value is given.
	 * @param app			Main frame of LetterCraze
	 * @param m     		Model information for Builder
	 */
	public ViewSavedLevelsMapController(Application app, BuilderModel m) {
		this.app = app;
		this.model = m;
	}

}