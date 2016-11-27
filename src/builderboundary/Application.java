package builderboundary;

import javax.swing.JFrame;

public class Application extends JFrame {

	// All the other views should be stored as properties here
	SplashScreenApplication splashScreen;
	
	
	/**
	 * Create the frame.
	 */
	public Application() {
		//pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("LetterCraze Builder");
		splashScreen = new SplashScreenApplication();
		this.setContentPane(splashScreen);
		
	}

}
