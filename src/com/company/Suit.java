package com.company;

public enum Suit {
    SPADES(1),
    HEARTS(2),
    DIAMONDS(3),
    CLUBS(4);

    private final int suitValue;

    // Constructor
    Suit(int suitValue) {
        this.suitValue = suitValue;
    }

    // Public Method - to expose the suit outside:
    public int getSuit() {
        return suitValue;
    }
}
