package entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {

		// Testing Valid Inputs in Tile
		public void testValidInput(){
			String toSet = "A";
			Tile tile = new Tile(toSet, 2);
			assertEquals("A", tile.toString());
			assertEquals(2, tile.getPoints());
			
			String toSet2 = "g";
			Tile tile2 = new Tile(toSet2, 2);
			assertEquals("G", tile2.toString());
			assertEquals(2, tile2.getPoints());
			
			String toSet3 = "Qu";
			Tile tile3 = new Tile(toSet3, 11);
			assertEquals("QU", tile3.toString());
			assertEquals(11, tile3.getPoints());
			
			String toSet4 = "QU";
			Tile tile4 = new Tile(toSet4, 11);
			assertEquals("QU", tile4.toString());
			assertEquals(11, tile4.getPoints());
			
			String toSet5 = "qu";
			Tile tile5 = new Tile(toSet5, 11);
			assertEquals("QU", tile5.toString());
			assertEquals(11, tile5.getPoints());
		}
		
		//Test how tile creation can go wrong
		public void testInvalidInput(){
		//Specialty case: needs to be Qu
			String toSet = "Q";
			Tile tile = new Tile(toSet, 1);
			//assertFalse(tile.isValid());
		//Specialty case: needs to be Qu
			String toSet2 = "q";
			Tile tile2 = new Tile(toSet2, 2);
			//assertFalse(tile2.isValid());
			//assertEquals(null, tile2.toString());
			//assertEquals(0, tile2.getPoints());
		//Specialty case: cannot be more than one letter UNLESS QU
			String toSet3 = "no";
			Tile tile3 = new Tile(toSet3, 2);
			//assertFalse(tile3.isValid());
			//assertEquals(null, tile3.toString());
			//assertEquals(0, tile3.getPoints());
		//Specialty case: needs to be a letter, no symbols
			String toSet4 = "@";
			Tile tile4 = new Tile(toSet4, 3);
			//assertFalse(tile4.isValid());
			//assertEquals(null, tile4.toString());
			//assertEquals(0, tile3.getPoints());
	}

}
