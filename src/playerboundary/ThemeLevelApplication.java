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
import entities.Model;
import entities.Square;
import entities.ThemeLevel;

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

public class ThemeLevelApplication extends LevelApplication {

	/**
	 * Create the panel.
	 */
	public ThemeLevelApplication(ThemeLevel m) {
		super(m);
		titleLabel.setText("Theme - " + m.getTheme());
		objectiveLabel.setText("Words Left");
		objectiveValueLabel.setText(String.valueOf(m.getValidWords().size()));

	}

	public JButton getExitButton() {
		return exitButton;
	}
	
	public void refreshObjective(ThemeLevel level) {
		objectiveValueLabel.setText(String.valueOf(level.getValidWords().size() - level.getHistorySize()));
	}
}
