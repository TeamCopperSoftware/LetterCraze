package entities;

import java.util.ArrayList;

public class Model {

	Map mainLevels; // main levels are stored in a map in order to keep track of player's progress
	ArrayList<LevelModel> customLevels; // custom levels are always unlocked so they can be stored in an ArrayList

	// creates default levels and organizes them into a Map
	public Model() {		

		setMainLevels(new Map());
		customLevels = new ArrayList<LevelModel>();
		initializeDefaultLevels();
		importCustomLevels();
		
	}
	
	public void initializeDefaultLevels() {
		
		Square[] squaresArray = new Square[36];
		
		// Create Level 1
		squaresArray[0] = new Square(new Position(0,0), true);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), true);

		squaresArray[6] = new Square(new Position(0,1), true);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), true);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), false);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), true);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), false);
		squaresArray[22] = new Square(new Position(4,3), false);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), true);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), false);
		squaresArray[27] = new Square(new Position(3,4), false);
		squaresArray[28] = new Square(new Position(4,4), false);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), true);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), false);
		squaresArray[33] = new Square(new Position(3,5), false);
		squaresArray[34] = new Square(new Position(4,5), false);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b1 = new Board(squaresArray);
		Goal g1 = new Goal(15, 25, 35);
		int moveLimit = 3;

		PuzzleLevel l1 = new PuzzleLevel(b1, g1, moveLimit);
		l1.isUnlocked = true; // first three levels should be unlocked
		getMainLevels().addLevel(l1);

		// Create Level 2
		squaresArray[0] = new Square(new Position(0,0), true);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), true);

		squaresArray[6] = new Square(new Position(0,1), true);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), true);

		squaresArray[12] = new Square(new Position(0,2), true);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), true);

		squaresArray[18] = new Square(new Position(0,3), true);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), true);

		squaresArray[24] = new Square(new Position(0,4), true);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), true);

		squaresArray[30] = new Square(new Position(0,5), true);
		squaresArray[31] = new Square(new Position(1,5), true);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), true);
		squaresArray[35] = new Square(new Position(5,5), true);

		Board b2 = new Board(squaresArray);
		Goal g2 = new Goal(25, 35, 50);
		int timeLimit1 = 120; // seconds?

		LightningLevel l2 = new LightningLevel(b2, g2, timeLimit1);
		l2.isUnlocked = true; // first three levels should be unlocked
		getMainLevels().addLevel(l2);

		// Create Level 3
		
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("N"));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("C"));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("R"));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("A"));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("N"));
		squaresArray[5] = new Square(new Position(5,0), false);
		
		/* uncomment if you want to test QU
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("QU"));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("E"));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("E"));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("N"));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("N"));
		squaresArray[5] = new Square(new Position(5,0), false);
		*/

		squaresArray[6] = new Square(new Position(0,1), true, new Tile("O"));
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("O"));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("N"));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("E"));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("N"));
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("E"));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("I"));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("B"));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("I"));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("K"));
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("L"));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("N"));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("K"));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("M"));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("P"));

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("A"));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("O"));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("U"));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("P"));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("K"));
		squaresArray[33] = new Square(new Position(3,5), false);
		squaresArray[34] = new Square(new Position(4,5), false);
		squaresArray[35] = new Square(new Position(5,5), false);
		
		Board b3 = new Board(squaresArray);
		Goal g3 = new Goal(3, 4, 5);
		String theme1 = "Vegetables";
		ArrayList<String> words1 = new ArrayList<String>();
		words1.add("bean");
		words1.add("corn");
		words1.add("kale");
		words1.add("onion");
		words1.add("pumpkin");
		/* uncomment if you want to test QU
		words1.add("queen");
		words1.add("quo");
		*/

		ThemeLevel l3 = new ThemeLevel(b3, g3, theme1, words1);
		l3.isUnlocked = true; // first three levels should be unlocked
		getMainLevels().addLevel(l3);
		
		// Create Level 4
		squaresArray[0] = new Square(new Position(0,0), false);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), true);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), true);

		squaresArray[18] = new Square(new Position(0,3), true);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), true);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), true);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), true);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b4 = new Board(squaresArray);
		Goal g4 = new Goal(50, 100, 150);
		int moveLimit2 = 10;

		PuzzleLevel l4 = new PuzzleLevel(b4, g4, moveLimit2);
		l4.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l4);
		
		// Create Level 5
		squaresArray[0] = new Square(new Position(0,0), true);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), false);
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), false);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), true);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), true);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), true);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), false);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), true);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), true);
		squaresArray[35] = new Square(new Position(5,5), true);

		Board b5 = new Board(squaresArray);
		Goal g5 = new Goal(25, 35, 50);
		int timeLimit2 = 120; // seconds

		LightningLevel l5 = new LightningLevel(b5, g5, timeLimit2);
		l5.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l5);
		
		// Create Level 6
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("T"));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("A"));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("T"));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("I"));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("A"));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("S"));

		squaresArray[6] = new Square(new Position(0,1), true, new Tile("L"));
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("A"));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("R"));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("I"));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("N"));
		squaresArray[11] = new Square(new Position(5,1), true, new Tile("O"));

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("A"));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("N"));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("N"));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("C"));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("D"));
		squaresArray[17] = new Square(new Position(5,2), true, new Tile("U"));

		squaresArray[18] = new Square(new Position(0,3), true, new Tile("I"));
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("T"));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("P"));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("A"));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("I"));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("T"));

		squaresArray[24] = new Square(new Position(0,4), true, new Tile("C"));
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("A"));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("C"));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("I"));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("H"));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("F"));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("I"));
		squaresArray[34] = new Square(new Position(4,5), true, new Tile("C"));
		squaresArray[35] = new Square(new Position(5,5), false);
		
		Board b6 = new Board(squaresArray);
		Goal g6 = new Goal(3, 4, 5);
		String theme2 = "Oceans";
		ArrayList<String> words2 = new ArrayList<String>();
		words2.add("atlantic");
		words2.add("artic");
		words2.add("indian");
		words2.add("pacific");
		words2.add("south");

		ThemeLevel l6 = new ThemeLevel(b6, g6, theme2, words2);
		l6.isUnlocked = false; // locked
		getMainLevels().addLevel(l6);
		
		// Create Level 7
		squaresArray[0] = new Square(new Position(0,0), false);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), true);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), true);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b7 = new Board(squaresArray);
		Goal g7 = new Goal(50, 100, 150);
		int moveLimit3 = 10;

		PuzzleLevel l7 = new PuzzleLevel(b7, g7, moveLimit3);
		l7.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l7);		
		
		// Create Level 8
		squaresArray[0] = new Square(new Position(0,0), false);
		squaresArray[1] = new Square(new Position(1,0), false);
		squaresArray[2] = new Square(new Position(2,0), false);
		squaresArray[3] = new Square(new Position(3,0), false);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), true);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), false);
		squaresArray[8] = new Square(new Position(2,1), false);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), true);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), false);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), true);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), true);

		squaresArray[24] = new Square(new Position(0,4), true);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), true);

		squaresArray[30] = new Square(new Position(0,5), true);
		squaresArray[31] = new Square(new Position(1,5), true);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), true);
		squaresArray[35] = new Square(new Position(5,5), true);

		Board b8 = new Board(squaresArray);
		Goal g8 = new Goal(25, 35, 50);
		int timeLimit3 = 120; // seconds

		LightningLevel l8 = new LightningLevel(b8, g8, timeLimit3);
		l8.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l8);

		// Create Level 9
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("L"));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("B"));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("O"));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("N"));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("H"));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("R"));

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("I"));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("E"));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("I"));
		squaresArray[10] = new Square(new Position(4,1), false);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("O"));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("N"));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("A"));
		squaresArray[16] = new Square(new Position(4,2), false);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), false);
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("R"));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("N"));
		squaresArray[22] = new Square(new Position(4,3), false);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("P"));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("A"));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("D"));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("A"));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), true, new Tile("H"));
		squaresArray[31] = new Square(new Position(1,5), true, new Tile("I"));
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("S"));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("F"));
		squaresArray[34] = new Square(new Position(4,5), false);
		squaresArray[35] = new Square(new Position(5,5), false);
		
		Board b9 = new Board(squaresArray);
		Goal g9 = new Goal(3, 4, 5);
		String theme3 = "Animals";
		ArrayList<String> words3 = new ArrayList<String>();
		words3.add("bear");
		words3.add("fish");
		words3.add("lion");
		words3.add("rhino");
		words3.add("panda");

		ThemeLevel l9 = new ThemeLevel(b9, g9, theme3, words3);
		l6.isUnlocked = false; // locked
		getMainLevels().addLevel(l9);
		
		// Create Level 10
		squaresArray[0] = new Square(new Position(0,0), false);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), false);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), false);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), false);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), false);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), false);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b10 = new Board(squaresArray);
		Goal g10 = new Goal(50, 100, 150);
		int moveLimit4 = 10;

		PuzzleLevel l10 = new PuzzleLevel(b10, g10, moveLimit4);
		l10.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l10);		
		
		// Create Level 11
		squaresArray[0] = new Square(new Position(0,0), true);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), true);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), false);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), false);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), false);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b11 = new Board(squaresArray);
		Goal g11 = new Goal(25, 35, 50);
		int timeLimit4 = 120; // seconds

		LightningLevel l11 = new LightningLevel(b11, g11, timeLimit4);
		l11.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l11);
		
		// Create Level 12
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("H"));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("S"));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("O"));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("C"));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("G"));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("F"));

		squaresArray[6] = new Square(new Position(0,1), true, new Tile("O"));
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("C"));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("C"));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("O"));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("L"));
		squaresArray[11] = new Square(new Position(5,1), true, new Tile("T"));

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("E"));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("K"));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("E"));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("R"));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("N"));
		squaresArray[17] = new Square(new Position(5,2), true, new Tile("E"));

		squaresArray[18] = new Square(new Position(0,3), true, new Tile("B"));
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("Y"));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("I"));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("S"));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("I"));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("N"));

		squaresArray[24] = new Square(new Position(0,4), true, new Tile("O"));
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("X"));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("N"));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("N"));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("G"));
		squaresArray[29] = new Square(new Position(5,4), true, new Tile("B"));

		squaresArray[30] = new Square(new Position(0,5), true, new Tile("G"));
		squaresArray[31] = new Square(new Position(1,5), true, new Tile("N"));
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("I"));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("L"));
		squaresArray[34] = new Square(new Position(4,5), true, new Tile("W"));
		squaresArray[35] = new Square(new Position(5,5), true, new Tile("O"));
		
		Board b12 = new Board(squaresArray);
		Goal g12 = new Goal(4, 5, 6);
		String theme4 = "Sports";
		ArrayList<String> words4 = new ArrayList<String>();
		words4.add("boxing");
		words4.add("tennis");
		words4.add("bowling");
		words4.add("golf");
		words4.add("soccer");
		words4.add("hockey");
		
		ThemeLevel l12 = new ThemeLevel(b12, g12, theme4, words4);
		l12.isUnlocked = false; // locked
		getMainLevels().addLevel(l12);
		
		// Create Level 13
		squaresArray[0] = new Square(new Position(0,0), false);
		squaresArray[1] = new Square(new Position(1,0), false);
		squaresArray[2] = new Square(new Position(2,0), true);
		squaresArray[3] = new Square(new Position(3,0), true);
		squaresArray[4] = new Square(new Position(4,0), false);
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), false);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), false);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), false);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), false);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true);
		squaresArray[33] = new Square(new Position(3,5), true);
		squaresArray[34] = new Square(new Position(4,5), false);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b13 = new Board(squaresArray);
		Goal g13 = new Goal(50, 100, 150);
		int moveLimit5 = 10;

		PuzzleLevel l13 = new PuzzleLevel(b13, g13, moveLimit5);
		l13.isUnlocked = false; 
		getMainLevels().addLevel(l13);		
		
		// Create Level 14
		squaresArray[0] = new Square(new Position(0,0), false);
		squaresArray[1] = new Square(new Position(1,0), true);
		squaresArray[2] = new Square(new Position(2,0), false);
		squaresArray[3] = new Square(new Position(3,0), false);
		squaresArray[4] = new Square(new Position(4,0), true);
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true);
		squaresArray[8] = new Square(new Position(2,1), true);
		squaresArray[9] = new Square(new Position(3,1), true);
		squaresArray[10] = new Square(new Position(4,1), true);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), true);
		squaresArray[14] = new Square(new Position(2,2), true);
		squaresArray[15] = new Square(new Position(3,2), true);
		squaresArray[16] = new Square(new Position(4,2), true);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true);
		squaresArray[20] = new Square(new Position(2,3), true);
		squaresArray[21] = new Square(new Position(3,3), true);
		squaresArray[22] = new Square(new Position(4,3), true);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true);
		squaresArray[26] = new Square(new Position(2,4), true);
		squaresArray[27] = new Square(new Position(3,4), true);
		squaresArray[28] = new Square(new Position(4,4), true);
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), true);
		squaresArray[32] = new Square(new Position(2,5), false);
		squaresArray[33] = new Square(new Position(3,5), false);
		squaresArray[34] = new Square(new Position(4,5), true);
		squaresArray[35] = new Square(new Position(5,5), false);

		Board b14 = new Board(squaresArray);
		Goal g14 = new Goal(25, 35, 50);
		int timeLimit5 = 120; // seconds

		LightningLevel l14 = new LightningLevel(b14, g14, timeLimit5);
		l14.isUnlocked = false; // first three levels should be unlocked
		getMainLevels().addLevel(l14);
		
		// Create Level 15
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("T"));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("P"));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("R"));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("S"));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("A"));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("S"));

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("I"));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("C"));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("S"));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("A"));
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("J"));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("A"));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("S"));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("W"));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("L"));
		squaresArray[17] = new Square(new Position(5,2), true, new Tile("I"));

		squaresArray[18] = new Square(new Position(0,3), true, new Tile("A"));
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("V"));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("A"));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("I"));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("E"));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("S"));

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("A"));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("V"));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("F"));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("T"));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), true, new Tile("J"));
		squaresArray[31] = new Square(new Position(1,5), true, new Tile("L"));
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("L"));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("E"));
		squaresArray[34] = new Square(new Position(4,5), true, new Tile("H"));
		squaresArray[35] = new Square(new Position(5,5), true, new Tile("S"));
		
		Board b15 = new Board(squaresArray);
		Goal g15 = new Goal(3, 4, 5);
		String theme5 = "CS Languages";
		ArrayList<String> words5 = new ArrayList<String>();
		words5.add("java");
		words5.add("lisp");
		words5.add("sass");
		words5.add("javascript");
		words5.add("swift");
		
		ThemeLevel l15 = new ThemeLevel(b15, g15, theme5, words5);
		l15.isUnlocked = false; // locked 
		getMainLevels().addLevel(l15);
	
	}

	public void importCustomLevels() {
		// looks for custom level files, creates Level objects, adds them to list
		
		// This level is just a placeholder
		PuzzleLevel l1 = (PuzzleLevel)mainLevels.getLevels().get(0);
		customLevels.add(l1);
		
		// all custom levels should always be unlocked
		int numCustomLevels = customLevels.size();
		for (int i = 0; i < numCustomLevels; i++) {
			customLevels.get(i).isUnlocked = true;
		}
	}

	public Map getMainLevels() {
		return mainLevels;
	}
	
	public ArrayList<LevelModel> getCustomLevels() {
		return customLevels;
	}

	public void setMainLevels(Map mainLevels) {
		this.mainLevels = mainLevels;
	}

}


