package playercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import entities.LevelModel;
import entities.*;
import playerboundary.Application;

public class SelectLetterController implements ActionListener {
	Application app;
	Model model;
	int x;
	int y;
	//PuzzleLevel level = (PuzzleLevel)model.getMainLevels().getLevels().get(1);
	Word currentWord;

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton[][] buttonList = app.getPuzzleLevelApplication().getButtonList();
		int numSelected = 0; // 0 are selected by default

		// Check if any buttons are selected
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				if (buttonList[x][y].getBackground().equals(Color.YELLOW)) {
					numSelected++;
				} 
			}

		}

		// If the button is selected, deselect it
		if (buttonList[x][y].getBackground().equals(Color.YELLOW)) {
			buttonList[x][y].setBackground(Color.WHITE);
			return;
		}

		// User should be able to select a button if none are selected (selecting first letter of a word)
		// In the case that no buttons are selected and there are no buttons selected...
		if (numSelected == 0) {
			buttonList.get(buttonNumber).setBackground(Color.YELLOW);
			currentWord = new Word(model.getMainLevels().getLevels().get(0).getBoard().lookUpSquare(x, y))
		}

		// If at least one letter is selected, we need to check if it has a neighbor that is selected
		if (numSelected > 0) {

			// top left corner
			if (buttonNumber == 0) { 
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber + 1).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 6).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 7).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}

				}

			} 

			// left side
			else if ((buttonNumber == 6) || (buttonNumber == 12) || (buttonNumber == 18) || (buttonNumber == 24)) {
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber + 1).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 6).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 6).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 7).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 5).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}
				}
			}

			// bottom left corner
			else if ((buttonNumber == 30)) {
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber + 1).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 6).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber - 5).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}
				} 
			}

			// bottom
			else if ((buttonNumber == 31) || (buttonNumber == 32) || (buttonNumber == 33) || (buttonNumber == 34)) {
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber - 1).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 1).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 6).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 7).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 5).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}
				} 
			}

			// bottom right corner
			else if (buttonNumber == 35) {
				if (       (buttonList.get(buttonNumber - 1).getBackground().equals(Color.YELLOW))
						|| (buttonList.get(buttonNumber - 6).getBackground().equals(Color.YELLOW))
						|| (buttonList.get(buttonNumber - 7).getBackground().equals(Color.YELLOW)) ) {
					// change button to selected
					buttonList.get(buttonNumber).setBackground(Color.YELLOW);
				}
			}

			// right side
			else if ((buttonNumber == 11) || (buttonNumber == 17) || (buttonNumber == 23) || (buttonNumber == 29)) {
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber - 1).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 6).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 6).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 7).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 5).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}
				}
			}

			// top right corner 
			else if (buttonNumber == 5) {
				if (       (buttonList.get(buttonNumber - 1).getBackground().equals(Color.YELLOW)) 
						|| (buttonList.get(buttonNumber + 6).getBackground().equals(Color.YELLOW))
						|| (buttonList.get(buttonNumber + 5).getBackground().equals(Color.YELLOW)) ) {
					// change button to selected
					buttonList.get(buttonNumber).setBackground(Color.YELLOW);
				}
			}

			else if ((buttonNumber == 1) || (buttonNumber == 2) || (buttonNumber == 3) || (buttonNumber == 4)) {
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber - 1).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 1).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 6).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 7).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 5).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}
				}
			}

			// if the button is anywhere on inside
			else { 
				// check all surrounding buttons
				if (buttonList.get(buttonNumber).getBackground().equals(Color.WHITE)) {
					if (       (buttonList.get(buttonNumber - 1).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 1).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 6).getBackground().equals(Color.YELLOW)) 
							|| (buttonList.get(buttonNumber + 6).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 7).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 7).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber - 5).getBackground().equals(Color.YELLOW))
							|| (buttonList.get(buttonNumber + 5).getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList.get(buttonNumber).setBackground(Color.YELLOW);
					}
				}
			}

		}
	}

	public SelectLetterController(Application app, Model m, int x, int y) {
		this.app = app;
		this.model = m;
		this.x = x;
		this.y = y;
	}
}
