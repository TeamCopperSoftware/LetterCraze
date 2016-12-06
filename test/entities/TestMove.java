package entities;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestMove extends TestCase {

	public void testMoveValid() {
		Model mod = new Model();
		ArrayList<LevelModel> lvlList = mod.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(0);
		
		Word word = new Word(lvlMod.board.lookUpSquare(0, 0));
		assertEquals(word.toString(), "W");
		word.appendSquare(lvlMod.board.lookUpSquare(1, 0));
		word.appendSquare(lvlMod.board.lookUpSquare(2, 0));
		word.appendSquare(lvlMod.board.lookUpSquare(3, 0));
		assertEquals(word.toString(), "WORD");
		
		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "WORD");
		
		assertEquals(lvlMod.board.lookUpSquare(2, 0).tilePeek().letter, "R");
		Move move = new Move (word, lvlMod);
		assertTrue(move.doMove());
		assertNotSame(lvlMod.board.lookUpSquare(2, 0).tilePeek().letter, "R");
		//Last line sometimes fails when next tile to fill space just
		//  HAPPENS to be R? Try running multiple times if error occurs
	}
	
	public void testMoveNotValid() {
		Model mod = new Model();
		ArrayList<LevelModel> lvlList = mod.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(0);
		
		Word word = new Word(lvlMod.board.lookUpSquare(0, 0));
		assertEquals(word.toString(), "W");
		word.appendSquare(lvlMod.board.lookUpSquare(1, 0));
		assertEquals(word.toString(), "WO");
		
		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "WO");
		
		assertEquals(lvlMod.board.lookUpSquare(2, 0).tilePeek().letter, "R");
		Move move = new Move (word, lvlMod);
		assertFalse(move.doMove());
		assertEquals(lvlMod.board.lookUpSquare(2, 0).tilePeek().letter, "R");
		//Last line SHOULD STAY true once we actully make Move.java legit
	}
}
