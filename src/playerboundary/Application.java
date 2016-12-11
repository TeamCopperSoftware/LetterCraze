package playerboundary;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import entities.*;
import entities.Model;
import playerboundary.SplashScreenApplication;
import playercontroller.LightningTimerController;
import playercontroller.SplashScreenTimerController;

/**
 * The containing Frame for LetterCraze Player. Big GUI Shell
 */

public class Application extends JFrame {

	Model model;

	// All the other views should be stored as properties here
	SplashScreenApplication splashScreen;
	InitializeGameApplication mainMenu;
	MapApplication mapMenu;
	ViewCustomLevelsApplication customMenu;


	ArrayList<LevelApplication> levelApplications;
	ArrayList<LevelApplication> customLevelApplications;

	// how many seconds to display splash screen
	int displayTime;
	// Timer for determining how long splash screen should be displayed
	Timer splashScreenTimer;
	Timer lightningLevelTimer;


	/**
	 * Default constructor for LetterCraze Player Application
	 */
	
	public Application(Model model) {
		//pack(); not really sure what pack does
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("LetterCraze Player");

		this.model = model;

		// initialize views
		splashScreen = new SplashScreenApplication(model);
		mainMenu = new InitializeGameApplication(model);
		mapMenu = new MapApplication(model);
		customMenu = new ViewCustomLevelsApplication(model);
		levelApplications = new ArrayList<LevelApplication>();
		customLevelApplications = new ArrayList<LevelApplication>();


		int numMainLevels = model.getMainLevels().getLevels().size();
		for (int i = 0; i < numMainLevels; i++) {
			LevelModel l = model.getMainLevels().getLevels().get(i);
			if (l.getType().equals("Puzzle")) {
				PuzzleLevelApplication pApp = new PuzzleLevelApplication((PuzzleLevel)l);
				pApp.setName("mainlevel" + (i+1));
				levelApplications.add(pApp);
			}
			else if (l.getType().equals("Lightning")) {
				lightningLevelTimer = new Timer(1000, new LightningTimerController(this, this.model, i));
				LightningLevelApplication lApp = new LightningLevelApplication((LightningLevel)l, lightningLevelTimer);
				lApp.setName("mainlevel" + (i+1));
				levelApplications.add(lApp);
			}
			else {
				ThemeLevelApplication tApp = new ThemeLevelApplication((ThemeLevel)l);
				tApp.setName("mainlevel" + (i+1));
				levelApplications.add(tApp);
			}
		}

		int numCustomLevels = model.getCustomLevels().size();
		for (int i = 0; i < numCustomLevels; i++) {
			LevelModel l = model.getCustomLevels().get(i);
			if (l.getType().equals("Puzzle")) {
				PuzzleLevelApplication pApp = new PuzzleLevelApplication((PuzzleLevel)l);
				pApp.setName("customlevel" + (i+1));
				customLevelApplications.add(pApp);
			}
			else if (l.getType().equals("Lightning")) {
				lightningLevelTimer = new Timer(1000, new LightningTimerController(this, this.model, i));
				LightningLevelApplication lApp = new LightningLevelApplication((LightningLevel)l, lightningLevelTimer);
				lApp.setName("customlevel" + (i+1));
				customLevelApplications.add(lApp);
			}
			else {
				ThemeLevelApplication tApp = new ThemeLevelApplication((ThemeLevel)l);
				tApp.setName("customlevel" + (i+1));
				customLevelApplications.add(tApp);
			}
		}

		// display splash screen for 4 seconds
		displayTime = 4;
		splashScreenTimer = new Timer(1000, new SplashScreenTimerController(this, this.model));
		splashScreenTimer.start();
		this.setContentPane(splashScreen);
		

	}

	/**
	 * Getter for how many seconds to display Splash Screen
	 */
	
	public int getDisplayTime() {
		return displayTime;
	}

	/**
	 * Getter for Timer for determining how long Splash Screen should be displayed
	 */
	
	public Timer getSplashScreenTimer() {
		return splashScreenTimer;
	}
	
	/**
	 * Getter for decrementing time of Splash Screen
	 */
	

	public void decrementDisplayTime() {
		displayTime--;
	}
	
	/**
	 * Getter for Main Menu GUI after Splash Screen is implemented
	 */

	public InitializeGameApplication getMainMenu() {
		return mainMenu;
	}
	
	/**
	 * Getter for Map GUI
	 */

	public MapApplication getMapApplication() {
		return mapMenu;
	}

	/**
	 * Getter for Custom Map GUI
	 */
	
	public ViewCustomLevelsApplication getViewCustomLevelsApplication() {
		return customMenu;
	}

	/**
	 * Getter for Level GUI
	 */
	
	public ArrayList<LevelApplication> getLevelApplications() {
		return levelApplications;
	}
	
	/**
	 * Getter for Custom Level GUI
	 */

	public ArrayList<LevelApplication> getCustomLevelApplications() {
		return customLevelApplications;
	}
	
	/**
	 * Getter for Model Entities which contains adventure mode level information
	 */
	
	public Model getModel() {
		return model;
	}

}
