package entities;

public class Score {

    int star;
    int numScore;

    public Score() {
        star = 0;
        numScore = 0;
    }

    public int getStar () {
        return star;
    }

    public int getScore () {
        return numScore;
    }

    
    public void setStar (int n) {
        star = n;
    }

    public void setScore (int n) {
        numScore = n;
    }
  
}
