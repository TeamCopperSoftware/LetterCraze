package entities;

public class Score {

    int star;
    int numScore;
    int firstStarGoalScore;
    int secondStarGoalScore;
    int thirdStarGoalScore;
       
    public Score(int firstStarGoalScore, int secondStarGoalScore, int thirdStarGoalScore) {
        this.star = 0;
        this.numScore = 0;
        this.firstStarGoalScore = firstStarGoalScore;
        this.secondStarGoalScore = secondStarGoalScore;
        this.thirdStarGoalScore = thirdStarGoalScore;
    
    }
    
	public int updateScore(int change) {
		return numScore +=change;
	}
	
	public int updateStar() {
		if(numScore >= thirdStarGoalScore) {
			star = 3; 
		}
		else if(numScore >= secondStarGoalScore) {
			star = 2; 
		}
		else if(numScore >= firstStarGoalScore) {
			star = 1; 
		}
		else { 
			star = 0; 
		}
		return star;
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
