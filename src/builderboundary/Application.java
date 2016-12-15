package builderboundary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import buildercontroller.SplashScreenTimerController;
import entities.*;

/**
 * The containing Frame for LetterCraze Builder.
 */

public class Application extends JFrame {

	/** All Builder information. */
	BuilderModel model;
	
	// All the other views should be stored as properties here
	/** Frame for Splash Screen. */
	SplashScreenApplication splashScreen;
	/** Frame for Builder Main Menu screen. */
	InitializeBuilderApplication initializeBuilderApplication;
	/** Frame for New level creation screen. */
	CreateNewLevelApplication createNewLevelApplication;
	/** Frame for Map with all saved levels screen. */
	SavedLevelsMapApplication savedLevelsMapApplication;
	/** Frame for saved custom levels screen. */
	ArrayList<EditSavedLevelApplication> editSavedLevelApplications;

	
	/** Number of seconds to display splash screen. */
	int displayTime;
	/** Timer for determining how long splash screen should be displayed. */	
	Timer splashScreenTimer;


	/**
	 * Create the frame.
	 * @param model 	model information for Builder
	 */
	public Application(BuilderModel model) {
		//pack();
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to exit LetterCraze Builder?\n"
						+ "All data will be saved when you exit.", "",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					try {
						FileOutputStream fileOut =
								new FileOutputStream("buildersave.ser");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(model.getSavedLevels());
						out.close();
						fileOut.close();
						System.out.printf("Builder ArrayList<LevelModel> saved in buildersave.ser");
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
		setTitle("LetterCraze Builder");
		
		this.model = model;
		
		// initialize views
		splashScreen = new SplashScreenApplication(model);
		initializeBuilderApplication = new InitializeBuilderApplication(model);
		createNewLevelApplication = new CreateNewLevelApplication(model);
		savedLevelsMapApplication = new SavedLevelsMapApplication(model);
		editSavedLevelApplications = new ArrayList<EditSavedLevelApplication>();
		for (int i = 0; i < 15; i++) {
			editSavedLevelApplications.add(new EditSavedLevelApplication(model, i));
		}
		
		// display splash screen for 4 seconds
		displayTime = 4;  
        splashScreenTimer = new Timer(1000, new SplashScreenTimerController(this, this.model));
        splashScreenTimer.start();
		this.setContentPane(splashScreen);
		
	}
	
	
	/** Retrieves number of seconds to display splash screen.
	 * @return Number of seconds to display splash screen
	 */
	public int getDisplayTime() {
		return displayTime;
	}

	/** Retrieves timer for determining how long splash screen should be displayed.
	 * @return Timer for determining how long splash screen should be displayed
	 */
	public Timer getSplashScreenTimer() {
		return splashScreenTimer;
	}
	
	/** Decreases display timer by 1 second every second.
	 */
	public void decrementDisplayTime() {
		displayTime--;
	}

	/** Retrieves frame for Builder Main Menu screen.
	 * @return Frame for Builder Main Menu screen
	 */
	public InitializeBuilderApplication getInitializeBuilderApplication() {
		return initializeBuilderApplication;
	}

	/** Retrieves frame for New level creation screen.
	 * @return Frame for New level creation screen
	 */

	public CreateNewLevelApplication getCreateNewLevelApplication() {
		return createNewLevelApplication;
	}

	/** Retrieves frame for Map with all saved levels screen.
	 * @return Frame for Map with all saved levels screen
	 */
	public SavedLevelsMapApplication getSavedLevelsMapApplication() {
		return savedLevelsMapApplication;
	}
	
	/** Retrieves frame for saved custom levels screen.
	 * @return Frame for saved custom levels screen
	 */
	public ArrayList<EditSavedLevelApplication> getEditSavedLevelApplications() {
		return editSavedLevelApplications;
	}

}
