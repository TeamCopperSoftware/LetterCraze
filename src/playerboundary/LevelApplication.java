package playerboundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import entities.LevelModel;
import entities.PuzzleLevel;
import entities.Square;

public abstract class LevelApplication extends JPanel {
	
	LevelModel model;
	JButton exitButton;
	JButton[][] squareButtons;
	JLabel titleLabel;
	JLabel objectiveLabel;
	JLabel objectiveValueLabel; // displays moves left
	
	public LevelApplication(LevelModel m) {
		model = m;
		
		setBounds(0,0,800,600);
		this.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 600, 600);
		leftPanel.setLayout(null);
		add(leftPanel);
		
		titleLabel = new JLabel("");
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		titleLabel.setBounds(6, 50, 588, 29);
		leftPanel.add(titleLabel);
		
		// create 36 squareButtons
		squareButtons = new JButton[6][6];
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				JButton b = new JButton();
				b.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
				b.setBounds(120+(x*60), 120+(y*60), 60, 60);
				b.setOpaque(true);
				b.setBackground(Color.WHITE);
				squareButtons[x][y] = b;
				leftPanel.add(b);
			}
		}
		
		
		JLabel scoreLabel = new JLabel("Score: 3333");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		scoreLabel.setBounds(50, 520, 508, 16);
		leftPanel.add(scoreLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(10000);
		progressBar.setEnabled(false);
		progressBar.setValue(3333);
		progressBar.setBounds(50, 547, 438, 20);
		leftPanel.add(progressBar);
		
		JLabel starLabel = new JLabel("StarIcons");
		starLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		starLabel.setBounds(500, 547, 58, 16);
		leftPanel.add(starLabel);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(20, 20, 70, 29);
		leftPanel.add(exitButton);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setBounds(600, 0, 200, 600);
		rightPanel.setLayout(null);

		add(rightPanel);
		
		objectiveLabel = new JLabel("");
		objectiveLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		objectiveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		objectiveLabel.setBounds(6, 40, 188, 16);
		rightPanel.add(objectiveLabel);
		
		objectiveValueLabel = new JLabel("");
		objectiveValueLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		objectiveValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		objectiveValueLabel.setBounds(6, 60, 188, 40);
		rightPanel.add(objectiveValueLabel);
		
		JLabel wordsLabel = new JLabel("Completed Words:");
		wordsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		wordsLabel.setBounds(15, 130, 170, 16);
		rightPanel.add(wordsLabel);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		resetButton.setBounds(120, 560, 70, 29);
		rightPanel.add(resetButton);
		
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		undoButton.setBounds(10, 560, 70, 29);
		rightPanel.add(undoButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 150, 170, 360);
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
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmButton.setBounds(63, 520, 70, 29);
		rightPanel.add(confirmButton);

	
	}

	public void refreshPanel(LevelModel level) {

		// set board
		int currentSquare = 0;
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {

				Square s = level.getBoard().lookUpSquare(x, y);
				if (s.isEnabled()) {
					squareButtons[x][y].setVisible(true);
					if (s.hasTile()) {
						squareButtons[x][y].setText(s.tilePeek().toString());
					}
				}
				else {
					squareButtons[x][y].setVisible(false);
				}

				currentSquare++;
			}
		}

	}
	
	public JButton getExitButton() {
		return exitButton;
	}
	
	public JButton[][] getButtonList() {
		return squareButtons;
	}

}
