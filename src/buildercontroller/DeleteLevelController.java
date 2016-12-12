package buildercontroller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;

import builderboundary.Application;
import entities.BuilderModel;

/**
 * 
 */
public class DeleteLevelController implements ActionListener {


    /**
     * 
     */
    public BuilderModel model;

    /**
     * 
     */
    public Application application;
    
    int number;



    /**
     * @param EditSavedLevelsModel m 
     * @param EditSavedLevelsApplication app
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