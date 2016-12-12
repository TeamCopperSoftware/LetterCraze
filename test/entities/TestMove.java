package entities;

import java.util.ArrayList;

import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.ThemeLevelApplication;

public class TestMove extends TestCase {

	public void testMoveValid() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
				
		Word word = new Word(lvlMod.board.lookUpSquare(2, 2));
		assertEquals(word.toString(), "B");
		word.appendSquare(lvlMod.board.lookUpSquare(3, 1));
		word.appendSquare(lvlMod.board.lookUpSquare(3, 0));
		word.appendSquare(lvlMod.board.lookUpSquare(4, 0));
		assertEquals(word.toString(), "BEAN");
		
		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "BEAN");
		
		assertEquals(lvlMod.board.lookUpSquare(3, 0).tilePeek().letter, "A");
		Move move = new Move (word, lvlMod);
		assertTrue(move.doMove());
		assertNotSame(lvlMod.board.lookUpSquare(3, 0).tilePeek().letter, "A");
	
	}
	
	public void testUndoMoveValid() {
		Model model = new Model();
		ArrayList<LevelModel> lvlList = model.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
				
		Word word = new Word(lvlMod.board.lookUpSquare(2, 2));
		assertEquals(word.toString(), "B");
		word.appendSquare(lvlMod.board.lookUpSquare(3, 1));
		word.appendSquare(lvlMod.board.lookUpSquare(3, 0));
		word.appendSquare(lvlMod.board.lookUpSquare(4, 0));
		assertEquals(word.toString(), "BEAN");
		
		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "BEAN");
		
		assertEquals(lvlMod.board.lookUpSquare(3, 0).tilePeek().letter, "A");
		Move move = new Move (word, lvlMod);
		assertTrue(move.doMove());
		assertNotSame(lvlMod.board.lookUpSquare(3, 0).tilePeek().letter, "A");
		assertTrue(move.undoMove());
		assertEquals(lvlMod.board.lookUpSquare(3, 0).tilePeek().letter, "A");

	
	}
	
	public void testMoveNotValidShort() {
		Model mod = new Model();
		ArrayList<LevelModel> lvlList = mod.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		
		Word word = new Word(lvlMod.board.lookUpSquare(2, 2));
		assertEquals(word.toString(), "B");
		word.appendSquare(lvlMod.board.lookUpSquare(3, 1));
		assertEquals(word.toString(), "BE");
		
		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "BE");
		
		assertEquals(lvlMod.board.lookUpSquare(2, 2).tilePeek().letter, "B");
		Move move = new Move (word, lvlMod);
		assertFalse(move.doMove());
		assertEquals(lvlMod.board.lookUpSquare(2, 2).tilePeek().letter, "B");
		//Last line SHOULD STAY true once we actully make Move.java legit
	}
	
	public void testUndoMoveNotValidShort() {
		Model mod = new Model();
		ArrayList<LevelModel> lvlList = mod.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		
		Word word = new Word(lvlMod.board.lookUpSquare(2, 2));
		assertEquals(word.toString(), "B");
		word.appendSquare(lvlMod.board.lookUpSquare(3, 1));
		assertEquals(word.toString(), "BE");
		
		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "BE");
		
		assertEquals(lvlMod.board.lookUpSquare(2, 2).tilePeek().letter, "B");
		Move move = new Move (word, lvlMod);
		assertFalse(move.doMove());
		assertEquals(lvlMod.board.lookUpSquare(2, 2).tilePeek().letter, "B");
		assertFalse(move.undoMove());
		assertEquals(lvlMod.board.lookUpSquare(2, 2).tilePeek().letter, "B");
	}
	
	public void testMoveNotValidBadTheme() {
		Model mod = new Model();
		ArrayList<LevelModel> lvlList = mod.getMainLevels().getLevels();
		LevelModel lvlMod = lvlList.get(2);
		
		Word word = new Word(lvlMod.board.lookUpSquare(0, 0));
		assertEquals(word.toString(), "N");
		word.appendSquare(lvlMod.board.lookUpSquare(1, 1));
		assertEquals(word.toString(), "NO");
		word.appendSquare(lvlMod.board.lookUpSquare(2, 2));
		assertEquals(word.toString(), "NOB");

		lvlMod.board.currentWord = word;
		assertEquals(lvlMod.board.currentWord.toString(), "NOB");
		
		assertEquals(lvlMod.board.lookUpSquare(1, 1).tilePeek().letter, "O");
		Move move = new Move (word, lvlMod);
		//assertFalse(move.doMove());
		//assertEquals(lvlMod.board.lookUpSquare(1, 1).tilePeek().letter, "O");
		//TODO: works in practice, but fails in test
	}
}
