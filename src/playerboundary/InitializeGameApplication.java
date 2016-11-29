package playerboundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class InitializeGameApplication extends JPanel {

	JButton playGameButton;
	JButton playCustomLevelsButton;

	public InitializeGameApplication() {
		setBounds(0, 0, 800, 600);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		// Title
		JLabel title = new JLabel("LetterCraze");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 26));
		title.setBounds(0, 150, 800, 26);
		this.add(title); 
		
		// Play Main Game Button
		playGameButton = new JButton("Play Game");
		playGameButton.setBounds(325, 250, 150, 100);
		this.add(playGameButton);		
		
		// Play Custom Levels Button
		playCustomLevelsButton = new JButton("Play Custom Levels");
		playCustomLevelsButton.setBounds(325, 360, 150, 100);
		this.add(playCustomLevelsButton);
	}

	// return button for getting to Main Game
	public JButton getMapButton() {
		return playGameButton;
	}

	// return button for getting to CustomLevelsMap
	public JButton getCustomLevelsButton() {
		return playCustomLevelsButton;
	}

}
