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

public class InitializeGameApplication extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InitializeGameApplication frame = new InitializeGameApplication();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public InitializeGameApplication() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JButton btnNewButton_1 = new JButton("Play Custom Levels");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel label_3 = new JLabel("");
        contentPane.add(label_3);
        
        JLabel lblNewLabel = new JLabel("Letter Craze Player");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Play Game");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JLabel label = new JLabel("");
        contentPane.add(label);
        
        JLabel label_4 = new JLabel("");
        contentPane.add(label_4);
        contentPane.add(btnNewButton);
        
        JLabel label_1 = new JLabel("");
        contentPane.add(label_1);
        
        JLabel label_5 = new JLabel("");
        contentPane.add(label_5);
        contentPane.add(btnNewButton_1);
        
        JLabel label_2 = new JLabel("");
        contentPane.add(label_2);
    }

}
