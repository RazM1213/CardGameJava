package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    public ArrayList<Card> cards;
    public int numCards;
    public int finalNumber;

    public Deck () {
        this.finalNumber = 10;
        this.cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (int value = 1 ; value <= this.finalNumber ; value ++) {
                this.cards.add(new Card(suit, value));
            }
        }
        this.numCards = this.cards.size();
    }

    public Deck(String path){
        XMLParser parserV2 = new XMLParser(path);
        this.cards = parserV2.parse();
        this.numCards = this.cards.size();
    }

    public Card dealCard() {
        this.numCards --;
        return this.cards.remove(cards.size() - 1);
    }

    public Card showCard() {
        return this.cards.get(cards.size() - 1);
    }

    public void shuffle() {
        Random random = new Random();

        for (int i = 0 ; i < this.numCards ; i++) {
            int firstIndex = random.nextInt(this.numCards);
            int secondIndex = random.nextInt(this.numCards);

            Collections.swap(this.cards, firstIndex, secondIndex);
        }
    }
}
