package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    // Attributes:
    public ArrayList<Card> cards;
    public int numCards;

    // Constructor - manual deck building :
    public Deck () {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int value = 1 ; value <= 10 ; value ++) {
                cards.add(new Card(suit, value));
            }
        }
        this.numCards = this.cards.size();
    }

    // Constructor - XML Parser :
    public Deck(String path){
        File xmlFile = new File("C:\\Users\\razm1\\IdeaProjects\\CardGame\\src\\com\\company\\cardgame.xml");
        DomParserV2 parserV2 = new DomParserV2();
        this.cards = parserV2.parse();
        this.numCards = this.cards.size();
    }


    // Implementing dealCard() method:
    public Card dealCard() {
        this.numCards --;
        return cards.remove(cards.size() - 1);
    }

    // Implementing showCard() method:
    public Card showCard() {
        return cards.get(cards.size() - 1);
    }

    // Implementing shuffle() method:
    public void shuffle() {

        Random random = new Random();

        for (int i = 0 ; i < this.numCards ; i++) {
            int firstIndex = random.nextInt(this.numCards);
            int secondIndex = random.nextInt(this.numCards);

            Collections.swap(this.cards, firstIndex, secondIndex);
        }

    }

    public static void main(String[] args) {
        // --- TESTING PLAYGROUND --- //
        // Instantiating new deck:
        Deck deck = new Deck();

        // Print the whole deck, and number of cards before dealing:
        System.out.println("--- THE WHOLE DECK ---");
        System.out.println(deck.cards);
        System.out.println(deck.numCards);

        // Shuffle the deck:
        System.out.println("--- SHUFFLING THE DECK ---");
        deck.shuffle();
        System.out.println(deck.cards);

        // Deal card from the deck, then print the deck to see if it was dealt properly:
        System.out.println("--- DEALING LAST CARD ---");
        System.out.println(deck.dealCard()); // 10 of CLUBS
        System.out.println(deck.cards);

        // Show last card from the deck, then print the deck to check that it was not dealt:
        System.out.println("--- SHOWING LAST CARD ---");
        System.out.println(deck.showCard()); // 9 of CLUBS
        System.out.println(deck.cards);

    }

}
