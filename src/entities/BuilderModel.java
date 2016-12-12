package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class BuilderModel implements Serializable {
	
	ArrayList<LevelModel> savedLevels;
	ArrayList<LevelModel> publishedLevels;
	
	public BuilderModel() {
		savedLevels = new ArrayList<LevelModel>();
		publishedLevels = new ArrayList<LevelModel>();
		
		// this level is just a placeholder to test stuff displays correctly
		Square[] squares = new Square[36];
		int i = 0;
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				squares[i] = new Square(new Position(x, y), true);
				i++;
			}
		}
		Board b = new Board(squares);
		Goal g = new Goal(5, 10, 15);
		savedLevels.add(new PuzzleLevel(b, g, 5)); 
	}
	
	public ArrayList<LevelModel> getSavedLevels() {
		return savedLevels;
	}
	
	public ArrayList<LevelModel> getPublishedLevels() {
		return publishedLevels;
	}

}
