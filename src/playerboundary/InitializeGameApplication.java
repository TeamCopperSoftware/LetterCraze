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

    public InitializeGameApplication() {
        setBounds(0, 0, 800, 600);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JButton btnNewButton_1 = new JButton("Play Custom Levels");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel label_3 = new JLabel("");
        this.add(label_3);
        
        JLabel lblNewLabel = new JLabel("Letter Craze Player");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        this.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Play Game");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JLabel label = new JLabel("");
        this.add(label);
        
        JLabel label_4 = new JLabel("");
        this.add(label_4);
        this.add(btnNewButton);
        
        JLabel label_1 = new JLabel("");
        this.add(label_1);
        
        JLabel label_5 = new JLabel("");
        this.add(label_5);
        this.add(btnNewButton_1);
        
        JLabel label_2 = new JLabel("");
        this.add(label_2);
    }

}
