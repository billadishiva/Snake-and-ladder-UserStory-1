package main.java.com.shiva.game.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import main.java.com.shiva.game.modules.Board;
import main.java.com.shiva.game.modules.Ladder;
import main.java.com.shiva.game.modules.Player;
import main.java.com.shiva.game.modules.Snake;



public class BoardService {
    public Board board;
    public int initialNumberOfPlayers;
    public Queue<Player> players;  private boolean isGameCompleted;

    public static final int DEFAULT_BOARD_SIZE = 100;

    public BoardService(int boardSize) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<Player>();
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
            playerPieces.put(player.getId(), 0);
        }
        board.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes); 
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders); 
    }

    /**
     * ==========logic for the game==========
     */

    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : board.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd(); 
                    }
            }

            for (Ladder ladder : board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        } while (newPosition != previousPosition);
        return newPosition;
    }

    private void movePlayer(Player player, int positions) {
        int oldPosition = board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + positions;

        int boardSize = board.getSize();
        if (newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        board.getPlayerPieces().put(player.getId(), newPosition);

        System.out.println(" Player " + player.getPlayerName() + " rolled a " + positions + " and moved from " + oldPosition +" to " + newPosition);
    }

    private int getTotalValueAfterDiceRolls() {
        return DiceService.roll();
    }

    private boolean hasPlayerWon(Player player) {
        int playerPosition = board.getPlayerPieces().get(player.getId());
        int winningPosition = board.getSize();
        return playerPosition == winningPosition; 
    }

    private boolean isGameCompleted() {
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < initialNumberOfPlayers;
    }

    public void startGame() {
        while (!isGameCompleted()) {
            int totalDiceValue = getTotalValueAfterDiceRolls();
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

}
