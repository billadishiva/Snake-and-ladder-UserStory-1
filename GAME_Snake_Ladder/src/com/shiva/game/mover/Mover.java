/**
 * 
 */
package com.shiva.game.mover;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shiva.game.modules.Ladder;
import com.shiva.game.modules.Player;
import com.shiva.game.modules.Snake;
import com.shiva.game.services.BoardService;

/**
 * @author Shivaraj
 *
 */
public class Mover {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of snakes needed and press Enter:");
        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<Snake>();
        for (int i = 1; i <= noOfSnakes; i++) {
            snakes.add(new Snake(i, i));
        }
        
        System.out.println("Enter number of Ladders needed and press Enter:");
        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 1; i <= noOfLadders; i++) {
            ladders.add(new Ladder(i, i));
        }
        
        System.out.println("Enter number of Playes participating and press Enter:");
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 1; i <=noOfPlayers; i++) {
            players.add(new Player(String.valueOf(i)));
        }

        BoardService snakeAndLadderService = new BoardService();
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);

        snakeAndLadderService.startGame();
    }
}


