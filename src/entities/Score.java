package entities;

import java.io.Serializable;

/**
 * Represents all entity information for score.
 */

public class Score implements Serializable {

    /** Number of stars currently achieved in level. */
    int star;
    /** Current score number. */
    int numScore;

    /**
     * Constructs Score.
     */
    public Score() {
        this.star = 0;
        this.numScore = 0;

    }

    /**
     * Updates score based on points received.
     * @param change    changes score by given value
     */
    public void updateScore(int change) {
        numScore +=change;
    }

    /**
     * Retrieves number of stars.
     * @return numbre of stars achieved in a level
     */
    public int getStar () {
        return star;
    }

    /**
     * Retrieves score number.
     * @return     returns numScore.
     */
    public int getScore () {
        return numScore;
    }

    /**
     * Sets number of stars.
     * @param n		number of stars achieved
     */
    public void setStar (int n) {
        star = n;
    }

    /**
     * Sets score number.
     * @param n		total number of points achieved
     */
    public void setScore (int n) {
        numScore = n;
    }

}
