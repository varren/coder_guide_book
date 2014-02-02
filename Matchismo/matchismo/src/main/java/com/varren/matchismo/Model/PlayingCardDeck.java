package com.varren.matchismo.Model;

/**
 * Created by Peter on 30.01.14.
 */
public class PlayingCardDeck extends Deck {

    public PlayingCardDeck(){
        for(String suit: PlayingCard.validSuits()){
            for(int rank = 1; rank<=PlayingCard.maxRank();rank++){
                PlayingCard card = new PlayingCard();
                card.setRank(rank);
                card.setSuit(suit);
                addCard(card, true);
            }
        }

    }
}
