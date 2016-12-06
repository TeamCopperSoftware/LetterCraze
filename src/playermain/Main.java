package playermain;

import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.UIManager;

import playerboundary.Application;
import playercontroller.*;
import entities.Model;
import entities.Position;
import entities.Square;


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
		
		// set controllers for add word buttons in LevelApplications
		for (int i = 0; i < 15; i++) {
			app.getLevelApplications().get(i).getConfirmButton().addActionListener(new AddWordController(app.getLevelApplications().get(i), model.getMainLevels().getLevels().get(i)));
		}

		// set controllers for square buttons in customLevelApplications
		for (int i = 0; i < numCustomLevels; i++) {
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 6; y++) {
					app.getCustomLevelApplications().get(i).getButtonList()[x][y].addActionListener(new SelectLetterController(app.getCustomLevelApplications().get(i), model.getCustomLevels().get(i), i, x, y));
				}
			}
		}
		
	}

}