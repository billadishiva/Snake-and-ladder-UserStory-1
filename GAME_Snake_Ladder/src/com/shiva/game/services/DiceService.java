/**
 * 
 */
package com.shiva.game.services;

import java.util.Random;

/**
 * @author Shivaraj
 *
 */
public class DiceService {
    public static int roll() {
        return new Random().nextInt(6) + 1; 
        }
}