package playerboundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.LevelModel;
import entities.Model;

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
 * The containing Frame in all Custom Levels for LetterCraze Player.
 */

public class ViewCustomLevelsApplication extends JPanel {
	
	/** Model of PlayerApplication. */
	Model model;

	/** Back button. */
	JButton backButton;
	
	/** Level Buttons. */
	ArrayList<JButton> levelButtons;
	
	/** Level Scores Number. */
	ArrayList<JLabel> levelScores;
	
	/** Labels to display stars. */
	ArrayList<JLabel> stars;

	/**
	 * Default constructor for Custom Levels View.
	 */
	
	public ViewCustomLevelsApplication(Model m) {
		
		model = m;
				
		setBounds(0, 0, 800, 600);
		// we'll figure out a unified design later.. hopefully come together on a decision
		//this.setBackground(new Color(176, 196, 222));

		// padding on edge of panel
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setLayout(null);

		JLabel lblPlayerMap = new JLabel("Custom Levels");
		lblPlayerMap.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		//lblPlayerMap.setForeground(new Color(0, 0, 205));
		//lblPlayerMap.setFont(new Font("Snap ITC", Font.BOLD, 25));
		lblPlayerMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerMap.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerMap.setBounds(0, 46, 800, 49);
		this.add(lblPlayerMap);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
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
				b.setFont(new Font("Corbel", Font.BOLD, 11));
				b.setBackground(new Color(0, 128, 128));
				b.setBounds(50+(x*143), 125+(y*150), 125, 100);
				b.setText("Empty");
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

		/*
		level1Button = new JButton("Puzzle! \r\n1");
		level1Button.setForeground(new Color(0, 0, 0));
		level1Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level1Button.setBackground(new Color(0, 128, 128));
		level1Button.setBounds(50, 125, 125, 100);
		this.add(level1Button);

		level2Button = new JButton("Lightning! \r\n2");
		level2Button.setForeground(Color.BLACK);
		level2Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level2Button.setBackground(new Color(0, 128, 128));
		level2Button.setBounds(193, 125, 125, 100);
		this.add(level2Button);

		level3Button = new JButton("Theme! \r\n3");
		level3Button.setForeground(Color.BLACK);
		level3Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level3Button.setBackground(new Color(0, 128, 128));
		level3Button.setBounds(336, 125, 125, 100);
		this.add(level3Button);

		level4Button = new JButton("LOCK");
		level4Button.setForeground(Color.BLACK);
		level4Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level4Button.setBackground(new Color(0, 128, 128));
		level4Button.setBounds(479, 125, 125, 100);
		this.add(level4Button);

		level5Button = new JButton("LOCK");
		level5Button.setForeground(Color.BLACK);
		level5Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level5Button.setBackground(new Color(0, 128, 128));
		level5Button.setBounds(625, 125, 125, 100);
		this.add(level5Button);

		level6Button = new JButton("LOCK");
		level6Button.setForeground(Color.BLACK);
		level6Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level6Button.setBackground(new Color(0, 128, 128));
		level6Button.setBounds(50, 275, 125, 100);
		this.add(level6Button);

		level7Button = new JButton("LOCK");
		level7Button.setForeground(Color.BLACK);
		level7Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level7Button.setBackground(new Color(0, 128, 128));
		level7Button.setBounds(193, 275, 125, 100);
		this.add(level7Button);

		level8Button = new JButton("LOCK");
		level8Button.setForeground(Color.BLACK);
		level8Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level8Button.setBackground(new Color(0, 128, 128));
		level8Button.setBounds(336, 275, 125, 100);
		this.add(level8Button);

		level9Button = new JButton("LOCK");
		level9Button.setForeground(Color.BLACK);
		level9Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level9Button.setBackground(new Color(0, 128, 128));
		level9Button.setBounds(479, 275, 125, 100);
		this.add(level9Button);

		level10Button = new JButton("LOCK");
		level10Button.setForeground(Color.BLACK);
		level10Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level10Button.setBackground(new Color(0, 128, 128));
		level10Button.setBounds(625, 275, 125, 100);
		this.add(level10Button);

		level11Button = new JButton("LOCK");
		level11Button.setForeground(Color.BLACK);
		level11Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level11Button.setBackground(new Color(0, 128, 128));
		level11Button.setBounds(50, 425, 125, 100);
		this.add(level11Button);

		level12Button = new JButton("LOCK");
		level12Button.setForeground(Color.BLACK);
		level12Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level12Button.setBackground(new Color(0, 128, 128));
		level12Button.setBounds(193, 425, 125, 100);
		this.add(level12Button);

		level13Button = new JButton("LOCK");
		level13Button.setForeground(Color.BLACK);
		level13Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level13Button.setBackground(new Color(0, 128, 128));
		level13Button.setBounds(336, 425, 125, 100);
		this.add(level13Button);

		level14Button = new JButton("LOCK");
		level14Button.setForeground(Color.BLACK);
		level14Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level14Button.setBackground(new Color(0, 128, 128));
		level14Button.setBounds(479, 425, 125, 100);
		this.add(level14Button);

		level15Button = new JButton("LOCK");
		level15Button.setForeground(Color.BLACK);
		level15Button.setFont(new Font("Corbel", Font.BOLD, 11));
		level15Button.setBackground(new Color(0, 128, 128));
		level15Button.setBounds(625, 425, 125, 100);
		this.add(level15Button);

		// NUM SCORES

		level1NumScore = new JLabel("0000000000");
		level1NumScore.setHorizontalAlignment(SwingConstants.CENTER);
		level1NumScore.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		level1NumScore.setBounds(50, 107, 125, 14);
		this.add(level1NumScore);

		level2NumScore = new JLabel("0000000000");
		level2NumScore.setHorizontalAlignment(SwingConstants.CENTER);
		level2NumScore.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		level2NumScore.setBounds(193, 107, 125, 14);
		this.add(level2NumScore);

		level3NumScore = new JLabel("0000000000");
		level3NumScore.setHorizontalAlignment(SwingConstants.CENTER);
		level3NumScore.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		level3NumScore.setBounds(336, 107, 125, 14);
		this.add(level3NumScore);

		//STAR IMAGES 

		JLabel level1Stars = new JLabel("");
		Image image = new ImageIcon("image/StarsEmpty.png").getImage();
		image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH); // scale the image when necessary
		level1Stars.setIcon(new ImageIcon(image));
		level1Stars.setBounds(70, 225, 81, 27);
		this.add(level1Stars);

		JLabel level2Stars = new JLabel("");
		Image image2 = new ImageIcon("image/StarsEmpty.png").getImage();
		image2 = image2.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH); // scale the image when necessary
		level2Stars.setIcon(new ImageIcon(image2));
		level2Stars.setBounds(213, 225, 81, 27);
		this.add(level2Stars);

		JLabel level3Stars = new JLabel("");
		Image image3 = new ImageIcon("image/StarsEmpty.png").getImage();
		image3 = image3.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH); // scale the image when necessary
		level3Stars.setIcon(new ImageIcon(image3));
		level3Stars.setBounds(356, 225, 81, 27);
		this.add(level3Stars);
		*/
	}

	/**
	 * Updates buttons and labels based on data in the entity classes.
	 */
	 
	public void refreshPanel() {

		int currentLevel = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5 && currentLevel < model.getCustomLevels().size(); x++) {
				LevelModel lm = model.getCustomLevels().get(currentLevel);
				Image image;
				if (lm.getIsUnlocked()) {
					levelButtons.get(currentLevel).setText(lm.getType() + "! \r\n" + (currentLevel+1));
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
	 * Gets controllers for all level selection buttons in Custom Mode Map.
	 */
		
	public ArrayList<JButton> getLevelButtons() {
		return levelButtons;
	}

}
