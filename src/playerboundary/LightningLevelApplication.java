package playerboundary;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LightningLevelApplication extends JPanel {

	/**
	 * Create the panel.
	 */
	public LightningLevelApplication() {
		setBounds(0,0,800,600);
		setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 600, 600);
		add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Lightning");
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setBounds(6, 6, 288, 22);
		leftPanel.add(titleLabel);
		
		JButton square1 = new JButton("A");
		square1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square1.setBounds(40, 30, 36, 36);
		leftPanel.add(square1);
		
		JButton square2 = new JButton("A");
		square2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square2.setBounds(76, 30, 36, 36);
		leftPanel.add(square2);
		
		JButton square3 = new JButton("A");
		square3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square3.setBounds(112, 30, 36, 36);
		leftPanel.add(square3);
		
		JButton square4 = new JButton("A");
		square4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square4.setBounds(148, 30, 36, 36);
		leftPanel.add(square4);
		
		JButton square5 = new JButton("A");
		square5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square5.setBounds(184, 30, 36, 36);
		leftPanel.add(square5);
		
		JButton square6 = new JButton("A");
		square6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square6.setBounds(220, 30, 36, 36);
		leftPanel.add(square6);
		
		JButton square7 = new JButton("A");
		square7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square7.setBounds(40, 66, 36, 36);
		leftPanel.add(square7);
		
		JButton square8 = new JButton("A");
		square8.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square8.setBounds(76, 66, 36, 36);
		leftPanel.add(square8);
		
		JButton square9 = new JButton("A");
		square9.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square9.setBounds(112, 66, 36, 36);
		leftPanel.add(square9);
		
		JButton square10 = new JButton("A");
		square10.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square10.setBounds(148, 66, 36, 36);
		leftPanel.add(square10);
		
		JButton square11 = new JButton("A");
		square11.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square11.setBounds(184, 66, 36, 36);
		leftPanel.add(square11);
		
		JButton square12 = new JButton("A");
		square12.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square12.setBounds(220, 66, 36, 36);
		leftPanel.add(square12);
		
		JButton square13 = new JButton("A");
		square13.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square13.setBounds(40, 102, 36, 36);
		leftPanel.add(square13);
		
		JButton square14 = new JButton("A");
		square14.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square14.setBounds(76, 102, 36, 36);
		leftPanel.add(square14);
		
		JButton square15 = new JButton("A");
		square15.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square15.setBounds(112, 102, 36, 36);
		leftPanel.add(square15);
		
		JButton square16 = new JButton("A");
		square16.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square16.setBounds(148, 102, 36, 36);
		leftPanel.add(square16);
		
		JButton square17 = new JButton("A");
		square17.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square17.setBounds(184, 102, 36, 36);
		leftPanel.add(square17);
		
		JButton square18 = new JButton("A");
		square18.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square18.setBounds(220, 102, 36, 36);
		leftPanel.add(square18);
		
		JButton square19 = new JButton("A");
		square19.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square19.setBounds(40, 138, 36, 36);
		leftPanel.add(square19);
		
		JButton square20 = new JButton("A");
		square20.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square20.setBounds(76, 138, 36, 36);
		leftPanel.add(square20);
		
		JButton square21 = new JButton("A");
		square21.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square21.setBounds(112, 138, 36, 36);
		leftPanel.add(square21);
		
		JButton square22 = new JButton("A");
		square22.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square22.setBounds(148, 138, 36, 36);
		leftPanel.add(square22);
		
		JButton square23 = new JButton("A");
		square23.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square23.setBounds(184, 138, 36, 36);
		leftPanel.add(square23);
		
		JButton square24 = new JButton("A");
		square24.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square24.setBounds(220, 138, 36, 36);
		leftPanel.add(square24);
		
		JButton square25 = new JButton("A");
		square25.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square25.setBounds(40, 174, 36, 36);
		leftPanel.add(square25);
		
		JButton square26 = new JButton("A");
		square26.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square26.setBounds(76, 174, 36, 36);
		leftPanel.add(square26);
		
		JButton square27 = new JButton("A");
		square27.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square27.setBounds(112, 174, 36, 36);
		leftPanel.add(square27);
		
		JButton square28 = new JButton("A");
		square28.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square28.setBounds(148, 174, 36, 36);
		leftPanel.add(square28);
		
		JButton square29 = new JButton("A");
		square29.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square29.setBounds(184, 174, 36, 36);
		leftPanel.add(square29);
		
		JButton square30 = new JButton("A");
		square30.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square30.setBounds(220, 174, 36, 36);
		leftPanel.add(square30);
		
		JButton square31 = new JButton("A");
		square31.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square31.setBounds(40, 210, 36, 36);
		leftPanel.add(square31);
		
		JButton square32 = new JButton("A");
		square32.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square32.setBounds(76, 210, 36, 36);
		leftPanel.add(square32);
		
		JButton square33 = new JButton("A");
		square33.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square33.setBounds(112, 210, 36, 36);
		leftPanel.add(square33);
		
		JButton square34 = new JButton("A");
		square34.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square34.setBounds(148, 210, 36, 36);
		leftPanel.add(square34);
		
		JButton square35 = new JButton("A");
		square35.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square35.setBounds(184, 210, 36, 36);
		leftPanel.add(square35);
		
		JButton square36 = new JButton("A");
		square36.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		square36.setBounds(220, 210, 36, 36);
		leftPanel.add(square36);
		
		JLabel scoreLabel = new JLabel("Score: 3333");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		scoreLabel.setBounds(6, 258, 288, 16);
		leftPanel.add(scoreLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(10000);
		progressBar.setEnabled(false);
		progressBar.setValue(3333);
		progressBar.setBounds(6, 274, 229, 20);
		leftPanel.add(progressBar);
		
		JLabel starLabel = new JLabel("StarIcons");
		starLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		starLabel.setBounds(236, 274, 58, 16);
		leftPanel.add(starLabel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setBounds(600, 0, 200, 600);
		add(rightPanel);
		rightPanel.setLayout(null);
		
		JButton quitButton = new JButton("Exit");
		quitButton.setBounds(74, 6, 70, 29);
		rightPanel.add(quitButton);
		
		JLabel objectiveLabel = new JLabel("Time Left:");
		objectiveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		objectiveLabel.setBounds(6, 40, 138, 16);
		rightPanel.add(objectiveLabel);
		
		JLabel objectiveValueLabel = new JLabel("1:30");
		objectiveValueLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		objectiveValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		objectiveValueLabel.setBounds(6, 60, 138, 16);
		rightPanel.add(objectiveValueLabel);
		
		JLabel wordsLabel = new JLabel("Completed Words:");
		wordsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordsLabel.setBounds(6, 85, 138, 16);
		rightPanel.add(wordsLabel);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		resetButton.setBounds(74, 265, 70, 29);
		rightPanel.add(resetButton);
		
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		undoButton.setBounds(6, 265, 70, 29);
		rightPanel.add(undoButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 107, 138, 138);
		rightPanel.add(scrollPane);
		
		JList wordsList = new JList();
		scrollPane.setViewportView(wordsList);
		wordsList.setModel(new AbstractListModel() {
			String[] values = new String[] {"this", "area", "is", "where", "all", "of", "the", "completed", "words", "will", "go"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});

	}
}
