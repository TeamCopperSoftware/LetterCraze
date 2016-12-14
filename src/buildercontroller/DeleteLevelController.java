package buildercontroller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;

import builderboundary.Application;
import entities.BuilderModel;

/**
 * Controls all actions when deleting levels in the saved levels map frame.
 */
public class DeleteLevelController implements ActionListener {

	/** Builder Model/Level information. */
	public BuilderModel model;
	/** The main frame for LevelCraze. */
    public Application application;
	/** The level number. */        
    int number;



	/** 
	 * Constructs DeleteLevelController.
	 * 
	 * Initial value is given.
	 * @param model    Model information for Builder
	 * @param app  Main frame of LetterCraze
	 * @param number Level Number
	 */ 
    public DeleteLevelController(BuilderModel model, Application app, int number) {
        this.model = model;
        this.application = app;
        this.number = number;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		model.getSavedLevels().remove(number);
		application.getSavedLevelsMapApplication().refreshPanel();
	}

}