package playerboundary;

import javax.swing.JFrame;
import javax.swing.Timer;

import entities.Model;
import playerboundary.SplashScreenApplication;
import playercontroller.SplashScreenTimerController;

public class Application extends JFrame {
	
	Model model;

	// All the other views should be stored as properties here
	SplashScreenApplication splashScreen;
	InitializeGameApplication mainMenu;
	MapApplication mapMenu;
	ViewCustomLevelsApplication customMenu;
	PuzzleLevelApplication puzzleLevelApplication;
	LightningLevelApplication lightningLevelApplication;
	ThemeLevelApplication themeLevelApplication;

	// how many seconds to display splash screen
	int displayTime;
	// Timer for determining how long splash screen should be displayed
	Timer splashScreenTimer;
	
	
	/**
	 * Create the frame.
	 */
	public Application(Model model) {
		//pack(); not really sure what pack does
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("LetterCraze Player");
		
		this.model = model;
		
		// initialize views
		splashScreen = new SplashScreenApplication();
		mainMenu = new InitializeGameApplication();
		mapMenu = new MapApplication();
		customMenu = new ViewCustomLevelsApplication();
		puzzleLevelApplication = new PuzzleLevelApplication();
		lightningLevelApplication = new LightningLevelApplication();
		themeLevelApplication = new ThemeLevelApplication();
		
		
		// display splash screen for 4 seconds
		displayTime = 4;
        splashScreenTimer = new Timer(1000, new SplashScreenTimerController(this, this.model));
        splashScreenTimer.start();
		this.setContentPane(splashScreen);
		
	}
	
	public int getDisplayTime() {
		return displayTime;
	}
	
	public Timer getSplashScreenTimer() {
		return splashScreenTimer;
	}
	
	public void decrementDisplayTime() {
		displayTime--;
	}
	
	public InitializeGameApplication getMainMenu() {
		return mainMenu;
	}
	
	public MapApplication getMapApplication() {
		return mapMenu;
	}
	
	public ViewCustomLevelsApplication getViewCustomLevelsApplication() {
		return customMenu;
	}
	
	public PuzzleLevelApplication getPuzzleLevelApplication() {
		return puzzleLevelApplication;
	}
	
	public LightningLevelApplication getLightningLevelApplication() {
		return lightningLevelApplication;
	}
	
	public ThemeLevelApplication getThemeLevelApplication() {
		return themeLevelApplication;
	}

}
