package com.company;
import com.company.Suit;

public class Card {

    // Attributes:
    private final Suit suit;
    private final int cardValue;

    // Constructor:
    public Card (Suit suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    // Implementing toString() method:
    @Override
    public String toString() {
        return this.cardValue + " Of " + this.suit;
    }

    // Implementing isHigher() method:
    public boolean isHigher(Card otherCard) {
        if (this.cardValue == otherCard.cardValue) {
            return this.suit.getSuit() > otherCard.suit.getSuit();
        }

        return this.cardValue > otherCard.cardValue;
    }


    public static void main(String[] args) {
        // --- TESTING PLAYGROUND --- //
        // Enum Instantiation:
        Suit spades = Suit.SPADES; // 1
        Suit hearts = Suit.HEARTS; // 2
        Suit diamonds = Suit.DIAMONDS; // 3
        Suit clubs = Suit.CLUBS; // 4

        // Card Instantiation:
        Card twoOfSpades = new Card(spades, 2);
        Card twoOfClubs = new Card(clubs, 2);

        System.out.println(twoOfSpades);
        System.out.println(twoOfClubs.isHigher(twoOfSpades)); //True
    }
}
