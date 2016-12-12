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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entities.BuilderModel;
import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;

public class EditSavedLevelApplication extends JPanel {

    BuilderModel model;
    JPanel cards;
    JButton backButton;
    JButton addWordButton;
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
    
    int levelNumber;

    public EditSavedLevelApplication(BuilderModel model2, int levelNumber) {
    	
        this.model = model2;
        this.levelNumber = levelNumber;
        
        LevelModel l = model.getSavedLevels().get(levelNumber);
        
        setLayout(null);
        setBounds(0, 0, 800, 600);

        levelType = "Puzzle";
        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 75, 29);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        nameLabel.setBounds(120, 50, 74, 37);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        nameTextField.setBounds(196, 50, 284, 37);
        nameTextField.setToolTipText("Gives your level a name");
        nameTextField.setColumns(1);

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
                squaresArray[x][y].setBounds(60*x, 60*y, 60, 30);
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
        this.add(nameLabel);
        this.add(nameTextField);

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
        numMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numMovesLabel.setBounds(6, 6, 188, 16);
        puzzlePanel.add(numMovesLabel);

        numMovesSpinner = new JSpinner();
        numMovesSpinner.setBounds(134, 34, 60, 28);
        puzzlePanel.add(numMovesSpinner);

        JPanel lightningPanel = new JPanel();
        cards.add(lightningPanel, "Lightning");
        lightningPanel.setLayout(null);

        JLabel timeLabel = new JLabel("Time Allowed (secs):");
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBounds(6, 6, 188, 16);
        lightningPanel.add(timeLabel);

        timeSpinner = new JSpinner();
        timeSpinner.setBounds(134, 34, 60, 28);
        lightningPanel.add(timeSpinner);

        JPanel themePanel = new JPanel();
        cards.add(themePanel, "Theme");
        themePanel.setLayout(null);

        JLabel themeLabel = new JLabel("Theme:");
        themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        themeLabel.setBounds(6, 6, 188, 16);
        themePanel.add(themeLabel);

        themeField = new JTextField();
        themeField.setBounds(6, 34, 188, 28);
        themePanel.add(themeField);
        themeField.setColumns(10);

        JLabel lblWords = new JLabel("Words:");
        lblWords.setHorizontalAlignment(SwingConstants.CENTER);
        lblWords.setBounds(6, 75, 188, 16);
        themePanel.add(lblWords);

        wordField = new JTextField();
        wordField.setBounds(6, 103, 134, 28);
        themePanel.add(wordField);
        wordField.setColumns(10);

        addWordButton = new JButton("Add");
        addWordButton.setBounds(144, 103, 50, 29);
        themePanel.add(addWordButton);

        listModel = new DefaultListModel();
        wordList = new JList(listModel);
        wordList.setBorder(new LineBorder(new Color(0, 0, 0)));
        wordList.setBounds(6, 143, 188, 247);
        themePanel.add(wordList);

        // code inside here magically changes view depending on whether "Puzzle", "Lightning", or "Theme" is selected
        // this should maybe be separated out into a new controller class?
        JComboBox gameModeComboBox = new JComboBox();
        gameModeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, (String)e.getItem());
                levelType = (String)e.getItem();
                //System.out.println("Leveltype: " + levelType);
                
            }
        });
        gameModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
        gameModeComboBox.setMaximumRowCount(3);
        gameModeComboBox.setBounds(6, 34, 188, 27);
        settingsPanel.add(gameModeComboBox);

        JLabel gameModeLabel = new JLabel("Game Mode:");
        gameModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameModeLabel.setBounds(6, 6, 188, 27);
        settingsPanel.add(gameModeLabel);

        JLabel starGoal1Label = new JLabel("Star 1 Goal:");
        starGoal1Label.setBounds(6, 73, 72, 16);
        settingsPanel.add(starGoal1Label);

        JLabel starGoal2Label = new JLabel("Star 2 Goal:");
        starGoal2Label.setBounds(6, 101, 72, 16);
        settingsPanel.add(starGoal2Label);

        JLabel starGoal3Label = new JLabel("Star 3 Goal:");
        starGoal3Label.setBounds(6, 129, 72, 16);
        settingsPanel.add(starGoal3Label);

        starGoal1Spinner = new JSpinner();
        starGoal1Spinner.setBounds(134, 67, 60, 28);
        starGoal1Spinner.setValue(l.getGoals().getStar1());
        settingsPanel.add(starGoal1Spinner);

        starGoal2Spinner = new JSpinner();
        starGoal2Spinner.setBounds(134, 95, 60, 28);
        starGoal2Spinner.setValue(l.getGoals().getStar2());
        settingsPanel.add(starGoal2Spinner);

        starGoal3Spinner = new JSpinner();
        starGoal3Spinner.setBounds(134, 123, 60, 28);
        starGoal3Spinner.setValue(l.getGoals().getStar3());
        settingsPanel.add(starGoal3Spinner);

        btnSaveLevel = new JButton("Save Level");
        btnSaveLevel.setBounds(120, 520, 170, 37);
        add(btnSaveLevel);

        JButton btnPublishToLettercraze = new JButton("Publish to LetterCraze");
        btnPublishToLettercraze.setBounds(310, 520, 170, 37);
        add(btnPublishToLettercraze);
        
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
    
    public int[] getStarGoals() {
    	int[] goals = new int[3];
    	goals[0] = (int)starGoal3Spinner.getValue();
    	goals[1] = (int)starGoal3Spinner.getValue();
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
    
    public JSpinner getTimeSpinner() {
    	return timeSpinner;
    }
    
    public JSpinner getNumMovesSpinner() {
    	return numMovesSpinner;
    }
    
    public JTextField getThemeField() {
    	return themeField;
    }
}