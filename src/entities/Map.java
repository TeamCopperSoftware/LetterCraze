package entities;

import java.util.ArrayList;

public class Map {
	
	ArrayList<LevelModel> levels;
	int numUnlockedLevels; // probably should keep track of how many levels are locked/unlocked
	
	// this is the constructor used when creating Map object in Model class
	public Map() {
		levels = new ArrayList<LevelModel>();
	}
	
	// probably don't need this constructor
	public Map(ArrayList<LevelModel> levels) {
		this.levels = levels;
	}
	
	public void addLevel(LevelModel level) {
		levels.add(level);
	}
	
	public void removeLevel(int levelNumber) {
		levels.remove(levelNumber);
	}
	
	public boolean unlockNextLevel() {
		// 1) check whether conditions are met for the next locked level to be unlocked
		// 2) if they are met unlock the level and update numUnlocked levels
		
		return false;
	}
	
	public ArrayList<LevelModel> getLevels() {
		return levels;
	}

}
