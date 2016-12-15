package playerboundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Stack;

import javax.swing.*;
import entities.*;

/**
 * The containing Frame in all Levels for LetterCraze Player.
 */

public abstract class LevelApplication extends JPanel {
        /** All Player information. */
	LevelModel model;
        /** Button to exit level. */
	JButton exitButton;
	/** Button to confirm. */
	JButton confirmButton;
	/** Buttons for the squares. */
	JButton[][] squareButtons;
	/** Title of game. */
	JLabel titleLabel;
	/** Score of game. */
	JLabel scoreLabel;
	/** Displays either moves left or time left based on the type of level. */
	JLabel objectiveLabel;
	/** Number of moves left. */
	JLabel objectiveValueLabel; // displays moves left
	/** Elements of list. */
	DefaultListModel<String> listModel; // keeps element of list
	/** Words scored. */
	JList<String> wordsList;
	/** Container for wordsList. */
	JScrollPane scrollPane;
	/** Reset button */
	JButton resetButton;
	/** Undo button */
	JButton undoButton;
	/** Contains all the selected buttons of letters. */
	Stack<JButton> selectedButtons;
	/** Label of stars */
	JLabel starLabel;
	/** Progress bar at the bottom of a game. */
	JProgressBar progressBar;
	
	/**
	 * Default constructor for Level Application.
	 * @param m		Model that contains all entity information for levels
	 */
	
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
		titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		titleLabel.setBounds(6, 50, 588, 29);
		leftPanel.add(titleLabel);
		
		// create 36 squareButtons
		squareButtons = new JButton[6][6];
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				JButton b = new JButton();
				b.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				b.setBounds(120+(x*60), 120+(y*60), 60, 60);
				b.setOpaque(true);
				b.setBorderPainted(false);
				b.setBackground(Color.WHITE);
				squareButtons[x][y] = b;
				leftPanel.add(b);
			}
		}
		
		
		scoreLabel = new JLabel("0");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		scoreLabel.setBounds(50, 520, 508, 16);
		leftPanel.add(scoreLabel);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(model.getGoals().getStar3());
		progressBar.setEnabled(false);
		progressBar.setValue(0);
		progressBar.setBounds(50, 547, 400, 20);
		leftPanel.add(progressBar);
		
		starLabel = new JLabel();
		//starLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		starLabel.setBounds(480, 537, 81, 27);
		Image image = new ImageIcon("image/StarsEmpty.png").getImage();
		image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
		starLabel.setIcon(new ImageIcon(image));
		leftPanel.add(starLabel);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
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
		
		objectiveValueLabel = new JLabel("0");
		objectiveValueLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		objectiveValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		objectiveValueLabel.setBounds(6, 60, 188, 40);
		rightPanel.add(objectiveValueLabel);
		
		JLabel wordsLabel = new JLabel("Completed Words:");
		wordsLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		wordsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		wordsLabel.setBounds(15, 130, 170, 16);
		rightPanel.add(wordsLabel);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		resetButton.setBounds(120, 525, 70, 29);
		rightPanel.add(resetButton);
		
		undoButton = new JButton("Undo");
		undoButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		undoButton.setBounds(10, 525, 70, 29);
		rightPanel.add(undoButton);
		
		listModel = new DefaultListModel<String>();
		wordsList = new JList<String>(listModel);
		wordsList.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		scrollPane = new JScrollPane(wordsList);
		scrollPane.setViewportView(wordsList);
		scrollPane.setBounds(15, 150, 170, 360);
		rightPanel.add(scrollPane);
		
		confirmButton = new JButton("Add word");
		confirmButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		confirmButton.setBounds(470, 20, 110, 29);
		leftPanel.add(confirmButton);
		
		selectedButtons = new Stack<JButton>();
	}
	
	/**
	 * Resets all level entities when entering a non-completed level.
	 * @param level		Player level
	 */

	public void refreshPanel(LevelModel level) {

		// set board
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {

				Square s = level.getBoard().lookUpSquare(x, y);
				if (s.isEnabled()) {
					squareButtons[x][y].setVisible(true);
					if (s.hasTile()) {
						squareButtons[x][y].setText(s.tilePeek().toString());
					} else {
						squareButtons[x][y].setText("");
					}
				}
				else {
					squareButtons[x][y].setVisible(false);
				}
			}
		}
		
		// update score
		scoreLabel.setText(String.valueOf(level.getCurrentScore().getScore()));
		
		progressBar.setValue(level.getCurrentScore().getScore());
		
		// update stars
		if (level.getCurrentScore().getStar() == 0) {
			Image image = new ImageIcon("image/StarsEmpty.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		else if (level.getCurrentScore().getStar() == 1) {
			Image image = new ImageIcon("image/StarsOne.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		else if (level.getCurrentScore().getStar() == 2) {
			Image image = new ImageIcon("image/StarsTwo.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		else {
			Image image = new ImageIcon("image/StarsThree.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			starLabel.setIcon(new ImageIcon(image));
		}
		
		
		// deselect panels
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				squareButtons[x][y].setBackground(Color.WHITE);
			}
		}
	}
	
	/**
	 * Gets controllers for Exit Button.
	 * @return Exit button button and controls
	 */
	
	public JButton getExitButton() {
		return exitButton;
	}
	
	/**
	 * Gets Button list.
	 * @return Square Button list for level
	 */
	
	public JButton[][] getButtonList() {
		return squareButtons;
	}
	
	/**
	 * Controls button that confirming a valid word selection of tiles.
	 * @return Frame for confirming word button
	 */
	
	public JButton getConfirmButton() {
		return confirmButton;
	}

	/**
	 * Controls de-selection of tiles if already selected.
	 */
	public void deselectButtons() {
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				squareButtons[x][y].setBackground(Color.WHITE);
			}
		}
	}
	
	/**
	 * Controls keeping element of list
	 * @return Element of list
	 */
	
	public DefaultListModel<String> getListModel() {
		return listModel;
	}
	
	/**
	 * Clears lists of words.
	 */
	
	public void clearList() {
		listModel.clear();
	}

	/**
	 * Updates current score value.
	 * @param change	Number of points achieved from each move
	 */
	
	public void updateObjectiveValue(int change) {
		int currentValue = Integer.parseInt(objectiveValueLabel.getText());
		int newValue = (currentValue + change);
		objectiveValueLabel.setText(String.valueOf(newValue));
	}
	
	/**
	 * Resets value of object.
	 * @param resetTo	Number of points changed from previous move
	 */
	
	public void resetObjectiveValue(int resetTo) {
		objectiveValueLabel.setText(String.valueOf(resetTo));
	}
	
	/**
	 * Increments object value.
	 */
	
	public void incrementObjectiveValue() {
		objectiveValueLabel.setText(String.valueOf(Integer.valueOf(objectiveValueLabel.getText())+1));
	}
	
	/**
	 * Gets controls for reset button.
	 * @return Controls for reset button
	 */
	
	public JButton getResetButton() {
		return resetButton;
	}

	/**
	 * Gets controls for undo button.
	 * @return Controls for undo button
	 */
	
	public JButton getUndoButton() {
		return undoButton;
	}
	
	/**
	 * Gets Level Model information.
	 * @return Level Information from Model
	 */
	
	public LevelModel getLevelModel() {
		return model;
	}
	
	/**
	 * Displays number moves left.
	 * @return Label for Current Score in Level
	 */

	public JLabel getObjectiveValueLabel() {
		return objectiveValueLabel;
	}

	/**
	 * Gets number of moves left.
	 * @return Number of moves left in level
	 */
	
	public int getObjectiveValue() {
		return Integer.parseInt(objectiveValueLabel.getText());
	}

	/**
	 * Gets valid selected tiles.
	 * @return Selected Tiles from User
	 */
	
	public Stack<JButton> getSelectedButtons() {
		return selectedButtons;
	}
	
	/**
	 * Removes recently selected tile if de-selected. 
	 * @return De-selected Tiles from player
	 */
	
	public JButton popSelectedButton() {
		return selectedButtons.pop();
	}
	
	/**
	 * Access to the most recently added letter of selected tiles.
	 * @return Most recent selected tile in selection of tiles
	 */
	
	public JButton peekSelectedButton() {
		return selectedButtons.peek();
	}
	
	/**
	 * Adds a selected tile to the selected tiles.
	 * @param b Selected Button/Tile
	 */
	
	public void pushSelectedButton(JButton b) {
		selectedButtons.push(b);
	}

}
