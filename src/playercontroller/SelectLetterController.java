package playercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import entities.*;
import playerboundary.LevelApplication;

public class SelectLetterController implements ActionListener {
	LevelApplication app;
	LevelModel model;
	int levelNumber;
	int x;
	int y;

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton[][] buttonList = app.getButtonList();
		int numSelected = 0; // 0 are selected by default

		// Check if any buttons are selected
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				if (buttonList[x][y].getBackground().equals(Color.YELLOW)) {
					numSelected++;
					// QU counts as two letters
					if (buttonList[x][y].getText().equals("QU")) {
						numSelected++;
					}
				} 
			}
		}

		// If the button has no tile, do nothing
		if (model.getBoard().lookUpSquare(x, y).hasTile() == false) {
			System.out.println("There's no tile here!");
			return;
		}
		// If the button has a tile...
		else {
			// User should be able to select a button if none are selected (selecting first letter of a word)
			// In the case that no buttons are selected and there are no buttons selected...
			if (numSelected == 0) {
				buttonList[x][y].setBackground(Color.YELLOW);
				model.getBoard().setWord(new Word(model.getBoard().lookUpSquare(x, y)));
				numSelected++;
				// QU counts as two letters
				if (buttonList[x][y].getText().equals("QU")) {
					numSelected++;
				}
				System.out.println(model.getBoard().getWord());
				System.out.println(numSelected);
				app.pushSelectedButton(buttonList[x][y]);
				return;
			}
			// If there is at least one selected square
			else {

				// If the button is the latest selected button we want to deselect it
				if (buttonList[x][y].equals(app.peekSelectedButton())) {
					app.popSelectedButton();
					buttonList[x][y].setBackground(Color.WHITE);
					numSelected--;
					if (buttonList[x][y].getText().equals("QU")) {
						numSelected--;
					}
					model.getBoard().getWord().removeSquare(model.getBoard().lookUpSquare(x, y));
					return;
				}
				
				// Other checks depend on where the button is on the board

				// top left corner
				else if (x == 0 && y == 0) { 
					if (buttonList[x][y].getBackground() == Color.WHITE) {
						if (       (buttonList[x+1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y+1].equals(app.peekSelectedButton()))
								|| (buttonList[x+1][y+1].equals(app.peekSelectedButton())) ) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
						

					

				} 

				// left side
				else if ((x == 0) && (y > 0) && (y < 5)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
						if (       (buttonList[x+1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y-1].equals(app.peekSelectedButton())) 
								|| (buttonList[x][y+1].equals(app.peekSelectedButton()))
								|| (buttonList[x+1][y+1].equals(app.peekSelectedButton()))
								|| (buttonList[x+1][y-1].equals(app.peekSelectedButton()))) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
				}

				// bottom left corner
				else if ((x == 0) && (y == 5)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
						if (       (buttonList[x+1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y-1].equals(app.peekSelectedButton())) 
								|| (buttonList[x+1][y-1].equals(app.peekSelectedButton())) ) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
				}

				// bottom
				else if ((y == 5) && (x > 0) && (x < 5)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
						if (       (buttonList[x-1][y].equals(app.peekSelectedButton())) 
								|| (buttonList[x+1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y-1].equals(app.peekSelectedButton()))
								|| (buttonList[x-1][y-1].equals(app.peekSelectedButton()))
								|| (buttonList[x+1][y-1].equals(app.peekSelectedButton())) ) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
				}

				// bottom right corner
				else if ((x == 5) && (y == 5)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
					if (       (buttonList[x-1][y].equals(app.peekSelectedButton()))
							|| (buttonList[x][y-1].equals(app.peekSelectedButton()))
							|| (buttonList[x-1][y-1].equals(app.peekSelectedButton())) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						app.pushSelectedButton(buttonList[x][y]);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
						if (buttonList[x][y].getText().equals("QU")) {
							numSelected++;
						}
					}
					}
				}

				// right side
				else if ((x == 5) && (y > 0) && (y < 5)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
						if (       (buttonList[x-1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y-1].equals(app.peekSelectedButton())) 
								|| (buttonList[x][y+1].equals(app.peekSelectedButton()))
								|| (buttonList[x-1][y-1].equals(app.peekSelectedButton()))
								|| (buttonList[x-1][y+1].equals(app.peekSelectedButton())) ) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
					
				}

				// top right corner 
				else if ((x == 5) && (y == 0)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
					if (       (buttonList[x-1][y].equals(app.peekSelectedButton())) 
							|| (buttonList[x][y+1].equals(app.peekSelectedButton()))
							|| (buttonList[x-1][y+1].equals(app.peekSelectedButton())) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						app.pushSelectedButton(buttonList[x][y]);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
						if (buttonList[x][y].getText().equals("QU")) {
							numSelected++;
						}
					}
					}
				}

				// top
				else if ((y == 0) && (x > 0) && (x < 5)) {
					if (buttonList[x][y].getBackground() == Color.WHITE) {
						if (       (buttonList[x-1][y].equals(app.peekSelectedButton())) 
								|| (buttonList[x+1][y].equals(app.peekSelectedButton())) 
								|| (buttonList[x][y+1].equals(app.peekSelectedButton()))
								|| (buttonList[x+1][y+1].equals(app.peekSelectedButton()))
								|| (buttonList[x-1][y+1].equals(app.peekSelectedButton())) ) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
				}

				// if the button is anywhere on inside
				else if ((y > 0) && (y < 5) && (x > 0) && (x < 5)){ 
					if (buttonList[x][y].getBackground() == Color.WHITE) {
					// check all surrounding buttons
						if (       (buttonList[x+1][y+1].equals(app.peekSelectedButton())) 
								|| (buttonList[x+1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y+1].equals(app.peekSelectedButton())) 
								|| (buttonList[x-1][y-1].equals(app.peekSelectedButton()))
								|| (buttonList[x-1][y].equals(app.peekSelectedButton()))
								|| (buttonList[x][y-1].equals(app.peekSelectedButton()))
								|| (buttonList[x+1][y-1].equals(app.peekSelectedButton()))
								|| (buttonList[x-1][y+1].equals(app.peekSelectedButton())) ) {
							// change button to selected
							buttonList[x][y].setBackground(Color.YELLOW);
							app.pushSelectedButton(buttonList[x][y]);
							model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
							numSelected++;
							if (buttonList[x][y].getText().equals("QU")) {
								numSelected++;
							}
						}
					}
					
				}
				
				// button is already selected, but it is in the middle of a word so do nothing
				// don't think this ever actually is executed
				else {
					System.out.println("Can't deselect this square!");
					return;
				}




			}
		}



		System.out.println(model.getBoard().getWord());
		System.out.println(numSelected);
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton[][] buttonList = app.getButtonList();
		int numSelected = 0; // 0 are selected by default

		// Check if any buttons are selected
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				if (buttonList[x][y].getBackground().equals(Color.YELLOW)) {
					numSelected++;
				} 
			}
		}
		
		// If the button has no tile, do nothing
		if (model.getBoard().lookUpSquare(x, y).hasTile() == false) {
			System.out.println("There's no tile here!");
			return;
		}

		// If the button is selected, deselect it
		if (buttonList[x][y].getBackground().equals(Color.YELLOW)) {
			buttonList[x][y].setBackground(Color.WHITE);
			numSelected--;
			return;
		}

		// User should be able to select a button if none are selected (selecting first letter of a word)
		// In the case that no buttons are selected and there are no buttons selected...
		if (numSelected == 0) {
			buttonList[x][y].setBackground(Color.YELLOW);
			model.getBoard().setWord(new Word(model.getBoard().lookUpSquare(x, y)));
			numSelected++;
			System.out.println(model.getBoard().getWord());
			System.out.println(numSelected);
			return;
		}

		// If at least one letter is selected, we need to check if it has a neighbor that is selected
		if (numSelected > 0) {

			// top left corner
			if (x == 0 && y == 0) { 
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x+1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y+1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x+1][y+1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}

				}

			} 

			// left side
			else if ((x == 0) && (y > 0) && (y < 5)) {
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x+1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y-1].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x][y+1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x+1][y+1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x+1][y-1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}
				}
			}

			// bottom left corner
			else if ((x == 0) && (y == 5)) {
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x+1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y-1].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x+1][y-1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}
				} 
			}

			// bottom
			else if ((y == 5) && (x > 0) && (x < 5)) {
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x-1][y].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x+1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y-1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x-1][y-1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x+1][y-1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}
				} 
			}

			// bottom right corner
			else if ((x == 5) && (y == 5)) {
				if (       (buttonList[x-1][y].getBackground().equals(Color.YELLOW))
						|| (buttonList[x][y-1].getBackground().equals(Color.YELLOW))
						|| (buttonList[x-1][y-1].getBackground().equals(Color.YELLOW)) ) {
					// change button to selected
					buttonList[x][y].setBackground(Color.YELLOW);
					model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
					numSelected++;
				}
			}

			// right side
			else if ((x == 5) && (y > 0) && (y < 5)) {
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x-1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y-1].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x][y+1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x-1][y-1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x-1][y+1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}
				}
			}

			// top right corner 
			else if ((x == 5) && (y == 0)) {
				if (       (buttonList[x-1][y].getBackground().equals(Color.YELLOW)) 
						|| (buttonList[x][y+1].getBackground().equals(Color.YELLOW))
						|| (buttonList[x-1][y+1].getBackground().equals(Color.YELLOW)) ) {
					// change button to selected
					buttonList[x][y].setBackground(Color.YELLOW);
					model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
					numSelected++;
				}
			}

			// top
			else if ((y == 0) && (x > 0) && (x < 5)) {
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x-1][y].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x+1][y].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x][y+1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x+1][y+1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x-1][y+1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}
				}
			}

			// if the button is anywhere on inside
			else { 
				// check all surrounding buttons
				if (buttonList[x][y].getBackground().equals(Color.WHITE)) {
					if (       (buttonList[x+1][y+1].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x+1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y+1].getBackground().equals(Color.YELLOW)) 
							|| (buttonList[x-1][y-1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x-1][y].getBackground().equals(Color.YELLOW))
							|| (buttonList[x][y-1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x+1][y-1].getBackground().equals(Color.YELLOW))
							|| (buttonList[x-1][y+1].getBackground().equals(Color.YELLOW)) ) {
						// change button to selected
						buttonList[x][y].setBackground(Color.YELLOW);
						model.getBoard().getWord().appendSquare(model.getBoard().lookUpSquare(x, y));
						numSelected++;
					}
				}
			}

		}

		System.out.println(model.getBoard().getWord());
		System.out.println(numSelected);
	}
	*/

	public SelectLetterController(LevelApplication app, LevelModel m, int levelNumber, int x, int y) {
		this.app = app;
		this.model = m;
		this.levelNumber = levelNumber;
		this.x = x;
		this.y = y;
	}
}
