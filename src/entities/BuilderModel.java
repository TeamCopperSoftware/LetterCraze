package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents all entity information for Builder Model.
 */

public class BuilderModel implements Serializable {
	
	/** All levels that are saved. */
	ArrayList<LevelModel> savedLevels;
	
	/** 
	 * Constructs Builder Model.
	 */	
	public BuilderModel() {
		savedLevels = new ArrayList<LevelModel>();
		
	}
	
	/** 
	 * Gets information for Saved Levels.
	 */	
	public ArrayList<LevelModel> getSavedLevels() {
		return savedLevels;
	}
	
	public void setSavedLevels(ArrayList<LevelModel> levels) {
		savedLevels = levels;
	}


}
