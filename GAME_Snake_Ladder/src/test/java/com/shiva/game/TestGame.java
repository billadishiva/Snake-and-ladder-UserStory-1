package com.shiva.game;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shiva.game.modules.Board;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author Shivaraj
 *
 */
public class TestGame extends TestCase {
	
	 	
	@Test
	  public void testBoardSize() {
		 Board actualObject = new Board(100);
		 Board expectedObject = new Board();
		 expectedObject.setSize(100);
	     Assert.assertEquals(actualObject.getSize(), expectedObject.getSize());;
	  }
	
	@Test
	  public void testBoardSizeFail() {
		 Board actualObject = new Board(100);
		 Board expectedObject = new Board();
		 expectedObject.setSize(10);
	     Assert.assertNotSame(actualObject.getSize(), expectedObject.getSize());;
	  }
	
	@Test
	  public void checkPlayerOwn() {
		 int winningPosition = 100;
		 int palyerPosition = 100;
	     Assert.assertTrue("Winner correctly identified",winningPosition==palyerPosition);;
	  }
}
