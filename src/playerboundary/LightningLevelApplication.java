package playerboundary;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.Square;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * The containing Frame for only Lightning type levels in LetterCraze.
 */

public class LightningLevelApplication extends LevelApplication {

	Timer timer;
	int timeLeft;
	
	/**
	 * Default constructor for Lightning Level Application.
	 */
	
	public LightningLevelApplication(LightningLevel m, Timer t) {
		super(m);
		titleLabel.setText("Lightning");
		objectiveLabel.setText("Time Left");
		this.timer = t;
		objectiveValueLabel.setText(String.valueOf(m.getTimeLimit()));
		
		// leaving this here in case we want to format it differently
		/*
		int minutes = m.getTimeLimit()/60;
		int seconds = m.getTimeLimit()%60;
		if (seconds < 10) {
			objectiveValueLabel.setText((m.getTimeLimit()/60) + ":0" + m.getTimeLimit()%60);
		}
		else {
			objectiveValueLabel.setText((m.getTimeLimit()/60) + ":" + m.getTimeLimit()%60);
		}
		*/
	}
	
	/**
	 * Resets all lightning level entities when entering a non-completed level.
	 */
	
	@Override
	public void refreshPanel(LevelModel level) {

		// set board
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {

				Square s = level.getBoard().lookUpSquare(x, y);
				if (s.isEnabled()) {
					squareButtons[x][y].setVisible(true);
					if (s.hasTile()) {
						squareButtons[x][y].setText(s.tilePeek().toString());
					}
				}
				else {
					squareButtons[x][y].setVisible(false);
				}
			}
		}
		
		// update score
		scoreLabel.setText(String.valueOf(level.getCurrentScore().getScore()));
		
		progressBar.setValue(level.getCurrentScore().getScore());
		
		// update stars
		if (level.getCurrentScore().getStar() == 0) {
			Image image = new ImageIcon("image/StarsEmpty.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		else if (level.getCurrentScore().getStar() == 1) {
			Image image = new ImageIcon("image/StarsOne.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		else if (level.getCurrentScore().getStar() == 2) {
			Image image = new ImageIcon("image/StarsTwo.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		else {
			Image image = new ImageIcon("image/StarsThree.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		
		// deselect panels
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				squareButtons[x][y].setBackground(Color.WHITE);
			}
		}
		
	}
	
	/**
	 * Initializes timer for lightning levels.
	 */
	
	public void initializeTimeLeft() {
		LightningLevel l = (LightningLevel)model;
		timeLeft = l.getTimeLimit();
	}
	
	/**
	 * 	Decrements timer for lightning levels by seconds.
	 */
	
	public void decrementTimeLeft() {
		timeLeft--;
	}
	
	/**
	 * Gets amount of time left when level is complete.
	 */
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
	/**
	 * Gets controllers for Timer which kicks player out of level if timer ends.
	 */
	
	public Timer getTimer() {
		return timer;
	}
	
	/**
	 * Gets list of Tiles selected.
	 */
	
	public JButton[][] getButtonList() {
		return squareButtons;
	}

	/**
	 * Gets controllers for exit button.
	 */
	
	public JButton getExitButton() {
		return exitButton;
	}
}
