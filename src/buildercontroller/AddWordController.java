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
 * 
 */
public class AddWordController implements ActionListener {

    /**
     * 
     */
    public BuilderModel model;

    /**
     * 
     */
    public Application application;
    
    int levelNumber;


    /**
     * @param LevelModel m 
     * @param CreateNewLevelApplication app
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
			if (!wordField.getText().isEmpty() && !listModel.contains(wordField.getText())) {
				listModel.addElement(wordField.getText());
			}
		}
		else {
			wordField = application.getEditSavedLevelApplications().get(levelNumber).getWordField();
			listModel = application.getEditSavedLevelApplications().get(levelNumber).getDefaultListModel();
			if (!wordField.getText().isEmpty() && !listModel.contains(wordField.getText())) {
				listModel.addElement(wordField.getText());
			}
		}
		
	}

}