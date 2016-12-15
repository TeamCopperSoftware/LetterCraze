package entities;

import java.io.Serializable;

/**
 * Represents all entity information for star goals.
 */
public class Goal implements Serializable {
    int star1, star2, star3; //array?, final?

    public Goal(int star1, int star2, int star3) {
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
    }
    
    /**
     * Gets information for star goal one.
     * @return number to reach goal one
     */
    public int getStar1() {
        return star1;
    }

    /**
     * Gets information for star goal two.
     * @return number to reach goal two
     */
    public int getStar2() {
        return star2;
    }
    
    /**
     * Gets information for star goal three.
     * @return number to reach goal three
     */
    public int getStar3() {
        return star3;
    }
    
    /**
     * Sets information for star goal one.
     */
    void setStar1(int n) {
        star1 = n;
    }
    
    /**
     * Sets information for star goal two.
     */
    void setStar2(int n) {
        star2 = n;
    }

    /**
     * Sets information for star goal three.
     */
    void setStar3(int n) {
        star3 = n;
    }

}
