package playerboundary;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

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

	/**
	 * Create the panel.
	 */
	public LightningLevelApplication(LightningLevel m) {
		super(m);
		titleLabel.setText("Lightning");
		objectiveLabel.setText("Time Left");
		
		int minutes = m.getTimeLimit()/60;
		int seconds = m.getTimeLimit()%60;
		if (seconds < 10) {
			objectiveValueLabel.setText((m.getTimeLimit()/60) + ":0" + m.getTimeLimit()%60);
		}
		else {
			objectiveValueLabel.setText((m.getTimeLimit()/60) + ":" + m.getTimeLimit()%60);
		}
	}

	public JButton getExitButton() {
		return exitButton;
	}
}
