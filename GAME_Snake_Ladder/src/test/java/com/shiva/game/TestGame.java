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
	
	private BoardService boardSevice;
	private Mover mover;
	List<Player> playerList;
	Board board;
	DiceService diceSevice;

 	@Test
	public void testingWinningPosition() {
		playerList = new ArrayList<Player>();
		Player p1 = new Player("Raj");
		Player p2 = new Player("Shiva");
		boardSevice = new BoardService(100);
		boardSevice.setPlayers(playerList);
		playerList.add(p1);
		playerList.add(p2);
		board = new Board(100);
		int totalDiceValue = 0;
		int newPosition = 0;
		newPosition = boardSevice.getNewPositionAfterGoingThroughSnakesAndLadders(100);
		board.getPlayerPieces().put(p1.getId(), newPosition);
		Assert.assertEquals(true, 100 == board.getPlayerPieces().get(p1.getId()));
		//p1.setId("3") ;
	}
	
	@Test
	public void testingWinningPositionFail() {
		playerList = new ArrayList<Player>();
		Player p1 = new Player("Shetty");
		Player p2 = new Player("Bill");
		boardSevice = new BoardService(100);
		boardSevice.setPlayers(playerList);
		playerList.add(p1);
		playerList.add(p2);
		board = new Board(100);
		int totalDiceValue = 0;
		int newPosition = 0;
		newPosition = boardSevice.getNewPositionAfterGoingThroughSnakesAndLadders(80);
		board.getPlayerPieces().put(p1.getId(), newPosition);
		Assert.assertEquals(false, 100 == board.getPlayerPieces().get(p1.getId()));
	}
	
	@Test
	public void testPlayerWon() {
		playerList = new ArrayList<Player>();
		Player p1 = new Player("Shetty");
		Player p2 = new Player("Bill");
		boardSevice = new BoardService(100);
		boardSevice.setPlayers(playerList);
		playerList.add(p1);
		playerList.add(p2);
		board = new Board(100);
	    Map<String, Integer> playerPieces = new HashMap<String, Integer>();
		//int totalDiceValue = 0;
		Integer newPosition = 0;
		newPosition = boardSevice.getNewPositionAfterGoingThroughSnakesAndLadders(100);
		playerPieces.put(p1.getPlayerName(), newPosition);
		//board.getPlayerPieces().put(p1.getId(), newPosition);
		//playerPieces.put(p1.getPlayerName(), Integer.parseInt(p1.getId()));
		//board.setPlayerPieces(playerPieces);
		Assert.assertEquals(true, 100 == playerPieces.get(p1.getPlayerName()));
	}
	
	@Test
	public void testNextMove() {
		playerList = new ArrayList<Player>();
		Player p1 = new Player("Shetty");
		Player p2 = new Player("Bill");
		boardSevice = new BoardService(100);
		boardSevice.setPlayers(playerList);
		playerList.add(p1);
		playerList.add(p2);
		board = new Board(100);
	    Map<String, Integer> playerPieces = new HashMap<String, Integer>();
		//int totalDiceValue = 0;
		Integer newPosition = 0;
		newPosition = boardSevice.getNewPositionAfterGoingThroughSnakesAndLadders(92);
		playerPieces.put(p1.getPlayerName(), newPosition);
		//board.getPlayerPieces().put(p1.getId(), newPosition);
		//playerPieces.put(p1.getPlayerName(), Integer.parseInt(p1.getId()));
		//board.setPlayerPieces(playerPieces);
		Assert.assertEquals(false, 100 == playerPieces.get(p1.getPlayerName()));
	}
	

}
