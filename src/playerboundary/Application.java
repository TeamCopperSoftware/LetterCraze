package playerboundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

import entities.*;
import entities.Model;
import playerboundary.SplashScreenApplication;
import playercontroller.CustomLightningTimerController;
import playercontroller.LightningTimerController;
import playercontroller.SplashScreenTimerController;

/**
 * The containing Frame for LetterCraze Player.
 */

public class Application extends JFrame {

	/** All Player information. */
	Model model;

	// All the other views should be stored as properties here
	/** Frame for Splash Screen. */
	SplashScreenApplication splashScreen;
	/** Frame for Builder Main Menu screen. */
	InitializeGameApplication mainMenu;
	/** Frame for Map with all 15 pre-made levels screen. */
	MapApplication mapMenu;
	/** Frame for Map with all custom levels published from LetterCraze Builder. */
	ViewCustomLevelsApplication customMenu;

	/** Frame for level screen. */
	ArrayList<LevelApplication> levelApplications;
	/** Frame for custom levels screen. */
	ArrayList<LevelApplication> customLevelApplications;

	/** Number of seconds to display splash screen. */
	int displayTime;
	/** Timer for determining how long splash screen should be displayed. */	
	Timer splashScreenTimer;
	/** Timer for determining time limit for each lightning level. */	
	Timer lightningLevelTimer;


	/**
	 * Default constructor for LetterCraze Player Application.
	 * @param model		Model which contains all entity objects
	 */

	public Application(Model model) {
		//pack(); not really sure what pack does
		
		// this handles all events pertaining to closing the Application
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to exit LetterCraze?\n"
						+ "All data will be saved when you exit.", "",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					try {
						// save player's entire model to its file
						FileOutputStream fileOut =
								new FileOutputStream("playersave.ser");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(model);
						out.close();
						fileOut.close();
						System.out.println("Serialized model data is saved in playersave.ser");
						
						// save the custom levels to buildersave.ser file 
						FileOutputStream fileOut2 = new FileOutputStream("buildersave.ser");
						ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
						out2.writeObject(model.getCustomLevels());
						out2.close();
						fileOut2.close();
						System.out.println("Builder ArrayList<LevelModel> saved in buildersave.ser");
					}catch(IOException i) {
						i.printStackTrace();
					}
					dispose();
					System.exit(0);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
				lightningLevelTimer = new Timer(1000, new CustomLightningTimerController(this, this.model, i));
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
	 * Getter for how many seconds to display Splash Screen.
	 * @return Number of seconds to display splash screen
	 */

	public int getDisplayTime() {
		return displayTime;
	}

	/**
	 * Getter for Timer for determining how long Splash Screen should be displayed.
	 * @return Timer for determining how long splash screen should be displayed
	 */

	public Timer getSplashScreenTimer() {
		return splashScreenTimer;
	}

	/**
	 * Getter for decrementing time of Splash Screen. 
	 */


	public void decrementDisplayTime() {
		displayTime--;
	}

	/**
	 * Getter for Main Menu GUI after Splash Screen is implemented.
	 * @return Frame for Player Main Menu
	 */

	public InitializeGameApplication getMainMenu() {
		return mainMenu;
	}

	/**
	 * Getter for Map GUI.
	 * @return Frame for Adventure Level Map
	 */

	public MapApplication getMapApplication() {
		return mapMenu;
	}

	/**
	 * Getter for Custom Map GUI.
	 * @return Frame for Custom Level Map
	 */

	public ViewCustomLevelsApplication getViewCustomLevelsApplication() {
		return customMenu;
	}

	/**
	 * Getter for Level GUI.
	 * @return All Adventure Levels for LetterCraze Player
	 */

	public ArrayList<LevelApplication> getLevelApplications() {
		return levelApplications;
	}

	/**
	 * Getter for Custom Level GUI.
	 * @return All Custom Levels for LetterCraze Player
	 */

	public ArrayList<LevelApplication> getCustomLevelApplications() {
		return customLevelApplications;
	}

	/**
	 * Getter for Model Entities which contains adventure mode level information.
	 * @return Model which contains all entity objects
	 */

	public Model getModel() {
		return model;
	}

}
