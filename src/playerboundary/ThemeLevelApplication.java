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

	ThemeLevel model;
	JButton exitButton;
	ArrayList<JButton> squareButtons;
	JLabel objectiveValueLabel; // words left

	/**
	 * Create the panel.
	 */
	public ThemeLevelApplication(ThemeLevel m) {
		
		super(m);
		titleLabel.setText("Theme - " + m.getTheme());
		objectiveLabel.setText("Words Left");
		objectiveValueLabel.setText(String.valueOf(m.get));

	}

	public void refreshPanel(ThemeLevel level) {
		int currentSquare = 0;
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {

				Square s = level.getBoard().lookUpSquare(x, y);
				if (s.isEnabled()) {
					squareButtons.get(currentSquare).setVisible(true);
					if (s.hasTile()) {
						squareButtons.get(currentSquare).setText(s.tilePeek().toString());
					}
				}
				else {
					squareButtons.get(currentSquare).setVisible(false);
				}

				currentSquare++;

			}
		}
		
		objectiveValueLabel.setText(String.valueOf(level.getValidWords().size()));
	}

	public JButton getExitButton() {
		return exitButton;
	}
}
