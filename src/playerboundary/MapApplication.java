package playerboundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

/**
 * The containing Frame for Adventure Map in LetterCraze Player.
 */

public class MapApplication extends JPanel {

	Model model;

	/** Back button. */
	JButton backButton;

	/** Level Buttons. */
	ArrayList<JButton> levelButtons;

	/** Level Num Scores. */
	ArrayList<JLabel> levelScores;

	/** Labels to display stars. */
	ArrayList<JLabel> stars;


	/**
	 * Default constructor for LetterCraze Player Adventure Map.
	 */

	public MapApplication(Model m) {

		model = m;

		setBounds(0, 0, 800, 600);

		// padding on edge of panel
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setLayout(null);

		JLabel lblPlayerMap = new JLabel("Adventure Map");
		lblPlayerMap.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		//lblPlayerMap.setForeground(new Color(0, 0, 205));
		//lblPlayerMap.setFont(new Font("Snap ITC", Font.BOLD, 25));
		lblPlayerMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerMap.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerMap.setBounds(0, 46, 800, 49);
		this.add(lblPlayerMap);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		backButton.setBounds(20, 20, 75, 29);
		this.add(backButton);

		levelButtons = new ArrayList<JButton>();
		levelScores = new ArrayList<JLabel>();
		stars = new ArrayList<JLabel>();

		// Creates 15 buttons for levels, 15 labels for scores, and 15 labels for stars
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				JButton b = new JButton();
				JLabel l = new JLabel();
				JLabel s = new JLabel();
				b.setForeground(Color.BLACK);
				b.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
				//b.setBackground(new Color(0, 128, 128));
				b.setBounds(50+(x*143), 125+(y*150), 125, 100);
				levelButtons.add(b);
				this.add(b);
				l.setHorizontalAlignment(SwingConstants.CENTER);
				l.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
				l.setBounds(50+(x*143), 110+(y*150), 125, 14);
				levelScores.add(l);
				this.add(l);
				s.setBounds(70+(x*143), 225+(y*150), 81, 27);
				stars.add(s);
				this.add(s);
			}
		}


		// updates buttons and labels based on data in the entity classes
		refreshPanel();		
	}


	/**
	 * Updates buttons and labels based on data in the entity classes.
	 */

	public void refreshPanel() {

		int currentLevel = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				LevelModel lm = model.getMainLevels().getLevels().get(currentLevel);
				Image image;
				if (lm.getIsUnlocked()) {
					levelButtons.get(currentLevel).setText("<html><center>" + lm.getType() + "!" + "<br>" + (currentLevel+1) + "</html></center>");
					levelScores.get(currentLevel).setText(String.valueOf(lm.getBestScore().getScore()));
					if (lm.getBestScore().getStar() == 0) {
						image = new ImageIcon("image/StarsEmpty.png").getImage();
						image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
					}
					else if (lm.getBestScore().getStar() == 1) {
						image = new ImageIcon("image/StarsOne.png").getImage();
						image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
					}
					else if (lm.getBestScore().getStar() == 2) {
						image = new ImageIcon("image/StarsTwo.png").getImage();
						image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
					}
					else {
						image = new ImageIcon("image/StarsThree.png").getImage();
						image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
					}
					stars.get(currentLevel).setIcon(new ImageIcon(image));

				}
				else {
					levelButtons.get(currentLevel).setText("Locked");
				}
				currentLevel++;
			}
		}
	}

	/**
	 * Get controller for back button which takes user back to Main Application Menu.
	 */
	
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * Gets controllers for all level selection buttons in Adventure Mode Map.
	 */
	
	public ArrayList<JButton> getLevelButtons() {
		return levelButtons;
	}


}
