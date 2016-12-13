package buildercontroller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import entities.*;
import playerboundary.LevelApplication;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

import java.util.*;

/**
 * Controls all actions to do with mouse events over the Game Mode Selection Drop box when editing a level.
 * <p>
 */
public class GameModeSelectionController implements ItemListener {

	/** Builder Model/Level information. */
   public BuilderModel model;
	/** The main frame for LevelCraze. */
    public Application application;
	/** The level number. */    
    int levelNumber;



	/** 
	 * Constructs Drop Box Functionality for selecting game mode.
	 * 
	 * Initial value is given.
	 * @param m    Model information for Builder
	 * @param app  Main frame of LetterCraze
	 * @param levelNumber Level Number
	 */
    public GameModeSelectionController(BuilderModel m, Application app, int levelNumber) {
        this.model = m;
        this.application = app;
        this.levelNumber = levelNumber;
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl;
		String levelType;
		if (levelNumber == -1) {
			cl = (CardLayout)(application.getCreateNewLevelApplication().getCards().getLayout());
			cl.show(application.getCreateNewLevelApplication().getCards(), (String)e.getItem());
			levelType = (String)e.getItem();
	        application.getCreateNewLevelApplication().setLevelType(levelType);
	        if (levelType.equals("Puzzle") || levelType.equals("Lightning")) {
				for (int y = 0; y < 6; y++) {
					for (int x = 0; x < 6; x++) {
						application.getCreateNewLevelApplication().getSquareButtons()[x][y].setBounds(60*x, 60*y, 60, 60);
						application.getCreateNewLevelApplication().getLetterBoxes()[x][y].setVisible(false);
					}
				}
			}
			else {
				for (int y = 0; y < 6; y++) {
					for (int x = 0; x < 6; x++) {
						application.getCreateNewLevelApplication().getSquareButtons()[x][y].setBounds(60*x, 60*y, 60, 60);
						if (application.getCreateNewLevelApplication().getSquareButtons()[x][y].getBackground().equals(Color.WHITE)) {
							application.getCreateNewLevelApplication().getSquareButtons()[x][y].setBounds(60*x, 60*y, 60, 30);
							application.getCreateNewLevelApplication().getLetterBoxes()[x][y].setVisible(true);
						}
					}
				}
			}
		}
		else {
			cl = (CardLayout)(application.getEditSavedLevelApplications().get(levelNumber).getCards().getLayout());
			cl.show(application.getEditSavedLevelApplications().get(levelNumber).getCards(), (String)e.getItem());
			levelType = (String)e.getItem();
	        application.getEditSavedLevelApplications().get(levelNumber).setLevelType(levelType);
	        if (levelType.equals("Puzzle") || levelType.equals("Lightning")) {
				for (int y = 0; y < 6; y++) {
					for (int x = 0; x < 6; x++) {
						application.getEditSavedLevelApplications().get(levelNumber).getSquareButtons()[x][y].setBounds(60*x, 60*y, 60, 60);
						application.getEditSavedLevelApplications().get(levelNumber).getLetterBoxes()[x][y].setVisible(false);
					}
				}
			}
			else {
				for (int y = 0; y < 6; y++) {
					for (int x = 0; x < 6; x++) {
						application.getEditSavedLevelApplications().get(levelNumber).getSquareButtons()[x][y].setBounds(60*x, 60*y, 60, 60);
						if (application.getEditSavedLevelApplications().get(levelNumber).getSquareButtons()[x][y].getBackground().equals(Color.WHITE)) {
							application.getEditSavedLevelApplications().get(levelNumber).getSquareButtons()[x][y].setBounds(60*x, 60*y, 60, 30);
							application.getEditSavedLevelApplications().get(levelNumber).getLetterBoxes()[x][y].setVisible(true);
						}
					}
				}
			}
		}
		
		
	}

}