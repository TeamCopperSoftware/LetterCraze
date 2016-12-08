package entities;

import junit.framework.TestCase;

public class TestWord extends TestCase {

	public void testWordValid() {
		Position p1 = new Position(2, 1);
		Tile t1 = new Tile("Y");
		Square s1 = new Square(p1, true, t1);
		assertEquals(s1.tile.toString(), "Y");
		
		Position p2 = new Position(2, 2);
		Tile t2 = new Tile("E");
		Square s2 = new Square(p2, true, t2);
		
		Position p3 = new Position(3, 2);
		Tile t3 = new Tile("S");
		Square s3 = new Square(p3, true, t3);
		
		Word word = new Word(s1);
		word.appendSquare(s2);
		word.appendSquare(s3);
		assertEquals(word.toString(), "YES");
		assertTrue(word.isValid());
	}
	
	public void testWordNotValid() {
		Position p1 = new Position(4, 4);
		Tile t1 = new Tile("N");
		Square s1 = new Square(p1, true, t1);
		
		Position p2 = new Position(3, 3);
		Tile t2 = new Tile("O");
		Square s2 = new Square(p2, true, t2);
				
		Word word = new Word(s1);
		word.appendSquare(s2);
		assertEquals(word.toString(), "NO");
		assertFalse(word.isValid());
	}
}
