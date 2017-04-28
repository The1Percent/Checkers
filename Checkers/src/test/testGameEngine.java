/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkers.GameEngine;

/**
 * @author Shane
 *
 */
public class testGameEngine {

	int[][] boardStart;
	int[][] boardStartBad;
	final int diffMin = 2;
	final int diffMax = 6;
	
	@Before
	public void setUp() throws Exception {
		 
		boardStart = new int[][]{ {0,1,0,1,0,1,0,1}, {1,0,1,0,1,0,1,0}, {0,1,0,1,0,1,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {2,0,2,0,2,0,2,0}, {0,2,0,2,0,2,0,2}, {2,0,2,0,2,0,2,0} };
		boardStartBad = new int[][]{ {0,3,0,3,0,3,0,3}, {1,0,1,0,1,0,1,0}, {0,1,0,1,0,1,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {2,0,2,0,2,0,2,0}, {0,2,0,2,0,2,0,2}, {2,0,2,0,2,0,2,0} };
		
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link checkers.GameEngine#eval(int[][])}.
	 */
	@Test
	public void testEval() {
		int bSValue = GameEngine.eval(boardStart);
		int bSBValue = GameEngine.eval(boardStartBad);
		
		assertTrue("Default Board returns Value should be greater than or equal to -10", bSValue >= -10);
		assertTrue("Default Board returns Value should be greater than or equal to -10", bSValue <= 10);
		assertTrue("Bad board should have a value < -255", bSBValue < -255); //The board should be negative way beyond the default randomness as we weighted the red side with a bunch of kings


	}

	/**
	 * Test method for {@link checkers.GameEngine#MinMax(int[][] board, int depth, int maxDepth, int[] move, int turn, int[] counter, int redBest, int yellowBest)}.
	 */
	@Test
	public void testMinMax() {
		int[] move = new int[4];
		int[] counterEasy = new int[6];
		int[] counterHard = new int[6];
		
		int easy = GameEngine.MinMax(boardStart, 0, diffMin, move, 1, counterEasy);
		int hard = GameEngine.MinMax(boardStart, 0, diffMax, move, 1, counterHard);
		assertTrue("Hard move should always have an equal or better score than easy with a +10 modifier to account for the randomness", hard + 10 >= easy);
		
		int[] moveB = new int[4];
		int[] counterEasyB = new int[6];
		int[] counterHardB = new int[6];
		
		int easyB = GameEngine.MinMax(boardStartBad, 0, diffMin, moveB, 1, counterEasyB);
		int hardB = GameEngine.MinMax(boardStartBad, 0, diffMax, moveB, 1, counterHardB);
		assertTrue("Hard move should always have an equal or better score than easy with a +10 modifier to account for the randomness", hardB + 10 >= easyB);
		
	}

}
