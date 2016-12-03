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
	
	//Java auto disallows new Tile("z", 999999999);
	//No need for test for too large a number
}
