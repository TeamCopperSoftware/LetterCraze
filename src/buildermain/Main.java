package buildermain;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;

import builderboundary.Application;
import buildercontroller.*;
import entities.Model;


public class Main {
	
	private Application app;
	private Model model;

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
		model = new Model();
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
		app.getSavedLevelsMapApplication().getLevel1Button().addActionListener(new ViewEditSavedLevelController(app, model));
		// get back to the map from the edit level screen
		app.getEditSavedLevelApplication().getBackButton().addActionListener(new ViewSavedLevelsMapController(app, model));
		
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				JButton b = app.getCreateNewLevelApplication().getSquareButtons()[x][y];
				JComboBox c = app.getCreateNewLevelApplication().getLetterBoxes()[x][y];
				b.addActionListener(new LevelButtonController(model, app, b, c));
			}
		}
		
	}

}