package playerboundary;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TestWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
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
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setContentPane(new PuzzleLevelApplication());
		//frame.setContentPane(new LightningLevelView());
		//frame.setContentPane(new ThemeLevelView());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
