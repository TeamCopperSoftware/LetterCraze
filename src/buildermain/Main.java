package buildermain;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;

import builderboundary.Application;
import buildercontroller.*;
import entities.BuilderModel;
import entities.Model;


public class Main {
	
	private Application app;
	private BuilderModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeModel();
		initializeBoundary();
		initializeController();
	}

	/**
	 * Initialize the entity objects.
	 */
	private void initializeModel() {
		model = new BuilderModel();
	}

	/**
	 * Initialize the boundary objects.
	 */
	private void initializeBoundary() {
		app = new Application(model);
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeController() {
		// get to create new level screen from main menu
		app.getInitializeBuilderApplication().getCreateLevelButton().addActionListener(new ViewCreateLevelController(app, model));
		// get back to menu from create new level screen
		app.getCreateNewLevelApplication().getBackButton().addActionListener(new ViewMainMenuController(app, model));
		
		// get to edit saved levels map from main menu
		app.getInitializeBuilderApplication().getEditSavedLevelsButton().addActionListener(new ViewSavedLevelsMapController(app, model));
		// get back to menu from edit saved levels screen
		app.getSavedLevelsMapApplication().getBackButton().addActionListener(new ViewMainMenuController(app, model));
		
		// get to the edit level screen from the edit saved levels screen
		for (int i = 0; i < 15; i++) {
			app.getSavedLevelsMapApplication().getLevelButtons().get(i).addActionListener(new ViewEditSavedLevelController(app, model, i));
		}
		
		// delete saved levels
		for (int i = 0; i < 15; i++) {
			app.getSavedLevelsMapApplication().getDeleteButtons().get(i).addActionListener(new DeleteLevelController(model, app, i));
		}
		
		// save a level
		app.getCreateNewLevelApplication().getSaveButton().addActionListener(new SaveController(model, app, app.getCreateNewLevelApplication(), -1));
		
		
		// get back to the map from the edit level screen
		for (int i = 0; i < 15; i++) {
			app.getEditSavedLevelApplications().get(i).getBackButton().addActionListener(new ViewSavedLevelsMapController(app, model));
		}
		
		// save existing levels
		for (int i = 0; i < 15; i++) {
			app.getEditSavedLevelApplications().get(i).getSaveButton().addActionListener(new SaveEditedController(model, app, app.getEditSavedLevelApplications().get(i), i));
		}
		
		// add words to wordlist for theme levels
		for (int i = 0; i < 15; i++) {
			app.getEditSavedLevelApplications().get(i).getAddWordButton().addActionListener(new AddWordController(model, app, i));
		}
		app.getCreateNewLevelApplication().getAddWordButton().addActionListener(new AddWordController(model, app, -1));
		
		// remove words from wordlist for theme levels
		for (int i = 0; i < 15; i++) {
			app.getEditSavedLevelApplications().get(i).getDeleteWordButton().addActionListener(new DeleteWordController(model, app, i));
		}
		app.getCreateNewLevelApplication().getDeleteWordButton().addActionListener(new DeleteWordController(model, app, -1));
		
		
		// set controllers for square buttons in CreateNewLevelApplication
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				JButton b = app.getCreateNewLevelApplication().getSquareButtons()[x][y];
				JComboBox c = app.getCreateNewLevelApplication().getLetterBoxes()[x][y];
				b.addActionListener(new LevelButtonController(model, app, b, c));
			}
		}
		
		// set controllers for square buttons in EditSavedLevelApplications
		for (int i = 0; i < 15; i++) {
			for (int y = 0; y < 6; y++) {
				for (int x = 0; x < 6; x++) {
					JButton b = app.getEditSavedLevelApplications().get(i).getSquareButtons()[x][y];
					JComboBox c = app.getEditSavedLevelApplications().get(i).getLetterBoxes()[x][y];
					b.addActionListener(new LevelButtonController(model, app, b, c));
				}
			}
		}
		
		
	}

}