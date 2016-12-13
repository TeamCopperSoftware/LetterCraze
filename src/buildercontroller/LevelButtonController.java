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
 * 
 */
public class LevelButtonController implements ActionListener {


    /**
     * 
     */
    BuilderModel model;

    /**
     * 
     */
    Application application;
    
    /**
     * 
     */
    JButton button;

    /**
     * 
     */
    JComboBox box;
    
    int levelNumber;


    /**
     * @param MapModel m 
     * @param MapApplication app
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