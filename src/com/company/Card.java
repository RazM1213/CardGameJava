package com.company;

public class Card {

    private final Suit suit;
    private final int cardValue;

    public Card (Suit suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return this.cardValue + " Of " + this.suit;
    }

    public boolean isHigher(Card otherCard) {
        if (this.cardValue == otherCard.cardValue) {
            return Suit.valueOf(String.valueOf(this.suit)).ordinal() > Suit.valueOf(String.valueOf(otherCard.suit)).ordinal();
        }

        return this.cardValue > otherCard.cardValue;
    }
}
