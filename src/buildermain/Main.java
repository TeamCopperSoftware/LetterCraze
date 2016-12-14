package buildermain;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import builderboundary.Application;
import buildercontroller.*;
import entities.BuilderModel;
import entities.LevelModel;
import entities.Model;

/**
 * LetterCraze Builder PlugIn.
 * <p>
 * Instructions: LetterCraze Builder allows you to customize your own LetterCraze 
 * levels and import them to LetterCraze player.
 * <p>
 * To create a new level, click on "Create New Level" on the main menu. From here you
 *  can select/deselect the tiles placement on the level board, select the type of 
 *  level, set star goals, and set goals based on the level type you choose. To select 
 *  star goals, enter the number based on the type of level you desire to make. Puzzle 
 *  is number of moves, Lightning is time, and Theme is words completed. To select a level 
 *  type, click on the drop down box on the top right and select the level you wish to make. 
 *  For puzzle, you must select the number of moves a player can make. For lightning, you 
 *  must select the amount of time the player has to complete the level. For theme, you must 
 *  add a theme description, a list of words (at least more than or equal to three letters) 
 *  that match the theme description and must manually add them for each tile placement. 
 *  Once you have entered all of your information, click the "Save Level" below the tiles 
 *  to save your level.
 * <p>
 * To edit a saved level, head back to the main menu and click on "Edit Saved Level". From here 
 * you can navigate through a map of all the levels you saved based on when you saved them. Order 
 * of levels saved goes left to right from oldest to newest level saved. Click on the level you wish 
 * to edit and continue to work on the level from there. If you wish to delete a level, click on the 
 * icon located on the top left of each level button. To publish your saved levels to LetterCraze player, 
 * click the "Publish Levels to LetterCraze" button on the top right corner of the screen. Doing this will 
 * published all of your levels that were saved to LetterCraze Player under Custom Levels for you and your 
 * friends to play. Enjoy!
 * <p>
 * @author: Annie Hernandez, Anthony Gringeri, James Kradjian, John Dyer, and Goutham Deva.
 */


public class Main {
	
	private Application app;
	private static BuilderModel model;

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

		// load up playersave
		try {
			FileInputStream fileIn = new FileInputStream("buildersave.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<LevelModel> levels = (ArrayList<LevelModel>) (in.readObject());
			model.setSavedLevels(levels);
			in.close();
			fileIn.close();
			System.out.println("Builder ArrayList<LevelModel> found. Loading file...");
		}catch(IOException i) {
			//i.printStackTrace();
			System.out.println("Builder ArrayList<LevelModel> file not found, starting new game");
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Builder ArrayList<LevelModel> not found");
			c.printStackTrace();
			return;
		}
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
				b.addActionListener(new LevelButtonController(model, app, b, c, -1));
			}
		}
		
		// set controllers for square buttons in EditSavedLevelApplications
		for (int i = 0; i < 15; i++) {
			for (int y = 0; y < 6; y++) {
				for (int x = 0; x < 6; x++) {
					JButton b = app.getEditSavedLevelApplications().get(i).getSquareButtons()[x][y];
					JComboBox c = app.getEditSavedLevelApplications().get(i).getLetterBoxes()[x][y];
					b.addActionListener(new LevelButtonController(model, app, b, c, i));
				}
			}
		}
		
		// set controller for choosing level type
		for (int i = 0; i < 15; i++) {
			app.getEditSavedLevelApplications().get(i).getGameModeComboBox().addItemListener(new GameModeSelectionController(model, app, i));
		}
		app.getCreateNewLevelApplication().getGameModeComboBox().addItemListener(new GameModeSelectionController(model, app, -1));
		
		// set publish levels controller
		app.getSavedLevelsMapApplication().getPublishButton().addActionListener(new PublishLevelsController(model, app));
		
		// set how to play controller
		app.getInitializeBuilderApplication().getHowToPlayButton().addActionListener(new HowToPlayController(model, app));
	}

}