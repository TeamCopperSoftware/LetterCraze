package entities;

import junit.framework.TestCase;

public class TestGoal extends TestCase {

	public void testGoalValid() {
		Goal goal = new Goal(33, 64, 97);
		assertEquals(goal.getStar1(), 33);
		assertEquals(goal.getStar2(), 64);
		assertEquals(goal.getStar3(), 97);
		
		goal.setStar1(20);
		assertEquals(goal.getStar1(), 20);
		assertEquals(goal.getStar2(), 64);
		goal.setStar2(53);
		goal.setStar3(99);
		assertEquals(goal.getStar2(), 53);
		assertEquals(goal.getStar3(), 99);

	}
	
	public void testGoalNotValid() {
		//Should modify GOal to check possible. 
		//    Ex, don't allow Goal(-4, 16, 77);
	}
}
