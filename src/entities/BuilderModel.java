package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class BuilderModel implements Serializable {
	
	ArrayList<LevelModel> savedLevels;
	ArrayList<LevelModel> publishedLevels;
	
	public BuilderModel() {
		savedLevels = new ArrayList<LevelModel>();
		publishedLevels = new ArrayList<LevelModel>();
	}

}
