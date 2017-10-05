package com.example.emilydaskas.cards;

/**
 * Created by emilydaskas on 10/5/17.
 */

public class CardDeck {
    public enum Suit {
        SPADE, CLUB, HEART, DIAMOND
    }

    public String number;
    public Suit suit;

    public CardDeck(String number, Suit suit)
    {
        this.number = number;
        this.suit = suit;
    }

    public String getNumber()
    {
        return number;
    }
    public Suit getSuit()
    {
        return suit;
    }
}

