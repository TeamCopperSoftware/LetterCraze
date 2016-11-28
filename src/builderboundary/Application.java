package builderboundary;

import javax.swing.JFrame;

import entities.Model;

public class Application extends JFrame {

	Model model;
	
	// All the other views should be stored as properties here
	SplashScreenApplication splashScreen;
	
	
	/**
	 * Create the frame.
	 */
	public Application(Model model) {
		//pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("LetterCraze Builder");
		
		this.model = model;
		
		// initialize views
		splashScreen = new SplashScreenApplication();
		
		this.setContentPane(splashScreen);
		
	}

}
