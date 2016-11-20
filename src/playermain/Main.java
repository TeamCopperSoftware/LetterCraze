package playermain;

import java.awt.EventQueue;
import javax.swing.JFrame;

import builderboundary.SplashScreenApplication;
import playerboundary.PuzzleLevelApplication;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					//SplashScreenApplication frame = new SplashScreenApplication();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 320);
		frame.setContentPane(new PuzzleLevelApplication());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
