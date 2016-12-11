package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class BuilderModel implements Serializable {
	
	ArrayList<LevelModel> savedLevels;
	ArrayList<LevelModel> publishedLevels;
	
	public BuilderModel() {
		savedLevels = new ArrayList<LevelModel>();
		publishedLevels = new ArrayList<LevelModel>();
		savedLevels.add(new PuzzleLevel(null, null, 5)); // this is just a placeholder to test stuff displays correctly
	}
	
	public ArrayList<LevelModel> getSavedLevels() {
		return savedLevels;
	}
	
	public ArrayList<LevelModel> getPublishedLevels() {
		return publishedLevels;
	}

}
