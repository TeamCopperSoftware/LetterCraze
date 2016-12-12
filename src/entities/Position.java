package entities;

import java.io.Serializable;

/**
 * Represents all entity information for position of tile(s).
 */

public class Position implements Serializable {
	/** Location of tiles. */
	private int x, y;
    
	/**
	 * Constructor for position.
	 * 
	 * @param x horizontal distance
	 * @param y vertical distance
	 */
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Updates vertical distance of tile(s).
     */
    void updateY (int y) {
        this.y = y;
    } 
    
    /**
     * Updates horizontal distance of tile(s).
     */
    void updateX (int x) {
        this.x = x;
    }
    
    /**
     * Retrieves horizontal distance of tile(s).
     */
    int getX () {
        return x;
    }
    
    /**
     * Retrieves vertical distance of tile(s).
     */
    int getY() {
        return y;
    }
}
