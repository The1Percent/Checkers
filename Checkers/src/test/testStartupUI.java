package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import checkers.CheckerFrame;

public class testStartupUI {
	
	CheckerFrame testGUI;
	
	@Before
	public void setUp() throws Exception {
	testGUI = new CheckerFrame();
	}

	@After
	public void tearDown() throws Exception {
	testGUI.dispose();
	}

	@Test
	public void testCheckerFrame() {
		assertTrue("Window did not open properly", testGUI.getTitle() == "Play Checkers");
	}

}
