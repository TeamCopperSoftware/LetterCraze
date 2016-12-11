package entities;

import java.io.Serializable;

public class Goal implements Serializable {
    int star1, star2, star3; //array?, final?

    public Goal(int star1, int star2, int star3) {
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
    }
    
    public int getStar1() {
        return star1;
    }
    public int getStar2() {
        return star2;
    }
    public int getStar3() {
        return star3;
    }
    
    void setStar1(int n) {
        star1 = n;
    }
    void setStar2(int n) {
        star2 = n;
    }
    void setStar3(int n) {
        star3 = n;
    }

}
