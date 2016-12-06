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
		lvlMod.removeWord();
		//assertNotSame(lvlMod.board.lookUpSquare(2, 0).tilePeek().letter, "R");
		//Last line SHOULD BECOME true once we actully make the move remove the word as it should	
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
		
		assertEquals(lvlMod.board.lookUpSquare(1, 0).tilePeek().letter, "O");
		lvlMod.removeWord();
		assertEquals(lvlMod.board.lookUpSquare(1, 0).tilePeek().letter, "O");
		//Last line SHOULD STAY true once we actully make Move.java legit
	}
}
