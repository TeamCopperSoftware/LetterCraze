package entities;

public class Square {

	Position position;
	Tile tile;
	boolean enabled;

	public Square(Position p, boolean enabled, Tile t) {
		this.position = p;
		this.enabled = enabled;
		this.tile = t;
	}

	public Square(Position p, boolean enabled) {
		this.position = p;
		this.enabled = enabled;
		this.tile = null;
	}

	public Square() {
		//TODO remove at a later time;

	}


	void generateRandomTile () {
		int[] weights = {12702,
				9056,
				8167,
				7507,
				6966,
				6749,
				6327,
				6094,
				5987,
				4253,
				4025,
				2782,
				2758,
				2406,
				2360,
				2228,
				2015,
				1974,
				1929,
				1492,
				978,
				772,
				153,
				150,
				95,
				74};
		String[] letters = {"E",
				"T",
				"A",
				"O",
				"I",
				"N",
				"S",
				"H",
				"R",
				"D",
				"L",
				"C",
				"U",
				"M",
				"W",
				"F",
				"G",
				"Y",
				"P",
				"B",
				"V",
				"K",
				"J",
				"X",
				"QU",
		"Z"};
		int[] values = {
				1, 
				1,
				2,
				2,
				2,
				2,
				2,
				2,
				2,
				3,
				3,
				3,
				3,
				3,
				3, 
				4,
				4, 
				4, 
				4, 
				4, 
				5, 
				5, 
				7, 
				7, 
				8, 
				8, 
		};
		int totalWeight = 99999; // this is the sum of the weights above (don't know if it should be 100000)
		int random = (int)(Math.floor(Math.random() * totalWeight));
		Tile t = new Tile("", 0);
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
			if (random < sum) {
				t.letter = letters[i];
				t.value = values[i];
				break;
			}
		}
		this.tile = t;


	}

	void tileAdd (Tile t) {
		this.tile = t;
	}

	public Tile tilePeek () {
		return tile;
	}

	Tile tilePop () {
		Tile t = tile;
		tileRemove();
		return t;
	}

	void tileRemove () {
		tile = null;
	}

	Position position() {
		return position;

	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean hasTile() {
		return tile != null;
	}

	public Tile getTile() {
		if (!tile.equals(null)) {
			return tile;
		} else {
			return null;
		}
	}

}
