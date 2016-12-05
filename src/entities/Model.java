package entities;

import java.util.ArrayList;

public class Model {

	private Map mainLevels; // main levels are stored in a map in order to keep track of player's progress
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
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("W", 1));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("O", 1));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("R", 1));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("D", 1));
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
		Goal g1 = new Goal(1000, 2000, 3000);
		int moveLimit = 10;

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
		Goal g2 = new Goal(1000, 2000, 3000);
		int timeLimit1 = 120; // seconds?

		LightningLevel l2 = new LightningLevel(b2, g2, timeLimit1);
		l2.isUnlocked = true; // first three levels should be unlocked
		getMainLevels().addLevel(l2);

		// Create Level 3
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("N", 1));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("C", 1));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("R", 1));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("A", 1));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("N", 1));
		squaresArray[5] = new Square(new Position(5,0), false);

		squaresArray[6] = new Square(new Position(0,1), true, new Tile("O", 1));
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("O", 1));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("N", 1));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("E", 1));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("N", 1));
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("E", 1));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("I", 1));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("B", 1));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("I", 1));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("K", 1));
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("L", 1));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("N", 1));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("K", 1));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("M", 1));
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("A", 1));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("O", 1));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("U", 1));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("P", 1));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("K", 1));
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

		ThemeLevel l3 = new ThemeLevel(b3, g3, theme1, words1);
		l3.isUnlocked = true; // first three levels should be unlocked
		getMainLevels().addLevel(l3);
		
		// Levels 4-15 (just placeholders for now)
		PuzzleLevel l4 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l4);
		
		PuzzleLevel l5 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l5);
		
		// Create Level 6
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("T", 1));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("A", 1));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("T", 1));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("I", 1));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("A", 1));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("S", 1));

		squaresArray[6] = new Square(new Position(0,1), true, new Tile("L", 1));
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("A", 1));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("R", 1));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("I", 1));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("N", 1));
		squaresArray[11] = new Square(new Position(5,1), true, new Tile("O", 1));

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("A", 1));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("N", 1));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("N", 1));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("C", 1));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("D", 1));
		squaresArray[17] = new Square(new Position(5,2), true, new Tile("U", 1));

		squaresArray[18] = new Square(new Position(0,3), true, new Tile("I", 1));
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("T", 1));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("P", 1));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("A", 1));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("I", 1));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("T", 1));

		squaresArray[24] = new Square(new Position(0,4), true, new Tile("C", 1));
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("A", 1));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("C", 1));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("I", 1));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("H", 1));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), false);
		squaresArray[31] = new Square(new Position(1,5), false);
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("F", 1));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("I", 1));
		squaresArray[34] = new Square(new Position(4,5), true, new Tile("C", 1));
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
		
		PuzzleLevel l7 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l7);
		
		PuzzleLevel l8 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l8);

		// Create Level 9
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("L", 1));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("B", 1));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("O", 1));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("N", 1));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("H", 1));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("R", 1));

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("I", 1));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("E", 1));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("I", 1));
		squaresArray[10] = new Square(new Position(4,1), false);
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), false);
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("O", 1));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("N", 1));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("A", 1));
		squaresArray[16] = new Square(new Position(4,2), false);
		squaresArray[17] = new Square(new Position(5,2), false);

		squaresArray[18] = new Square(new Position(0,3), false);
		squaresArray[19] = new Square(new Position(1,3), false);
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("R", 1));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("N", 1));
		squaresArray[22] = new Square(new Position(4,3), false);
		squaresArray[23] = new Square(new Position(5,3), false);

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("P", 1));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("A", 1));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("D", 1));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("A", 1));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), true, new Tile("H", 1));
		squaresArray[31] = new Square(new Position(1,5), true, new Tile("I", 1));
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("S", 1));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("F", 1));
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
		
		PuzzleLevel l10 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l10);
		
		PuzzleLevel l11 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l11);
		
		// Create Level 12
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("H", 1));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("S", 1));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("O", 1));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("C", 1));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("G", 1));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("F", 1));

		squaresArray[6] = new Square(new Position(0,1), true, new Tile("O", 1));
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("C", 1));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("C", 1));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("O", 1));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("L", 1));
		squaresArray[11] = new Square(new Position(5,1), true, new Tile("T", 1));

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("E", 1));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("K", 1));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("E", 1));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("R", 1));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("N", 1));
		squaresArray[17] = new Square(new Position(5,2), true, new Tile("E", 1));

		squaresArray[18] = new Square(new Position(0,3), true, new Tile("B", 1));
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("Y", 1));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("I", 1));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("S", 1));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("I", 1));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("N", 1));

		squaresArray[24] = new Square(new Position(0,4), true, new Tile("O", 1));
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("X", 1));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("N", 1));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("N", 1));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("G", 1));
		squaresArray[29] = new Square(new Position(5,4), true, new Tile("B", 1));

		squaresArray[30] = new Square(new Position(0,5), true, new Tile("G", 1));
		squaresArray[31] = new Square(new Position(1,5), true, new Tile("N", 1));
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("I", 1));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("L", 1));
		squaresArray[34] = new Square(new Position(4,5), true, new Tile("W", 1));
		squaresArray[35] = new Square(new Position(5,5), true, new Tile("O", 1));
		
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
		
		PuzzleLevel l13 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l13);
		
		PuzzleLevel l14 = new PuzzleLevel(b1, g1, moveLimit);
		getMainLevels().addLevel(l14);
		
		// Create Level 15
		squaresArray[0] = new Square(new Position(0,0), true, new Tile("T", 1));
		squaresArray[1] = new Square(new Position(1,0), true, new Tile("P", 1));
		squaresArray[2] = new Square(new Position(2,0), true, new Tile("R", 1));
		squaresArray[3] = new Square(new Position(3,0), true, new Tile("S", 1));
		squaresArray[4] = new Square(new Position(4,0), true, new Tile("A", 1));
		squaresArray[5] = new Square(new Position(5,0), true, new Tile("S", 1));

		squaresArray[6] = new Square(new Position(0,1), false);
		squaresArray[7] = new Square(new Position(1,1), true, new Tile("I", 1));
		squaresArray[8] = new Square(new Position(2,1), true, new Tile("C", 1));
		squaresArray[9] = new Square(new Position(3,1), true, new Tile("S", 1));
		squaresArray[10] = new Square(new Position(4,1), true, new Tile("A", 1));
		squaresArray[11] = new Square(new Position(5,1), false);

		squaresArray[12] = new Square(new Position(0,2), true, new Tile("J", 1));
		squaresArray[13] = new Square(new Position(1,2), true, new Tile("A", 1));
		squaresArray[14] = new Square(new Position(2,2), true, new Tile("S", 1));
		squaresArray[15] = new Square(new Position(3,2), true, new Tile("W", 1));
		squaresArray[16] = new Square(new Position(4,2), true, new Tile("L", 1));
		squaresArray[17] = new Square(new Position(5,2), true, new Tile("I", 1));

		squaresArray[18] = new Square(new Position(0,3), true, new Tile("A", 1));
		squaresArray[19] = new Square(new Position(1,3), true, new Tile("V", 1));
		squaresArray[20] = new Square(new Position(2,3), true, new Tile("A", 1));
		squaresArray[21] = new Square(new Position(3,3), true, new Tile("I", 1));
		squaresArray[22] = new Square(new Position(4,3), true, new Tile("E", 1));
		squaresArray[23] = new Square(new Position(5,3), true, new Tile("S", 1));

		squaresArray[24] = new Square(new Position(0,4), false);
		squaresArray[25] = new Square(new Position(1,4), true, new Tile("A", 1));
		squaresArray[26] = new Square(new Position(2,4), true, new Tile("V", 1));
		squaresArray[27] = new Square(new Position(3,4), true, new Tile("F", 1));
		squaresArray[28] = new Square(new Position(4,4), true, new Tile("T", 1));
		squaresArray[29] = new Square(new Position(5,4), false);

		squaresArray[30] = new Square(new Position(0,5), true, new Tile("J", 1));
		squaresArray[31] = new Square(new Position(1,5), true, new Tile("L", 1));
		squaresArray[32] = new Square(new Position(2,5), true, new Tile("L", 1));
		squaresArray[33] = new Square(new Position(3,5), true, new Tile("E", 1));
		squaresArray[34] = new Square(new Position(4,5), true, new Tile("H", 1));
		squaresArray[35] = new Square(new Position(5,5), true, new Tile("S", 1));
		
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


