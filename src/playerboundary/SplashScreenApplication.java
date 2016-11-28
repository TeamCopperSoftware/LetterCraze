package playerboundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class SplashScreenApplication extends JPanel {

	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_2;


    /**
     * Create the frame.
     */
    public SplashScreenApplication() {
        setBounds(0, 0, 800, 600);
        //this.setBackground(Color.BLUE);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        
        lblNewLabel = new JLabel("Team Copper Presents\r\n");
        lblNewLabel.setBounds(230, 110, 367, 52);
        lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
        this.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("John Dyer");
        lblNewLabel_1.setBounds(347, 241, 162, 28);
        this.add(lblNewLabel_1);
        
        lblNewLabel_3 = new JLabel("Annie Hernandez");
        lblNewLabel_3.setBounds(347, 268, 162, 28);
        this.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Anthony Gringeri");
        lblNewLabel_4.setBounds(347, 294, 162, 28);
        this.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("James Kradjian");
        lblNewLabel_5.setBounds(347, 318, 162, 28);
        this.add(lblNewLabel_5);
        
        lblNewLabel_2 = new JLabel("Goutham Deva");
        lblNewLabel_2.setBounds(347, 349, 162, 19);
        this.add(lblNewLabel_2);
        
    }
    
}
