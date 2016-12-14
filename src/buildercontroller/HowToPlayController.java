package buildercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import entities.BuilderModel;
import builderboundary.Application;

/**
 * Prompts instructions for playing LetterCraze Builder.
 * <p>
 */

public class HowToPlayController implements ActionListener {

	Application app;
	BuilderModel model;

	public HowToPlayController(BuilderModel model, Application app) {
		this.app = app;
		this.model = model;
	}

	public void actionPerformed(ActionEvent ae) {
		JOptionPane.showConfirmDialog(null, 
				"LetterCraze Builder allows you to customize your own LetterCraze\n"
						+ "levels and import them to LetterCraze player.\n"
						+ "\n"
						+ "To create a new level, click on 'Create New Level' on the main menu. From here you \n"
						+ "can select/deselect the tiles placement on the level board, select the type of \n"
						+ "level, set star goals, and set goals based on the level type you choose. To select \n"
						+ "star goals, enter the number based on the type of level you desire to make. Puzzle \n"
						+ "is number of moves, Lightning is time, and Theme is words completed. To select a level \n"
						+ "type, click on the drop down box on the top right and select the level you wish to make. \n"
						+ "For puzzle, you must select the number of moves a player can make. For lightning, you \n"
						+ "must select the amount of time the player has to complete the level. For theme, you must \n"
						+ "add a theme description, a list of words (at least more than or equal to three letters) \n"
						+ "that match the theme description and must manually add them for each tile placement. \n"
						+ "Once you have entered all of your information, click the 'Save Level' below the tiles \n"
						+ "to save your level.\n"
						+ "\n"
						+ "To edit a saved level, head back to the main menu and click on 'Edit Saved Level'. From here \n"
						+ "you can navigate through a map of all the levels you saved based on when you saved them. Order \n"
						+ "of levels saved goes left to right from oldest to newest level saved. Click on the level you wish \n"
						+ "to edit and continue to work on the level from there. If you wish to delete a level, click on the \n"
						+ "icon located on the top left of each level button. To publish your saved levels to LetterCraze player, \n"
						+ "click the 'Publish Levels to LetterCraze' button on the top right corner of the screen. Doing this will \n"
						+ "published all of your levels that were saved to LetterCraze Player under Custom Levels for you and your \n"
						+ "friends to play. If you forget to publish them, builder will publish them once you quit the application.\n"
						+ "\n"
						+ "Enjoy!" , 
						"Instructions", JOptionPane.DEFAULT_OPTION);
	}

}