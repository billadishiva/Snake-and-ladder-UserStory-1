package com.shiva.game.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.shiva.game.modules.Board;
import com.shiva.game.modules.Ladder;
import com.shiva.game.modules.Player;
import com.shiva.game.modules.Snake;

public class BoardService {
    public Board board;
    public int initialNumberOfPlayers;
    public Queue<Player> players; // Comment: Keeping players in game service as they are specific to this game and not the board. Keeping pieces in the board instead.
    public boolean isGameCompleted;

   // public int noOfDices;
   

    public static final int DEFAULT_BOARD_SIZE = 100; //The board will have 100 cells numbered from 1 to 100.
    public static final int DEFAULT_NO_OF_DICES = 1;

    public BoardService(int boardSize) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<Player>();
        //this.noOfDices = BoardService.DEFAULT_NO_OF_DICES;
    }

    public BoardService() {
        this(BoardService.DEFAULT_BOARD_SIZE);
    }



    /**
     * This method initialises Board with 
     */

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.initialNumberOfPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player : players) {
            this.players.add(player);
            playerPieces.put(player.getId(), 0); //Each player has a piece which is initially kept outside the board (i.e., at position 0).
        }
        board.setPlayerPieces(playerPieces); //  Add pieces to board
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders); // Add ladders to board
    }

    /**
     * ==========Core business logic for the game==========
     */

    public int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : board.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
                }
            }

            for (Ladder ladder : board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                }
            }
        } while (newPosition != previousPosition); // There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
        return newPosition;
    }

    public void movePlayer(Player player, int positions) {
        int oldPosition = board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + positions; // Based on the dice value, the player moves their piece forward that number of cells.

        int boardSize = board.getSize();

        // Can modify this logic to handle side case when there are multiple dices (Optional requirements)
        if (newPosition > boardSize) {
            newPosition = oldPosition; // After the dice roll, if a piece is supposed to move outside position 100, it does not move.
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        board.getPlayerPieces().put(player.getId(), newPosition);

        System.out.println(" Player " + player.getPlayerName() + " rolled a " + positions + " and moved from " + oldPosition +" to " + newPosition);
    }

    public int getTotalValueAfterDiceRolls() {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
        return DiceService.roll();
    }

    public boolean hasPlayerWon(Player player) {
        // Can change the logic a bit to handle special cases when there are more than one dice (Optional requirements)
        int playerPosition = board.getPlayerPieces().get(player.getId());
        int winningPosition = board.getSize();
        return playerPosition == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

    public boolean isGameCompleted() {
        // Can use shouldGameContinueTillLastPlayer to change the logic of determining if game is completed (Optional requirements)
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < initialNumberOfPlayers;
    }

    public void startGame() {
        while (!isGameCompleted()) {
            int totalDiceValue = getTotalValueAfterDiceRolls(); // Each player rolls the dice when their turn comes.
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(" Hurray Player " + currentPlayer.getPlayerName() + " wins the game and Congratulations..!");
                board.getPlayerPieces().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }
    }

    /**
     * =======================================================
     */
}
