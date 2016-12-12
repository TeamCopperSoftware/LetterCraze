package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents all entity information for Level maps.
 */
public class Map implements Serializable {

	/** All levels on the map. */
    ArrayList<LevelModel> levels;
	/** Keeps track of how many levels are unlocked. */
    int numUnlockedLevels; // probably should keep track of how many levels are locked/unlocked

    /**
     * Constructor for creating Map objects in Model Class.
     */
    public Map() {
        levels = new ArrayList<LevelModel>();
    }

	/** 
	 * Constructs Adventure Map.
	 * 
	 * @param levels    All 15 premade levels from model
	 */
    // probably don't need this constructor
    public Map(ArrayList<LevelModel> levels) {
        this.levels = levels;
    }

    /**
     * Adds level to the map.
     */
    public void addLevel(LevelModel level) {
        levels.add(level);
    }

    /**
     *  Removes level from the map.
     */
    public void removeLevel(int levelNumber) {
        levels.remove(levelNumber);
    }

    /**
     * Checks conditions and verifies whether level is unlocked.
     */
    public boolean unlockNextLevel() {
        //TODO
        // 1) check whether conditions are met for the next locked level to be unlocked
        // 2) if they are met unlock the level and update numUnlocked levels
        
        
        //java.util.Iterator<LevelModel> iter = levels.iterator();

        for (int i = 1; i < levels.size(); i++) {
            if (levels.get(i-1).getBestScore().getStar() >= 1 && !levels.get(i).isUnlocked) {
                levels.get(i).unlock();
                return true;
            }
        }
        
        
        return false;
    }

    /**
     * Retrieves Levels to be accessed in map.
     */
    public ArrayList<LevelModel> getLevels() {
        return levels;
    }

}
