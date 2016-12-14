package buildercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

import entities.*;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

import java.util.*;

/**
 * Controls all actions to do with mouse events over Level Buttons in Saved levels map.
 */
public class LevelButtonController implements ActionListener {


	/** Builder Model/Level information. */
   BuilderModel model;
	/** The main frame for LevelCraze. */
    Application application;
	/** The level button on the map. */    
    JButton button;
	/** The type selection option for each level. */    
    JComboBox box;
	/** The level number. */        
    int levelNumber;


	/** 
	 * Constructs Level button to navigate from map to saved levels.
	 * 
	 * Initial value is given.
	 * @param m    Model information for Builder
	 * @param app  Main frame of LetterCraze
	 * @param b  Button in map to access level
	 * @param c  Drop down box used to select type of level
	 * @param levelNumber Level Number
	 */
    public LevelButtonController(BuilderModel m, Application app, JButton b, JComboBox c, int levelNumber) {
        this.model = m;
        this.application = app;
        this.button = b;
        this.box = c;
        this.levelNumber = levelNumber;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if (button.getBackground().equals(Color.WHITE)) {
			button.setBackground(null);
			box.setVisible(false);
			button.setSize(60, 60);
		}
		else {
			button.setBackground(Color.WHITE);
			
			if (levelNumber == -1 && application.getCreateNewLevelApplication().getLevelType().equals("Theme")) {
				button.setSize(60, 30);
				box.setVisible(true);
			}
			else if (levelNumber != -1 && application.getEditSavedLevelApplications().get(levelNumber).getLevelType().equals("Theme")) {
				button.setSize(60, 30);
				box.setVisible(true);
			}
			else {
				button.setSize(60, 60);
			}
			
			
		}
	}

}