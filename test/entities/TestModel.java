package entities;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestModel extends TestCase {

	public void testDefaultLvls() {
		Model model = new Model();
		ArrayList<LevelModel> levels = new ArrayList<LevelModel>();
		assertNotSame(model.getMainLevels(), levels);  //assert has some levels
		//Note: I'd make this more specific if we weren't going to be hardcoding more levels
		//This at least assserts that SOME levels are there an it vaguely initialized
	}
	
}
