package com.varren.matchismo.Model;

import java.util.ArrayList;

/**
 * Created by Peter on 30.01.14.
 */
public class Card {
    public String contents;
    public Boolean unplayable;
    public Boolean faceUp;

    public int match(ArrayList<Card> otherCards){
        int score = 0;
        if(otherCards != null){
            for(Card card : otherCards)
                if(card.contents.equals(this.contents))
                    score++;

        }

        return score;
    }

}
