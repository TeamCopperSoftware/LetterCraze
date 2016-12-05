package entities;

import junit.framework.TestCase;

public class TestPosition extends TestCase {

	public void testPosValid() {
		Position pos = new Position(4, 6);
		assertEquals(pos.getX(), 4);
		assertEquals(pos.getY(), 6);
	}
	
	public void testPosNotValid() {
		//Should modify Position to check possible. 
		//    Ex, don't allow Position(-4, 6) or Position(12, 8)
	}
}
