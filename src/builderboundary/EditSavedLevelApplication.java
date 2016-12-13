package builderboundary;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entities.BuilderModel;
import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.Position;
import entities.PuzzleLevel;
import entities.Square;
import entities.ThemeLevel;
import entities.Tile;

/**
 * The containing Frame for editing a saved level.
 */

public class EditSavedLevelApplication extends JPanel {

	BuilderModel model;
	JPanel cards;
	JButton backButton;
	JButton addWordButton;
	JButton deleteWordButton;
	JButton[][] squaresArray;
	JComboBox[][] lettersArray;
	JButton btnSaveLevel;
	String levelType;

	JSpinner starGoal1Spinner;
	JSpinner starGoal2Spinner;
	JSpinner starGoal3Spinner;
	JSpinner numMovesSpinner;
	JSpinner timeSpinner;
	JList wordList;
	DefaultListModel listModel;
	JTextField wordField;
	JTextField themeField;
	JComboBox gameModeComboBox;
	JLabel levelNameLabel;

	int levelNumber;

	public EditSavedLevelApplication(BuilderModel model2, int levelNumber) {

		this.model = model2;
		this.levelNumber = levelNumber;

		setLayout(null);
		setBounds(0, 0, 800, 600);

		levelType = "Puzzle";
		backButton = new JButton("Back");
		backButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		backButton.setBounds(10, 10, 75, 29);

		JPanel boardSquares = new JPanel();
		boardSquares.setBounds(120, 120, 360, 360);
		this.add(boardSquares);
		boardSquares.setLayout(null);

		squaresArray = new JButton[6][6];
		lettersArray = new JComboBox[6][6];
		//        char[][] charArray = new char[squaresArray.length][squaresArray[0].length];

		for (int x = 0; x < squaresArray.length; x++) {
			for (int y = 0; y < squaresArray[x].length; y++) {
				squaresArray[x][y] = new JButton(" ");
				squaresArray[x][y].setOpaque(true);
				squaresArray[x][y].setBounds(60*x, 60*y, 60, 60);
				boardSquares.add(squaresArray[x][y]);

				lettersArray[x][y] = new JComboBox<String>();
				lettersArray[x][y].addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {

					}
				});
				lettersArray[x][y].setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "QU", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));

				lettersArray[x][y].setMaximumRowCount(10);
				lettersArray[x][y].setBounds(60*x, 60*y+30, 60, 30);
				lettersArray[x][y].setOpaque(true);
				lettersArray[x][y].setBackground(Color.WHITE);
				lettersArray[x][y].setVisible(false);
				boardSquares.add(lettersArray[x][y]);

			}
		}


		this.add(backButton);

		JPanel settingsPanel = new JPanel();
		settingsPanel.setBounds(600, 0, 200, 600);
		this.add(settingsPanel);
		settingsPanel.setLayout(null);

		cards = new JPanel();
		cards.setBounds(0, 157, 200, 421);
		settingsPanel.add(cards);
		cards.setLayout(new CardLayout(0, 0));

		JPanel puzzlePanel = new JPanel();
		cards.add(puzzlePanel, "Puzzle");
		puzzlePanel.setLayout(null);

		JLabel numMovesLabel = new JLabel("Number of Moves Allowed:");
		numMovesLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		numMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numMovesLabel.setBounds(6, 6, 188, 16);
		puzzlePanel.add(numMovesLabel);

		numMovesSpinner = new JSpinner();
		numMovesSpinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		numMovesSpinner.setBounds(134, 34, 60, 28);
		numMovesSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		puzzlePanel.add(numMovesSpinner);

		JPanel lightningPanel = new JPanel();
		cards.add(lightningPanel, "Lightning");
		lightningPanel.setLayout(null);

		JLabel timeLabel = new JLabel("Time Allowed (secs):");
		timeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(6, 6, 188, 16);
		lightningPanel.add(timeLabel);

		timeSpinner = new JSpinner();
		timeSpinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		timeSpinner.setBounds(134, 34, 60, 28);
		timeSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		lightningPanel.add(timeSpinner);

		JPanel themePanel = new JPanel();
		cards.add(themePanel, "Theme");
		themePanel.setLayout(null);

		JLabel themeLabel = new JLabel("Theme:");
		themeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setBounds(6, 6, 188, 16);
		themePanel.add(themeLabel);

		themeField = new JTextField();
		themeField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		themeField.setBounds(6, 34, 188, 28);
		themePanel.add(themeField);
		themeField.setColumns(10);

		JLabel lblWords = new JLabel("Words:");
		lblWords.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblWords.setHorizontalAlignment(SwingConstants.CENTER);
		lblWords.setBounds(6, 75, 188, 16);
		themePanel.add(lblWords);

		wordField = new JTextField();
		wordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		wordField.setBounds(6, 103, 188, 28);
		themePanel.add(wordField);
		wordField.setColumns(10);

		addWordButton = new JButton("Add");
		addWordButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		addWordButton.setBounds(6, 135, 90, 29);
		themePanel.add(addWordButton);

		deleteWordButton = new JButton("Delete");
		deleteWordButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		deleteWordButton.setBounds(108, 135, 86, 29);
		themePanel.add(deleteWordButton);

		listModel = new DefaultListModel();
		wordList = new JList(listModel);
		wordList.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		wordList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		wordList.setBounds(6, 172, 188, 218);
		themePanel.add(wordList);


		gameModeComboBox = new JComboBox();
		gameModeComboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));

		/* created GameModeSelectionController to do this
        gameModeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, (String)e.getItem());
                levelType = (String)e.getItem();
                //System.out.println("Leveltype: " + levelType);

            }
        });
		 */
		gameModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
		gameModeComboBox.setMaximumRowCount(3);
		gameModeComboBox.setBounds(6, 34, 188, 27);
		settingsPanel.add(gameModeComboBox);

		JLabel gameModeLabel = new JLabel("Game Mode:");
		gameModeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		gameModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameModeLabel.setBounds(6, 6, 188, 27);
		settingsPanel.add(gameModeLabel);

		JLabel starGoal1Label = new JLabel("Star 1 Goal:");
		starGoal1Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal1Label.setBounds(6, 73, 72, 16);
		settingsPanel.add(starGoal1Label);

		JLabel starGoal2Label = new JLabel("Star 2 Goal:");
		starGoal2Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal2Label.setBounds(6, 101, 72, 16);
		settingsPanel.add(starGoal2Label);

		JLabel starGoal3Label = new JLabel("Star 3 Goal:");
		starGoal3Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal3Label.setBounds(6, 129, 72, 16);
		settingsPanel.add(starGoal3Label);

		starGoal1Spinner = new JSpinner();
		starGoal1Spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal1Spinner.setBounds(134, 67, 60, 28);
		starGoal1Spinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

		settingsPanel.add(starGoal1Spinner);

		starGoal2Spinner = new JSpinner();
		starGoal2Spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal2Spinner.setBounds(134, 95, 60, 28);
		starGoal2Spinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

		settingsPanel.add(starGoal2Spinner);

		starGoal3Spinner = new JSpinner();
		starGoal3Spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal3Spinner.setBounds(134, 123, 60, 28);
		starGoal3Spinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

		settingsPanel.add(starGoal3Spinner);

		btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnSaveLevel.setBounds(120, 520, 360, 37);
		add(btnSaveLevel);

		levelNameLabel = new JLabel("");
		levelNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		levelNameLabel.setBounds(120, 78, 360, 30);
		add(levelNameLabel);

		JLabel lblLevelYouAre = new JLabel("You are working on:");
		lblLevelYouAre.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblLevelYouAre.setBounds(120, 50, 200, 16);
		add(lblLevelYouAre);



	}

	public void resetPanel() {
		LevelModel l = model.getSavedLevels().get(levelNumber);

		levelNameLabel.setText("Custom Level " + String.valueOf(levelNumber+1));
		starGoal1Spinner.setValue(l.getGoals().getStar1());
		starGoal2Spinner.setValue(l.getGoals().getStar2());
		starGoal3Spinner.setValue(l.getGoals().getStar3());
		listModel.clear();

		if (l.getType().equals("Puzzle")) {
			gameModeComboBox.setSelectedIndex(0);
			numMovesSpinner.setValue(((PuzzleLevel)l).getMoveLimit());
		}
		else if (l.getType().equals("Lightning")) {
			gameModeComboBox.setSelectedIndex(1);
			timeSpinner.setValue(((LightningLevel)l).getTimeLimit());

		}
		else if (l.getType().equals("Theme")) {
			gameModeComboBox.setSelectedIndex(2);
			themeField.setText(((ThemeLevel)l).getTheme());
			ArrayList<String> words = ((ThemeLevel)l).getValidWords();
			for (String s: words) {
				listModel.addElement(s);
			}

		}
		int i = 0;
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				if (l.getBoard().lookUpSquare(x, y).isEnabled()) {
					squaresArray[x][y].setBackground(Color.WHITE);
					squaresArray[x][y].setBounds(60*x, 60*y, 60, 60);
					if (l.getType().equals("Theme")) {
						squaresArray[x][y].setBounds(60*x, 60*y, 60, 30);
						lettersArray[x][y].setVisible(true);
						lettersArray[x][y].setSelectedItem(l.getBoard().lookUpSquare(x,y).tilePeek().getLetter());
					}

				}
				else {
					squaresArray[x][y].setBounds(60*x, 60*y, 60, 60);
					squaresArray[x][y].setBackground(null);
					lettersArray[x][y].setVisible(false);
					lettersArray[x][y].setSelectedItem("A");
					if (l.getType().equals("Theme")) {
						lettersArray[x][y].setSelectedItem(l.getBoard().lookUpSquare(x,y).tilePeek().getLetter());
					}
				}
			}
		}


	}

	public JButton getBackButton() {
		return backButton;
	}

	public JButton[][] getSquareButtons() {
		return squaresArray;
	}

	public JComboBox[][] getLetterBoxes() {
		return lettersArray;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String type) {
		this.levelType = type;
	}

	public int[] getStarGoals() {
		int[] goals = new int[3];
		goals[0] = (int)starGoal1Spinner.getValue();
		goals[1] = (int)starGoal2Spinner.getValue();
		goals[2] = (int)starGoal3Spinner.getValue();
		return goals;
	}

	public JButton getSaveButton() {
		return btnSaveLevel;
	}

	public JList getWordList() {
		return wordList;
	}

	public JButton getAddWordButton() {
		return addWordButton;
	}

	public JButton getDeleteWordButton() {
		return deleteWordButton;
	}

	public JSpinner getTimeSpinner() {
		return timeSpinner;
	}

	public JSpinner getNumMovesSpinner() {
		return numMovesSpinner;
	}

	public JTextField getThemeField() {
		return themeField;
	}

	public JTextField getWordField() {
		return wordField;
	}

	public DefaultListModel getDefaultListModel() {
		return listModel;
	}

	public JLabel getLevelNameLabel() {
		return levelNameLabel;	
	}
	public JPanel getCards() {
		return cards;
	}

	public JComboBox getGameModeComboBox() {
		return gameModeComboBox;
	}
}