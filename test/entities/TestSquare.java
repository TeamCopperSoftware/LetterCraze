package entities;

import junit.framework.TestCase;

public class TestSquare extends TestCase {

	public void testSquareValid() {
		Position p1 = new Position(2, 1);
		Tile t1 = new Tile("A");
		Tile t2 = new Tile("B");
		Square s1 = new Square(p1, true, t1);
		assertEquals(s1.tile.toString(), "A");
		
		assertTrue(s1.isEnabled());
		assertEquals(s1.position(), p1);
		assertEquals(s1.tilePeek(), t1);
		assertEquals(s1.tilePop(), t1);
		assertFalse(s1.hasTile());
		
		s1.tileAdd(t2);
		assertEquals(s1.tilePeek(), t2);
		assertTrue(s1.hasTile());		
		//assertTrue(s1.isValid()); //Need a "isValid()" method or similar
	}
	
	public void testSquareNotValid() {
		Position p1 = new Position(2, 1);
		//Tile t1 = new Tile("@");  //TODO: Can't test if bad tile are auto null
		//Square s1 = new Square(p1, true, t1);
		//assertNotSame(s1.tile.toString(), "@"); //Needs not to happen
		//assertTrue(s1.isValid()); //Need a "isValid()" method or similar
	}
}
