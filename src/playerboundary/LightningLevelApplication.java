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
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LightningLevelApplication extends LevelApplication {

	Timer timer;
	int timeLeft;
	
	/**
	 * Create the panel.
	 */
	public LightningLevelApplication(LightningLevel m, Timer t) {
		super(m);
		titleLabel.setText("Lightning");
		objectiveLabel.setText("Time Left");
		this.timer = t;
		
		int minutes = m.getTimeLimit()/60;
		int seconds = m.getTimeLimit()%60;
		if (seconds < 10) {
			objectiveValueLabel.setText((m.getTimeLimit()/60) + ":0" + m.getTimeLimit()%60);
		}
		else {
			objectiveValueLabel.setText((m.getTimeLimit()/60) + ":" + m.getTimeLimit()%60);
		}
	}
	
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
		
		// deselect panels
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				squareButtons[x][y].setBackground(Color.WHITE);
			}
		}
		
	}
	
	public void initializeTimeLeft() {
		LightningLevel l = (LightningLevel)model;
		timeLeft = l.getTimeLimit();
	}
	
	public void decrementTimeLeft() {
		timeLeft--;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public JButton getExitButton() {
		return exitButton;
	}
}
