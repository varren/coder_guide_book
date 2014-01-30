package com.varren.matchismo.Model;

import java.util.ArrayList;

/**
 * Created by Peter on 30.01.14.
 */
public class Deck {
    protected ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();

    }

    public void addCard(Card card, Boolean atTop){
        if(atTop){
            cards.add(0,card);

        }else{
            cards.add(card);
        }

    }

    public Card drawRandomCard(){
        Card randomCard = null;
        if(cards.size() > 0){
            int index = (int) Math.abs(Math.random() % cards.size());
            randomCard = cards.get(index);
            cards.remove(index);
        }
        return randomCard;
    }

}
