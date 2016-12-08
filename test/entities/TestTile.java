package entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {

		// Testing Valid Inputs in Tile
		public void testValidInput(){
			String toSet = "A";
			Tile tile = new Tile(toSet);
			assertEquals("A", tile.toString());
			assertEquals(2, tile.getPoints());
			
			String toSet2 = "G";
			Tile tile2 = new Tile(toSet2);
			assertEquals("G", tile2.toString());
			assertEquals(4, tile2.getPoints());
			
			String toSet3 = "QU";
			Tile tile3 = new Tile(toSet3);
			assertEquals("QU", tile3.toString());
			assertEquals(11, tile3.getPoints());
			assertTrue(tile3.isValid());
			
		}
		
		//Test how tile creation can go wrong
		public void testInvalidInput(){
		
		/* TODO: How to test bad constructors that are automatically null?
		//Specialty case: needs to be capital	
		String toSet0 = "C";
		Tile tile0 = new Tile (toSet0);
		assertTrue (tile0.isValid());
		
		String toSet = "c";
		assertNull (new Tile(toSet));
		assertNull(tile);
		assertFalse(tile.isValid());
			
		try {
			new Tile("c");
			new Tile ("Q");
		} catch (Exception e) {
			fail("Invalid tile parameters, tile not made.");
		}
		
		//Specialty case: needs to be QU
			try {
				new Tile("Q");
			} catch (Exception e) {
				fail("Invalid tile parameters, tile not made.");
			}
		*/	
		}  
			
}
