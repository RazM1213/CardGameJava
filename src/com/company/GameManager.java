package com.company;

import java.util.Scanner;

public class GameManager {

    public int guessCount = 0;
    public boolean gameOn = true;

    public void startGame() {
        System.out.println("--- STARTING GAME ---");
        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        Card userCard = gameDeck.dealCard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your card: " + userCard);

        while (gameOn) {
            if (gameDeck.numCards <= 0) {
                gameOn = false;
            }
            System.out.println("Take a guess: ");

            String userGuess = scanner.nextLine();
            if (!userGuess.equals("greater") && !userGuess.equals("lesser")) {
                System.out.println("Enter a valid guess !");
            } else {
                if ((userGuess.equals("greater") && userCard.isHigher(gameDeck.showCard())) || (userGuess.equals("lesser") && !userCard.isHigher(gameDeck.showCard()))) {
                    System.out.println("NICE GUESS !");
                    guessCount ++;
                } else {
                    gameOn = false;
                }
            }
        }
        System.out.println("GAME OVER !");
        System.out.println("Number of correct guesses: " + guessCount);
        System.out.println("Thank you for playing !");
    }













    //    public void startGame() {
//        System.out.println("--- STARTING GAME... ---");
//        Deck gameDeck = new Deck();
//        gameDeck.shuffle();
//        Card userCard = gameDeck.dealCard();
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (gameOn && gameDeck.numCards > 0) {
//            System.out.println("Your card: " + userCard);
//            System.out.println("Take a guess: ");
//
//            String userGuess = scanner.nextLine();
//
//            if (!userGuess.equals("greater") && !userGuess.equals("lesser")) {
//                System.out.println("Enter a valid guess!");
//            } else {
//                boolean userGuessBool = scanner.nextLine().equals("greater"); // "greater" or "lesser"
//
//                if (userCard.isHigher(gameDeck.showCard()) == userGuessBool) {
//                    guessCount++;
//                } else {
//                    gameOn = false;
//                }
//            }
//        }
//        System.out.println("NUMBER OF CORRECT GUESSES: " + guessCount);
//    }
}
