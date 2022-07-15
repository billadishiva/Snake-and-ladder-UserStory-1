package com.shiva.game.modules.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This Class represnts the snake and ladder board
 * 
 * @author Shivaraj
 * 
 */
public class Board {

	private int size;
	private List<Snake> snakes; 
	private List<Ladder> ladders;
	private Map<String, Integer> playerPieces;
	
	public Board(int size) {
		this.size = size;
		this.snakes = new ArrayList<Snake>();
		this.ladders = new ArrayList<Ladder>();
		this.playerPieces = new HashMap<String, Integer>();
	}

	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the snakes
	 */
	public List<Snake> getSnakes() {
		return snakes;
	}

	/**
	 * @param snakes the snakes to set
	 */
	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	/**
	 * @return the ladders
	 */
	public List<Ladder> getLadders() {
		return ladders;
	}

	/**
	 * @param ladders the ladders to set
	 */
	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	/**
	 * @return the playerPieces
	 */
	public Map<String, Integer> getPlayerPieces() {
		return playerPieces;
	}

	/**
	 * @param playerPieces the playerPieces to set
	 */
	public void setPlayerPieces(Map<String, Integer> playerPieces) {
		this.playerPieces = playerPieces;
	}

}
