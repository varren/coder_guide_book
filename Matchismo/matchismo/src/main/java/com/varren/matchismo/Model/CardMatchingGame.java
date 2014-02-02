package com.varren.matchismo.Model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Peter on 30.01.14.
 */
public class CardMatchingGame {
    private static final int DEFAULT_GAME_MODE = 1;
    private static final int FLIP_COST = 1;
    private static final int MATCH_BONUS = 4;
    private static final int MISMATCH_PENALTY = 2;


    private int score = 0;
    private int lastTurnScore = 0;

    private ArrayList<Card> cards = new ArrayList<Card>();
    private int mode = DEFAULT_GAME_MODE;

    private CardMatchingGame(){}
    public CardMatchingGame(int cardsCount, Deck deck) throws Exception{
        for(int i =0; i< cardsCount; i++){
            Card card = deck.drawRandomCard();
            if(card != null)
                cards.add(card);
            else
                throw new Exception();

        }
    }

    public void flipCardAtIndex(int index){
        Card card = cards.get(index);
        if(!card.unplayable){
            if(!card.faceUp){
                ArrayList<Card> cardsToCompare = new ArrayList<Card>();
                for(Card otherCard: cards)
                    if(otherCard.faceUp && !otherCard.unplayable)
                        cardsToCompare.add(otherCard);

                if(cardsToCompare.size() == mode - 1){
                   lastTurnScore = calculateMatchPointsFor(card, cardsToCompare);
                   score += lastTurnScore;
                }
                score -= FLIP_COST;
            }
            card.faceUp = !card.faceUp;
        }
    }

    private int calculateMatchPointsFor(Card card, ArrayList<Card>otherCards){
        int matchScore = card.match(otherCards);

        if(matchScore == 0){
            matchScore += MISMATCH_PENALTY;
        } else if(matchScore > 0){
            matchScore *= MATCH_BONUS;
        }

        return matchScore;
    }

    public Card cardAtIndex(int index){
        return (cards.size() > index || index < 0) ? cards.get(index) : null;
    }

    public void setMode(int mode){
        if (mode > 0) this.mode = mode;
        else Log.e("in CardMatchingGame","setMode cant set modes 0 or less");
    }
    public  int getCurrentScore(){
        return score;
    }

    public int getLastTurnScore(){
        return lastTurnScore;
    }
}
