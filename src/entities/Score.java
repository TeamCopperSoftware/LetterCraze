package entities;

public class Score {

    int star;
    int numScore;

    public Score() {
        star = 0;
        numScore = 0;
    }

    int getStar () {
        return star;
    }

    int getScore () {
        return numScore;
    }

    
    void setStar (int n) {
        star = n;
    }

    void setScore (int n) {
        numScore = n;
    }
  
}
