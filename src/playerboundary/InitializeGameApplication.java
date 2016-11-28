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
        
        playCustomLevelsButton = new JButton("Play Custom Levels");
        playCustomLevelsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel label_3 = new JLabel("");
        this.add(label_3);
        
        JLabel lblNewLabel = new JLabel("Letter Craze Player");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        this.add(lblNewLabel);
        
        playGameButton = new JButton("Play Game");
        
        JLabel label = new JLabel("");
        this.add(label);
        
        JLabel label_4 = new JLabel("");
        this.add(label_4);
        this.add(playGameButton);
        
        JLabel label_1 = new JLabel("");
        this.add(label_1);
        
        JLabel label_5 = new JLabel("");
        this.add(label_5);
        this.add(playCustomLevelsButton);
        
        JLabel label_2 = new JLabel("");
        this.add(label_2);
    }
    
    // return button for getting to main menu
    public JButton getMapButton() {
		return playGameButton;
	}
    
    public JButton getCustomLevelsButton() {
    	return playCustomLevelsButton;
    }

}
