package playermain;

import java.awt.EventQueue;
import playerboundary.Application;
import playercontroller.*;
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
		// get from menu to map
		app.getMainMenu().getMapButton().addActionListener(new ViewAdventureMapController(app, model));
		// get from map to menu
		app.getMapApplication().getBackButton().addActionListener(new ViewMainMenuController(app, model));
		
		// get from menu to custom levels
		app.getMainMenu().getCustomLevelsButton().addActionListener(new ViewCustomLevelsController(app, model));
		// get from custom levels to menu
		app.getViewCustomLevelsApplication().getBackButton().addActionListener(new ViewMainMenuController(app, model));
		
		// get from the first level button to the first (nonfunctional) puzzle level
		//app.getMapApplication().getLevel1Button().addActionListener(new ViewLevel1Controller(app, model));
		app.getMapApplication().getLevelButtons().get(0).addActionListener(new ViewLevel1Controller(app, model));
		
		// exit from level1
		app.getPuzzleLevelApplication().getExitButton().addActionListener(new ViewAdventureMapController(app, model));
		
		// get from the first custom level button to the first (nonfunctional) custom puzzle level
		app.getViewCustomLevelsApplication().getCustomLevel1Button().addActionListener(new ViewLevel1Controller(app, model));
	}

}