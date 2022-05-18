package com.company;

import java.io.File;
import java.util.Scanner;

public class GameManager {

    public int guessCount;
    public boolean gameOn;

    public GameManager() {
        this.guessCount = 0;
        this.gameOn = true;
    }

    public void playGame() {
        System.out.println("--- WELCOME ---");
        System.out.println("Enter a path to XML file OR press enter to continue: ");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        File xmlFile = new File(userChoice);
        Deck gameDeck;
        if (xmlFile.exists()) {
            gameDeck = new Deck(userChoice);
        } else {
            gameDeck = new Deck();
            gameDeck.shuffle();
        }
        System.out.println("--- STARTING GAME ---");
        Card userCard = gameDeck.dealCard();
        System.out.println("Your card: " + userCard);

        // Main game loop:
        while (this.gameOn) {
            if (gameDeck.numCards <= 0) {
                this.gameOn = false;
            } else {
                System.out.println("Cards Left: " + gameDeck.numCards);
                System.out.println("Take a guess: ");

                String userGuess = scanner.nextLine();
                if (!userGuess.equals("greater") && !userGuess.equals("lesser")) {
                    System.out.println("Enter a valid guess !");
                } else {
                    if ((userGuess.equals("greater") && userCard.isHigher(gameDeck.showCard())) || (userGuess.equals("lesser") && !userCard.isHigher(gameDeck.showCard()))) {
                        System.out.println("NICE GUESS !");
                        System.out.println(gameDeck.cards);
                        this.guessCount++;
                        userCard = gameDeck.dealCard();
                        System.out.println("Your card: " + userCard);
                    } else {
                        this.gameOn = false;
                    }
                }
            }
        }

        if (gameDeck.numCards == 0) {
            System.out.println("YOU WIN !");
        } else {
            System.out.println("GAME OVER !");
            System.out.println("Number of correct guesses: " + this.guessCount);
        }

        System.out.println("Thank you for playing !");
    }
}


