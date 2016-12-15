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
    public Map(ArrayList<LevelModel> levels) {
        this.levels = levels;
    }

    /**
     * Adds level to the map.
     * @param level 	LevelModel information
     */
    public void addLevel(LevelModel level) {
        levels.add(level);
    }

    /**
     *  Removes level from the map.
     *  @param levelNumber 	Level Number
     */
    public void removeLevel(int levelNumber) {
        levels.remove(levelNumber);
    }

    /**
     * Checks conditions and verifies whether level is unlocked.
     * @return 		valid unlock to next level
     */
    public boolean unlockNextLevel() {

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
     * @return List of Levels on the map
     */
    public ArrayList<LevelModel> getLevels() {
        return levels;
    }

}
