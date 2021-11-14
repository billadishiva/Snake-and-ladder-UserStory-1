package com.shiva.game.modules;
/**
 * This Snake program represents each snake in the board with head in one number
 * tail with other number
 * @author Shivaraj
 * 
 */
public class Snake {
	private int start;
	private int end;
	
	public Snake(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

}
