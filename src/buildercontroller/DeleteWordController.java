package buildercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import entities.*;
import playerboundary.LevelApplication;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

import java.util.*;

/**
 * Controls all actions when deleting a word in the WordBox when creating new Level.
 * <p>
 */
public class DeleteWordController implements ActionListener {

	/** Builder Model/Level information. */
   public BuilderModel model;
	/** The main frame for LevelCraze. */
    public Application application;
	/** The level number. */    
    int levelNumber;


	/** 
	 * Constructs DeleteWordController.
	 * 
	 * Initial value is given.
	 * @param m    Model information for Builder
	 * @param app  Main frame of LetterCraze
	 * @param levelNumber Level Number
	 */
   public DeleteWordController(BuilderModel m, Application app, int levelNumber) {
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
			// if there is a word in the word box and the word is also in the list, remove it from list
			if (!wordField.getText().isEmpty() && listModel.contains(wordField.getText().toUpperCase())) {
				listModel.removeElement(wordField.getText().toUpperCase());
			}
			// if there is no word in the word box and there are elements in the list, remove last element from list
			else if (wordField.getText().isEmpty() && !listModel.isEmpty()) {
				listModel.removeElementAt(listModel.size()-1);
			}
		}
		else {
			wordField = application.getEditSavedLevelApplications().get(levelNumber).getWordField();
			listModel = application.getEditSavedLevelApplications().get(levelNumber).getDefaultListModel();
			// if there is a word in the word box and the word is also in the list, remove it from list
			if (!wordField.getText().isEmpty() && listModel.contains(wordField.getText().toUpperCase())) {
				listModel.removeElement(wordField.getText().toUpperCase());
			}
			// if there is no word in the word box and there are elements in the list, remove last element from list
			else if (wordField.getText().isEmpty() && !listModel.isEmpty()) {
				listModel.removeElementAt(listModel.size()-1);
			}
		}
		
	}

    

}