package builderboundary;

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

public class InitializeBuilderApplication extends JPanel {

	JLabel label_3;
	JLabel lblNewLabel;
	JButton btnNewButton;
	JLabel label;
	JLabel label_4;
	JLabel label_1;
	JLabel label_5;
	JLabel label_2;
	
    
    public InitializeBuilderApplication() {
        
        setBounds(0, 0, 800, 600);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(new GridLayout(0, 3, 0, 0));
        
        
        JButton btnNewButton_1 = new JButton("Edit Saved Level");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        
        label_3 = new JLabel("");
        this.add(label_3);
        
        lblNewLabel = new JLabel("LetterCraze Builder");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        this.add(lblNewLabel);
        
        btnNewButton = new JButton("Create");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        label = new JLabel("");
        this.add(label);
        
        label_4 = new JLabel("");
        this.add(label_4);
        this.add(btnNewButton);
        
        label_1 = new JLabel("");
        this.add(label_1);
        
        label_5 = new JLabel("");
        this.add(label_5);
        this.add(btnNewButton_1);
        
        label_2 = new JLabel("");
        this.add(label_2);
    }

}
