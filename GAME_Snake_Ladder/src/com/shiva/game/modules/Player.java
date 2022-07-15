package com.shiva.game.modules;
import java.util.UUID;
/**
 * This Player program represents each Player
 * 
 * @author Shivaraj
 * 
 */
public class Player {
	
	private String playerName;
    private String id;

    /**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Player(String playerName) {
        this.playerName = playerName;
        this.id = UUID.randomUUID().toString();
    }
	
	

}
