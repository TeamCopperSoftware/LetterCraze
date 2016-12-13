package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents all entity information for Builder Model.
 */

public class BuilderModel implements Serializable {
	
	/** All levels that are saved. */
	ArrayList<LevelModel> savedLevels;
	/** All levels that are published. */
	ArrayList<LevelModel> publishedLevels;
	
	/** 
	 * Constructs Builder Model.
	 */	
	public BuilderModel() {
		savedLevels = new ArrayList<LevelModel>();
		publishedLevels = new ArrayList<LevelModel>();
		
	}
	
	/** 
	 * Gets information for Saved Levels.
	 */	
	public ArrayList<LevelModel> getSavedLevels() {
		return savedLevels;
	}
	
	/** 
	 * Gets information for Published Levels.
	 */
	public ArrayList<LevelModel> getPublishedLevels() {
		return publishedLevels;
	}

}
