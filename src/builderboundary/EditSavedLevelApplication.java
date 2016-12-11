package builderboundary;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import entities.BuilderModel;
import entities.Model;

import java.awt.Color;

public class EditSavedLevelApplication extends JPanel {

	BuilderModel model;
	JPanel cards;
	JButton backButton;

	public EditSavedLevelApplication(BuilderModel model2) {
		model = model2;
		setLayout(null);
		setBounds(0, 0, 800, 600);

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

		JButton square1 = new JButton("");
		square1.setBounds(0, 0, 60, 60);
		boardSquares.add(square1);

		JButton square2 = new JButton("");
		square2.setBounds(60, 0, 60, 60);
		boardSquares.add(square2);

		JButton square3 = new JButton("");
		square3.setBounds(120, 0, 60, 60);
		boardSquares.add(square3);

		JButton square4 = new JButton("");
		square4.setBounds(180, 0, 60, 60);
		boardSquares.add(square4);

		JButton square5 = new JButton("");
		square5.setBounds(240, 0, 60, 60);
		boardSquares.add(square5);

		JButton square6 = new JButton("");
		square6.setBounds(300, 0, 60, 60);
		boardSquares.add(square6);

		JButton square7 = new JButton("");
		square7.setBounds(0, 60, 60, 60);
		boardSquares.add(square7);

		JButton square8 = new JButton("");
		square8.setBounds(60, 60, 60, 60);
		boardSquares.add(square8);

		JButton square9 = new JButton("");
		square9.setBounds(120, 60, 60, 60);
		boardSquares.add(square9);

		JButton square10 = new JButton("");
		square10.setBounds(180, 60, 60, 60);
		boardSquares.add(square10);

		JButton square11 = new JButton("");
		square11.setBounds(240, 60, 60, 60);
		boardSquares.add(square11);

		JButton square12 = new JButton("");
		square12.setBounds(300, 60, 60, 60);
		boardSquares.add(square12);

		JButton square13 = new JButton("");
		square13.setBounds(0, 120, 60, 60);
		boardSquares.add(square13);

		JButton square14 = new JButton("");
		square14.setBounds(60, 120, 60, 60);
		boardSquares.add(square14);

		JButton square15 = new JButton("");
		square15.setBounds(120, 120, 60, 60);
		boardSquares.add(square15);

		JButton square16 = new JButton("");
		square16.setBounds(180, 120, 60, 60);
		boardSquares.add(square16);

		JButton square17 = new JButton("");
		square17.setBounds(240, 120, 60, 60);
		boardSquares.add(square17);

		JButton square18 = new JButton("");
		square18.setBounds(300, 120, 60, 60);
		boardSquares.add(square18);

		JButton square19 = new JButton("");
		square19.setBounds(0, 180, 60, 60);
		boardSquares.add(square19);

		JButton square20 = new JButton("");
		square20.setBounds(60, 180, 60, 60);
		boardSquares.add(square20);

		JButton square21 = new JButton("");
		square21.setBounds(120, 180, 60, 60);
		boardSquares.add(square21);

		JButton square22 = new JButton("");
		square22.setBounds(180, 180, 60, 60);
		boardSquares.add(square22);

		JButton square23 = new JButton("");
		square23.setBounds(240, 180, 60, 60);
		boardSquares.add(square23);

		JButton square24 = new JButton("");
		square24.setBounds(300, 180, 60, 60);
		boardSquares.add(square24);

		JButton square25 = new JButton("");
		square25.setBounds(0, 240, 60, 60);
		boardSquares.add(square25);

		JButton square26 = new JButton("");
		square26.setBounds(60, 240, 60, 60);
		boardSquares.add(square26);

		JButton square27 = new JButton("");
		square27.setBounds(120, 240, 60, 60);
		boardSquares.add(square27);

		JButton square28 = new JButton("");
		square28.setBounds(180, 240, 60, 60);
		boardSquares.add(square28);

		JButton square29 = new JButton("");
		square29.setBounds(240, 240, 60, 60);
		boardSquares.add(square29);

		JButton square30 = new JButton("");
		square30.setBounds(300, 240, 60, 60);
		boardSquares.add(square30);

		JButton square31 = new JButton("");
		square31.setBounds(0, 300, 60, 60);
		boardSquares.add(square31);

		JButton square32 = new JButton("");
		square32.setBounds(60, 300, 60, 60);
		boardSquares.add(square32);

		JButton square33 = new JButton("");
		square33.setBounds(120, 300, 60, 60);
		boardSquares.add(square33);

		JButton square34 = new JButton("");
		square34.setBounds(180, 300, 60, 60);
		boardSquares.add(square34);

		JButton square35 = new JButton("");
		square35.setBounds(240, 300, 60, 60);
		boardSquares.add(square35);

		JButton square36 = new JButton("");
		square36.setBounds(300, 300, 60, 60);
		boardSquares.add(square36);

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

		JSpinner numMovesSpinner = new JSpinner();
		numMovesSpinner.setBounds(134, 34, 60, 28);
		puzzlePanel.add(numMovesSpinner);

		JPanel lightningPanel = new JPanel();
		cards.add(lightningPanel, "Lightning");
		lightningPanel.setLayout(null);

		JLabel timeLabel = new JLabel("Time Allowed (secs):");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(6, 6, 188, 16);
		lightningPanel.add(timeLabel);

		JSpinner timeSpinner = new JSpinner();
		timeSpinner.setBounds(134, 34, 60, 28);
		lightningPanel.add(timeSpinner);

		JPanel themePanel = new JPanel();
		cards.add(themePanel, "Theme");
		themePanel.setLayout(null);

		JLabel themeLabel = new JLabel("Theme:");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setBounds(6, 6, 188, 16);
		themePanel.add(themeLabel);

		JTextField textField = new JTextField();
		textField.setBounds(6, 34, 188, 28);
		themePanel.add(textField);
		textField.setColumns(10);

		JLabel lblWords = new JLabel("Words:");
		lblWords.setHorizontalAlignment(SwingConstants.CENTER);
		lblWords.setBounds(6, 75, 188, 16);
		themePanel.add(lblWords);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(6, 103, 134, 28);
		themePanel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(144, 103, 50, 29);
		themePanel.add(btnNewButton);

		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(6, 143, 188, 247);
		themePanel.add(list);

		// code inside here magically changes view depending on whether "Puzzle", "Lightning", or "Theme" is selected
		// this should maybe be separated out into a new controller class?
		JComboBox gameModeComboBox = new JComboBox();
		gameModeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, (String)e.getItem());
				//System.out.print((String)e.getItem());
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

		JSpinner starGoal1Spinner = new JSpinner();
		starGoal1Spinner.setBounds(134, 67, 60, 28);
		settingsPanel.add(starGoal1Spinner);

		JSpinner starGoal2Spinner = new JSpinner();
		starGoal2Spinner.setBounds(134, 95, 60, 28);
		settingsPanel.add(starGoal2Spinner);

		JSpinner starGoal3Spinner = new JSpinner();
		starGoal3Spinner.setBounds(134, 123, 60, 28);
		settingsPanel.add(starGoal3Spinner);

		JButton btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(120, 520, 170, 37);
		add(btnSaveLevel);

		JButton btnPublishToLettercraze = new JButton("Publish to LetterCraze");
		btnPublishToLettercraze.setBounds(310, 520, 170, 37);
		add(btnPublishToLettercraze);
	}

	public JButton getBackButton() {
		return backButton;
	}
}
