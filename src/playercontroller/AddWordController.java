package playercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import entities.*;
import playerboundary.LevelApplication;

public class AddWordController implements ActionListener {
	LevelApplication app;
	public LevelModel model;

	public void actionPerformed(ActionEvent ae) {
		Word wordObject = model.getBoard().getWord();

		if (model.getBoard().getWord().isValid()) {
			Move move = new Move(wordObject, model);
			move.doMove();
			model.pushToHistory(move);
			
			// add word to list of found words
			app.getListModel().addElement(wordObject.toString());
			
			// decrement objectiveView if it is puzzle
			if (model.getType().equals("Puzzle")) {
				app.updateObjectiveValue(-1);
			}

			// decrement objectiveView if it is theme
			if (model.getType().equals("Theme")) {
				app.updateObjectiveValue(-1);
			}
			
			// (HACK) set the current word to a placeholder that isn't valid
			// this is to make sure you can't keep playing the same word without making a new selection
			model.getBoard().setWord(new Word(new Square(new Position(0, 0), false, new Tile(""))));
		}

		// refresh board and update numScore
		app.refreshPanel(model);

	}

	public AddWordController(LevelApplication app, LevelModel model) {
		this.app = app;
		this.model = model;
	}


}
