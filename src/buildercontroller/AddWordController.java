package buildercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import entities.*;
import playerboundary.LevelApplication;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

import java.util.*;

import builderboundary.CreateNewLevelApplication;

/**
 * Controls all actions when adding words to theme levels.
 * <p>
 */

public class AddWordController implements ActionListener {

	/** Builder Model/Level information. */
    public BuilderModel model;
	/** The main frame for LevelCraze. */
    public Application application;
	/** The level number. */
        int levelNumber;


	/** 
	 * Constructs Add Word Button Functionality.
	 * 
	 * Initial value is given.
	 * @param m    Model information for Builder
	 * @param app  Main frame of LetterCraze
	 * @param levelNumber Level Number
	 */
    
    public AddWordController(BuilderModel m, Application app, int levelNumber) {
        this.model = m;
        this.application = app;
        this.levelNumber = levelNumber;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	    JTextField wordField;
	    DefaultListModel listModel;
		if (levelNumber == -1) {
			wordField = application.getCreateNewLevelApplication().getWordField();
			listModel = application.getCreateNewLevelApplication().getDefaultListModel();
			if (wordField.getText().length() >= 3 && !listModel.contains(wordField.getText().toUpperCase())) {
				listModel.addElement(wordField.getText().toUpperCase());
				wordField.setText("");
			}
		}
		else {
			wordField = application.getEditSavedLevelApplications().get(levelNumber).getWordField();
			listModel = application.getEditSavedLevelApplications().get(levelNumber).getDefaultListModel();
			if (wordField.getText().length() >= 3 && !listModel.contains(wordField.getText().toUpperCase())) {
				listModel.addElement(wordField.getText().toUpperCase());
				wordField.setText("");
			}
		}
		
	}

}