package entities;

import java.util.ArrayList;

public class Model {
	
	Map mainLevels; // main levels are stored in a map in order to keep track of player's progress
	ArrayList<LevelModel> customLevels; // custom levels are always unlocked so they can be stored in an ArrayList
	
	public Model() {		
		// creates default levels and organizes them into a Map
	}
	
	public void importCustomLevels() {
		// looks for custom level files, creates Level objects, adds them to list
	}

}


