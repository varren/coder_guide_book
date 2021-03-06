package com.varren.matchismo.Model;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Peter on 30.01.14.
 */
public class PlayingCard extends Card{
    private static ArrayList<String> validSuitsArray = new ArrayList<String>(
            Arrays.asList("♥", "♦", "♠", "♣"));
    private static ArrayList<String> rankStringsArray = new ArrayList<String>(
            Arrays.asList("?", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));

    private String suit;
    private int rank;

    public String getSuit(){
        return suit == null ? "?": suit;
    }

    public void setSuit(String suit){
        if(validSuits().contains(suit)){
            this.suit = suit;
        }
    }

    public int getRank(){
        return rank;
    }

    public void setRank(int rank){
        if(rank <= maxRank() && rank >= 0){
            this.rank = rank;
        }
    }


    public static ArrayList<String>validSuits(){
        return validSuitsArray;
    }

    private static ArrayList<String> rankStrings(){
        return rankStringsArray;
    }

    public static int maxRank(){
        return rankStrings().size() - 1;
    }

    private String contents(){
        return rankStringsArray.get(rank) + suit;
    }

    @Override
    public int match(ArrayList<Card> otherCards){
        int score = 0;
        if(otherCards != null && otherCards.size()==1){
            if(otherCards.get(0) instanceof PlayingCard){
                PlayingCard otherCard = (PlayingCard)otherCards.get(0);
                if(otherCard.suit.equals(this.suit)){
                    score = 1;
                }else if (otherCard.rank == this.rank){
                    score = 4;
                }
            }
        }
        return score;
    }

}
