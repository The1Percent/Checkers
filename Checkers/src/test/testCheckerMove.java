package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkers.CheckerMove;

public class testCheckerMove {
	int[][] boardStart;
	int[][] boardNoMoves;
	int[][] boardKing;
	
	@Before
	public void setUp() throws Exception {
		boardStart = new int[][]{ 	{0,1,0,1,0,1,0,1}, 
									{1,0,1,0,1,0,1,0}, 
									{0,1,0,1,0,1,0,1}, 
									{0,0,0,0,0,0,0,0}, 
									{0,0,0,0,0,0,0,0}, 
									{2,0,2,0,2,0,2,0}, 
									{0,2,0,2,0,2,0,2}, 
									{2,0,2,0,2,0,2,0} };
		boardNoMoves = new int[][]{ {0,1,0,1,0,1,0,1}, {2,0,2,0,2,0,2,0}, {0,2,0,2,0,2,0,2}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0} };
		boardKing = new int[][]{ {0,1,0,1,0,1,0,1}, {2,0,2,0,2,0,2,0}, {0,4,0,2,0,2,0,2}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0} };
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNoMovesLeft() {
		assertFalse("At the beginning of the game the red player should have a move available", CheckerMove.noMovesLeft(boardStart, 1));
		assertFalse("At the beginning of the game the yellow player should have a move available", CheckerMove.noMovesLeft(boardStart, 2));
		assertTrue("Locked board should have no moves left for the red player", CheckerMove.noMovesLeft(boardNoMoves, 1));
		assertFalse("Locked board should be unlocked by giving a king to yellow player", CheckerMove.noMovesLeft(boardKing, 2));
	}

	@Test
	public void testApplyMove() {
		int openingMove = CheckerMove.ApplyMove(boardStart, 5, 0, 4, 1);
		assertTrue("Valid opening move should return true", openingMove == 1);
	}

}
