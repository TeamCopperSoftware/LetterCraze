package playermain;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.*;

import javax.swing.UIManager;

import playerboundary.Application;
import playercontroller.*;
import entities.*;

/**
 * LetterCraze Player PlugIn.
 * <p>
 * Instructions: Selecting Play game takes you to the adventure map menu where 
 * you can play 15 levels with 3 different variations types being Puzzle, Lightning, 
 * and Theme. Puzzle is based on high score, lightning is based on the amount of words
 * found in the given time, and theme is based on finding specific words based on a common
 * topic. 
 * <p>
 * Selecting words in a level are performed by clicking on letters in the tiles and following that
 * tile path till it forms a word. Each tile has to be clicked and must be next to each other either
 * across left, right, up, down, or diagonal of preceding tile. Words should also be no less than 3 
 * letters. Once you selected a valid word by highlighting the letter tiles in yellow in order, press
 * the add word button to sucessfully add a word if valid. Levels can be unlocked one by one by achieving 
 * at least one star in each level. Custom levels can also be played by going back to the Main Menu and 
 * selecting custom levels. Same level rules apply for custom levels.
 * <p>
 * @author: Annie Hernandez, Anthony Gringeri, James Kradjian, John Dyer, and Goutham Deva.
 */


public class Main {

	public Application app;
	public static Model model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.app.setVisible(true);
					// set feel to crossplatform (same for mac and pc)
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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

		// load up playersave
		try {
			FileInputStream save = new FileInputStream("playersave.ser");
			ObjectInputStream in = new ObjectInputStream(save);
			model = ((Model) in.readObject());
			in.close();
			save.close();
			System.out.println("playersave found. Loading file...");
		}catch(IOException i) {
			//i.printStackTrace();
			System.out.println("playersave file not found, starting new game");
		}catch(ClassNotFoundException c) {
			System.out.println("playersave not found");
			c.printStackTrace();
		}
		
		// load up customlevels
		try {
			FileInputStream fileIn = new FileInputStream("customlevels.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			model.importCustomLevels(((ArrayList<LevelModel>) in.readObject()));
			in.close();
			fileIn.close();
			System.out.println("customlevels found. Loading file...");
		}catch(IOException i) {
			//i.printStackTrace();
			System.out.println("customlevels file not found, starting new game");
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("customlevels not found");
			c.printStackTrace();
			return;
		}
	}


	/**
	 * Getter method for model.
	 */
	public Model getModel() {
		return model;
	}


	/**
	 * Initialize the boundary objects.
	 */
	private void initializeBoundary() {
		app = new Application(model);
	}


	/**
	 * Getter method for application.
	 */
	public Application getApp() {
		return app;
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeController() {
		// get from menu to map
		app.getMainMenu().getMapButton().addActionListener(new ViewAdventureMapController(app, model));
		// get from map to menu
		app.getMapApplication().getBackButton().addActionListener(new ViewMainMenuController(app, model));

		// get from menu to custom levels
		app.getMainMenu().getCustomLevelsButton().addActionListener(new ViewCustomLevelsController(app, model));
		// get from custom levels to menu
		app.getViewCustomLevelsApplication().getBackButton().addActionListener(new ViewMainMenuController(app, model));

		// get from Map to any unlocked level
		for (int i = 0; i < 15; i++) {
			app.getMapApplication().getLevelButtons().get(i).addActionListener(new ViewLevelController(app, model, i));
		}

		// exit from any main level to Map
		int numMainLevels = model.getMainLevels().getLevels().size();
		for (int i = 0; i < numMainLevels; i++) {
			app.getLevelApplications().get(i).getExitButton().addActionListener(new ViewAdventureMapController(app, model));
		}

		// get from Custom Level map to any unlocked level
		int numCustomLevels = model.getCustomLevels().size();
		for (int i = 0; i < numCustomLevels && i < 15; i++) {
			app.getViewCustomLevelsApplication().getLevelButtons().get(i).addActionListener(new ViewCustomLevelController(app, model, i));
		}

		// exit from any custom level to Custom Level Map
		for (int i = 0; i < numCustomLevels; i++) {
			app.getCustomLevelApplications().get(i).getExitButton().addActionListener(new ViewCustomLevelsController(app, model));
		}

		// set controllers for square buttons in main LevelApplications
		for (int i = 0; i < 15; i++) {
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 6; y++) {
					app.getLevelApplications().get(i).getButtonList()[x][y].addActionListener(new SelectLetterController(app.getLevelApplications().get(i), model.getMainLevels().getLevels().get(i), i, x, y));
				}
			}
		}


		// set controllers for square buttons in customLevelApplications
		for (int i = 0; i < numCustomLevels; i++) {
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 6; y++) {
					app.getCustomLevelApplications().get(i).getButtonList()[x][y].addActionListener(new SelectLetterController(app.getCustomLevelApplications().get(i), model.getCustomLevels().get(i), i, x, y));
				}
			}
		}

		// set controllers for add word buttons in LevelApplications
		for (int i = 0; i < 15; i++) {
			app.getLevelApplications().get(i).getConfirmButton().addActionListener(new AddWordController(app, app.getMapApplication(), app.getLevelApplications().get(i), model.getMainLevels().getLevels().get(i)));
		}

		// set controllers for add word buttons in custom LevelApplications
		for (int i = 0; i < numCustomLevels; i++) {
			app.getCustomLevelApplications().get(i).getConfirmButton().addActionListener(new AddWordController(app, app.getViewCustomLevelsApplication(), app.getCustomLevelApplications().get(i), model.getCustomLevels().get(i)));
		}

		// set controllers for reset buttons on main levels
		for (int i = 0; i < numMainLevels; i++) {
			app.getLevelApplications().get(i).getResetButton().addActionListener(new ResetBoardController(app.getLevelApplications().get(i), model.getMainLevels().getLevels().get(i)));
		}

		// set controllers for reset buttons on custom levels
		for (int i = 0; i < numCustomLevels; i++) {
			app.getCustomLevelApplications().get(i).getResetButton().addActionListener(new ResetBoardController(app.getCustomLevelApplications().get(i), model.getCustomLevels().get(i)));
		}

		// set controllers for undo buttons on main levels
		for (int i = 0; i < numMainLevels; i++) {
			app.getLevelApplications().get(i).getUndoButton().addActionListener(new UndoController(app, app.getLevelApplications().get(i), model.getMainLevels().getLevels().get(i)));
		}

		// set controllers for undo buttons on custom levels
		for (int i = 0; i < numCustomLevels; i++) {
			app.getCustomLevelApplications().get(i).getUndoButton().addActionListener(new UndoController(app, app.getCustomLevelApplications().get(i), model.getCustomLevels().get(i)));
		}
		
		// set controller for reset progress on main menu
		app.getMainMenu().getResetProgressButton().addActionListener(new ResetProgressController(app, model));
		
		// set controller for how to play button
		app.getMainMenu().getHowToPlayButton().addActionListener(new HowToPlayController(app, model));

	}

}