package builderboundary;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.BuilderModel;
import entities.LevelModel;
import entities.Model;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

/**
 * The containing frame for edit saved levels map.
 */

public class SavedLevelsMapApplication extends JPanel {
	
	BuilderModel model;
	
	// Back button
	JButton backButton;
	
	// Publish levels button
	JButton publishLevelsButton;
	
	// Buttons for saved levels
	ArrayList<JButton> levelButtons;
	
	// Buttons for deleting saved levels
	ArrayList<JButton> deleteButtons;

	/**
	 * Create the frame.
	 * @param model2 	entity information for saved level model
	 */
	public SavedLevelsMapApplication(BuilderModel model2) {
		model = model2;
		setBounds(0, 0, 800, 600);
		// we'll figure out a unified design later.. hopefully come together on a decision
		//this.setBackground(new Color(176, 196, 222));

		// padding on edge of panel
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setLayout(null);

		JLabel lblPlayerMap = new JLabel("Saved Levels");
		lblPlayerMap.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		//lblPlayerMap.setForeground(new Color(0, 0, 205));
		//lblPlayerMap.setFont(new Font("Snap ITC", Font.BOLD, 25));
		lblPlayerMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerMap.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerMap.setBounds(0, 46, 800, 49);
		this.add(lblPlayerMap);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		backButton.setBounds(10, 10, 75, 29);
		this.add(backButton);
		
		publishLevelsButton = new JButton("Publish Levels to LetterCraze");
		publishLevelsButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		publishLevelsButton.setBounds(544, 10, 250, 29);
		add(publishLevelsButton);
		
		levelButtons = new ArrayList<JButton>();
		deleteButtons = new ArrayList<JButton>();
		// Creates 15 buttons for levels
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				JButton b = new JButton();
				b.setForeground(Color.BLACK);
				b.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
				//b.setBackground(new Color(0, 128, 128));
				b.setBounds(50+(x*143), 125+(y*150), 125, 100);
				JButton delete = new JButton("x");
				delete.setOpaque(true);
				delete.setBackground(Color.RED); // this isn't working for me, idk why
				delete.setBounds(50+(x*143), 95+(y*150), 30, 30);
				levelButtons.add(b);
				deleteButtons.add(delete);
				this.add(b);
				this.add(delete);
			}
		}
		
		refreshPanel();


		
	}

	/**
	 * Updates buttons based on data in the entity classes.
	 */

	public void refreshPanel() {

		int currentLevel = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				if (currentLevel < model.getSavedLevels().size()) {
					String levelType = model.getSavedLevels().get(currentLevel).getType();
					levelButtons.get(currentLevel).setText("<html><center>" + "Custom " + (currentLevel+1) + "<br><br>" + levelType + "</html></center>");
					deleteButtons.get(currentLevel).setVisible(true);
				}
				else {
					levelButtons.get(currentLevel).setText("Empty");
					deleteButtons.get(currentLevel).setVisible(false);
				}
				currentLevel++;
			}

		}
	}


	public JButton getBackButton() {
		return backButton;
	}

	public ArrayList<JButton> getLevelButtons() {
		return levelButtons;
	}
	
	public ArrayList<JButton> getDeleteButtons() {
		return deleteButtons;
	}
	
	public JButton getPublishButton() {
		return publishLevelsButton;
	}
}
