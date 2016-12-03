package entities;

import junit.framework.TestCase;

public class TestSquare extends TestCase {

	public void testSquareValid() {
		Position p1 = new Position(2, 1);
		Tile t1 = new Tile("a", 3);
		Square s1 = new Square(p1, true, t1);
		assertEquals(s1.tile.toString(), "a");
		//assertTrue(s1.isValid()); //Need a "isValid()" method or similar
	}
	
	public void testSquareNotValid() {
		Position p1 = new Position(2, 1);
		Tile t1 = new Tile("@", 3);
		Square s1 = new Square(p1, true, t1);
		//assertEquals(s1.tile.toString(), "@"); //Needs not to happen
		//assertTrue(s1.isValid()); //Need a "isValid()" method or similar
	}
}
