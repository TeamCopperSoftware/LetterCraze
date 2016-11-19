package boundary;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class CustomMap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomMap frame = new CustomMap();
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
	public CustomMap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(123, 118, 81, 27);
		contentPane.add(label_3);
		
		JLabel lblPlayerMap = new JLabel("Custom Map");
		lblPlayerMap.setForeground(new Color(178, 34, 34));
		lblPlayerMap.setFont(new Font("Snap ITC", Font.BOLD, 25));
		lblPlayerMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerMap.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerMap.setBounds(151, 11, 238, 33);
		contentPane.add(lblPlayerMap);
		
		JButton btnNewButton = new JButton("1 Puzzle! ");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Corbel", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 69, 96, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(431, 20, 82, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnLightning = new JButton("2 Lightning!");
		btnLightning.setForeground(Color.BLACK);
		btnLightning.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLightning.setBackground(new Color(0, 128, 128));
		btnLightning.setBounds(113, 69, 96, 46);
		contentPane.add(btnLightning);
		
		JButton btnThemeThree = new JButton("3 Theme!");
		btnThemeThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemeThree.setForeground(Color.BLACK);
		btnThemeThree.setFont(new Font("Corbel", Font.BOLD, 11));
		btnThemeThree.setBackground(new Color(0, 128, 128));
		btnThemeThree.setBounds(219, 69, 96, 46);
		contentPane.add(btnThemeThree);
		
		JButton btnLock = new JButton("");
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLock.setForeground(Color.BLACK);
		btnLock.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock.setBackground(new Color(0, 128, 128));
		btnLock.setBounds(325, 69, 96, 46);
		contentPane.add(btnLock);
		
		JButton btnLock_1 = new JButton("");
		btnLock_1.setForeground(Color.BLACK);
		btnLock_1.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_1.setBackground(new Color(0, 128, 128));
		btnLock_1.setBounds(431, 69, 96, 46);
		contentPane.add(btnLock_1);
		
		JButton btnLock_2 = new JButton("");
		btnLock_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLock_2.setForeground(Color.BLACK);
		btnLock_2.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_2.setBackground(new Color(0, 128, 128));
		btnLock_2.setBounds(10, 154, 96, 46);
		contentPane.add(btnLock_2);
		
		JButton btnLock_3 = new JButton("");
		btnLock_3.setForeground(Color.BLACK);
		btnLock_3.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_3.setBackground(new Color(0, 128, 128));
		btnLock_3.setBounds(113, 154, 96, 46);
		contentPane.add(btnLock_3);
		
		JButton btnLock_4 = new JButton("");
		btnLock_4.setForeground(Color.BLACK);
		btnLock_4.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_4.setBackground(new Color(0, 128, 128));
		btnLock_4.setBounds(219, 154, 96, 46);
		contentPane.add(btnLock_4);
		
		JButton btnLock_5 = new JButton("");
		btnLock_5.setForeground(Color.BLACK);
		btnLock_5.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_5.setBackground(new Color(0, 128, 128));
		btnLock_5.setBounds(325, 154, 96, 46);
		contentPane.add(btnLock_5);
		
		JButton btnLock_6 = new JButton("");
		btnLock_6.setForeground(Color.BLACK);
		btnLock_6.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_6.setBackground(new Color(0, 128, 128));
		btnLock_6.setBounds(431, 154, 96, 46);
		contentPane.add(btnLock_6);
		
		JButton btnLock_7 = new JButton("");
		btnLock_7.setForeground(Color.BLACK);
		btnLock_7.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_7.setBackground(new Color(0, 128, 128));
		btnLock_7.setBounds(10, 230, 96, 46);
		contentPane.add(btnLock_7);
		
		JButton btnLock_8 = new JButton("");
		btnLock_8.setForeground(Color.BLACK);
		btnLock_8.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_8.setBackground(new Color(0, 128, 128));
		btnLock_8.setBounds(113, 230, 96, 46);
		contentPane.add(btnLock_8);
		
		JButton btnLock_9 = new JButton("");
		btnLock_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLock_9.setForeground(Color.BLACK);
		btnLock_9.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_9.setBackground(new Color(0, 128, 128));
		btnLock_9.setBounds(219, 230, 96, 46);
		contentPane.add(btnLock_9);
		
		JButton btnLock_10 = new JButton("");
		btnLock_10.setForeground(Color.BLACK);
		btnLock_10.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_10.setBackground(new Color(0, 128, 128));
		btnLock_10.setBounds(325, 230, 96, 46);
		contentPane.add(btnLock_10);
		
		JButton btnLock_11 = new JButton("");
		btnLock_11.setForeground(Color.BLACK);
		btnLock_11.setFont(new Font("Corbel", Font.BOLD, 11));
		btnLock_11.setBackground(new Color(0, 128, 128));
		btnLock_11.setBounds(431, 230, 96, 46);
		contentPane.add(btnLock_11);
		
		JLabel label = new JLabel("0000000000");
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label.setBounds(18, 55, 88, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("0000000000");
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_1.setBounds(121, 56, 88, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("0000000000");
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_2.setBounds(227, 56, 88, 14);
		contentPane.add(label_2);
		
		//STAR IMAGES 
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/StarsEmpty.png")).getImage();
		img = img.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH); // scale the image when necessary
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(18, 118, 81, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/StarsEmpty.png")).getImage();
		img2 = img2.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH); // scale the image when necessary
		lblNewLabel2.setIcon(new ImageIcon(img2));
		lblNewLabel2.setBounds(120, 118, 81, 27);
		contentPane.add(lblNewLabel2);
		
		JLabel lblNewLabel3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/StarsEmpty.png")).getImage();
		img3 = img3.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH); // scale the image when necessary
		lblNewLabel3.setIcon(new ImageIcon(img3));
		lblNewLabel3.setBounds(225, 118, 81, 27);
		contentPane.add(lblNewLabel3);
	}
}
