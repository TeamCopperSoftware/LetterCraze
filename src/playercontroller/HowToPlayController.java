package playercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Model;
import playerboundary.Application;

/**
 * Prompts instructions for playing LetterCraze Player.
 */

public class HowToPlayController implements ActionListener {

	Application app;
	Model model;

	public HowToPlayController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	public void actionPerformed(ActionEvent ae) {
		JOptionPane.showConfirmDialog(null, 
				"Selecting 'Play Game' takes you to the adventure map menu where you can play 15 levels with three\n" 
				+ "different variations: Puzzle, Lightning, and Theme.\n\n"
				+ "Puzzle: This level type limits your amount of words you can form. Make them count!\n"
				+ "Lightning: This level type limits the time you have, but you can form unlimited words.\n"
				+ "Theme: This level type limits what words you can find. Only words that relate to the theme are allowed.\n\n"
				+ "Selecting words in a level are performed by clicking on letters in the tiles and following that\n"
				+ "tile path till it forms a word. Each tile has to be clicked and must be next to each other either\n"
				+ "across left, right, up, down, or diagonal of preceding tile. Words should also be no less than 3\n"
				+ "letters. Once you selected a valid word by highlighting the letter tiles in yellow in order, press\n"
				+ "the add word button to successfully add a word if valid. Levels can be unlocked one-by-one by achieving\n" 
				+ "at least one star in each level. Custom levels can also be played by going back to the Main Menu and\n"
				+ "selecting 'Play Custom Levels'.\n"
				, "Instructions", JOptionPane.DEFAULT_OPTION);
	}

}
