package playerboundary;

import java.awt.EventQueue;

import javax.swing.JFrame;

import entities.Model;

public class TestWindow {

	Model model;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow(new Model());
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
	public TestWindow(Model m) {
		initialize(m);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Model m) {
		frame = new JFrame();
		model = m;
		frame.setBounds(100, 100, 800, 600);
		frame.setContentPane(new PuzzleLevelApplication(model));
		//frame.setContentPane(new LightningLevelView());
		//frame.setContentPane(new ThemeLevelView());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
