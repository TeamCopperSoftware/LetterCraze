package playerboundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Model;
import playercontroller.SplashScreenTimerController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * The containing Frame for SplashScreen in LetterCraze Player.
 */

public class SplashScreenApplication extends JPanel {

	/** Model of PlayerApplication. */
	Model model;
	
	/** All Team, members, and type of application text for Splash Screen. */
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_2;


	/**
	 * Default constructor for Splash Screen View.
	 * @param m 	All modeling information related to LetterCraze
	 */
	
    public SplashScreenApplication(Model m) {
    	
    	model = m;
        setBounds(0, 0, 800, 600);
        //this.setBackground(Color.BLUE);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        
        lblNewLabel = new JLabel("Team Copper Presents\r\n");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(6, 110, 788, 52);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        this.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("John Dyer");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(6, 241, 788, 28);
        this.add(lblNewLabel_1);
        
        lblNewLabel_3 = new JLabel("Annie Hernandez");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(6, 268, 788, 28);
        this.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Anthony Gringeri");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(6, 294, 788, 28);
        this.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("James Kradjian");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(6, 318, 788, 28);
        this.add(lblNewLabel_5);
        
        lblNewLabel_2 = new JLabel("Goutham Deva");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(6, 349, 788, 19);
        this.add(lblNewLabel_2);
        
        JLabel lblPlayer = new JLabel("Main Game");
        lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        lblPlayer.setBounds(6, 446, 788, 52);
        add(lblPlayer);
        
    }
}
