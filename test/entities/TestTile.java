package entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {

	public void testWordValid() {
		Tile tile1 = new Tile("y", 7);
		assertEquals(tile1.toString(), "y");
		assertEquals(tile1.value, 7);
	}
	
	public void testWordBadLetters() {
		Tile tile2 = new Tile("no", 3);
		//don't allow more than 1 character
	}
	
	public void testWordBadLetter() {
		Tile tile3 = new Tile("@", 4);
		//don't allow non-characters
	}
	
	public void testWordNegValue() {
		Tile tile4 = new Tile("b", -2);
		//keep score positive
	}
	//
	//Java auto disallows new Tile("z", 999999999);
	//No need for test for too large a number

	// Testing Valid Inputs in Tile
		public void testValidInput(){
			String toSet = "A";
			Tile tile = new Tile(toSet, 1);
			
			assertEquals("A",tile.getTile());
			assertEquals(2,tile.getPoints());
			
			String toSet2 = "g";
			Tile tile2 = new Tile(toSet2, 2);
			
			assertEquals("G",tile2.getTile());
			assertEquals(4,tile2.getPoints());
			
			String toSet3 = "Qu";
			Tile tile3 = new Tile(toSet3, 3);
			
			assertEquals("Qu",tile3.getTile());
			assertEquals(11,tile3.getPoints());
			
			String toSet4 = "QU";
			Tile tile4 = new Tile(toSet4, 4);
			
			assertEquals("Qu",tile4.getTile());
			assertEquals(11,tile4.getPoints());
			
			String toSet5 = "qu";
			Tile tile5 = new Tile(toSet5, 5);
			
			assertEquals("Qu",tile5.getTile());
			assertEquals(11,tile5.getPoints());
		}
		
		public void testInvalidInput(){
			String toSet = "Q";
			Tile tile = new Tile(toSet, 1);
			assertEquals(null,tile.getTile());
			assertEquals(0,tile.getPoints());
			
			String toSet2 = "q";
			Tile tile2 = new Tile(toSet2, 2);
			assertEquals(null,tile2.getTile());
			assertEquals(0,tile2.getPoints());
			
			String toSet3 = "@";
			Tile tile3 = new Tile(toSet3, 3);
			assertEquals(null,tile3.getTile());
			assertEquals(0,tile3.getPoints());
	}

}
