package com.booleanuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayingCards {

    public List<Card> cards;

    public PlayingCards() {
        this.cards = new ArrayList<>();
        initializeCards();
        shuffleCards();
        // moved to main for testing purposes
        //startProgram();
    }

    public void initializeCards() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void startProgram() {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Please select one of the following options, 7 to exit)");
            System.out.println("(1): Show the current state of the cards");
            System.out.println("(2): Shuffle the cards in-place :)");
            System.out.println("(3): Decide how many cards you want to deal");
            System.out.println("(4): Deal four hands of five cards");
            System.out.println("(5): Show the top card of the playing cards");
            System.out.println("(6): Specify a place to cut and view top card");
            System.out.println("(7): Get me out of here POGGERS");
            System.out.println();

            input = sc.nextInt();
            switch (input) {
                case 1:
                    currentState();
                    break;
                case 2:
                    shuffleCards();
                    break;
                case 3:
                    System.out.println("How many cards should I deal?");
                    input = sc.nextInt();
                    createHand(input);
                    break;
                case 4:
                    dealFourHandsFiveCards();
                    break;
                case 5:
                    viewTopCard();
                    break;
                case 6:
                    System.out.println("Where do you want to cut?");
                    input = sc.nextInt();
                    cutCards(input);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("It's 11pm, I'm so done ..");
                    break;
            }
        }
    }

    public void currentState() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public void createHand(int cards) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < cards; i++) {
            hand.add(this.cards.get(i));
        }
        System.out.println("You got dealt these cards:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void dealFourHandsFiveCards() {
        List<List<Card>> hands = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            List<Card> hand = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                hand.add(this.cards.get(counter++));
            }
            hands.add(hand);
        }
        int handCounter = 0;
        for (List<Card> hand : hands) {
            System.out.println("Hand no. " + ++handCounter + ":");
            System.out.println(hand);
        }
    }

    public void viewTopCard() {
        System.out.println("The top card dealt is: ");
        System.out.println(this.cards.get(0).toString());
    }

    public void cutCards(int cut) {
        System.out.println("The card where you cut is: ");
        System.out.println(this.cards.get(cut).toString() + " is card no. " + cut);
    }

    public static void main(String[] args) {
        PlayingCards pc = new PlayingCards();
        pc.startProgram();
        // System.out.println(pc.cards.get(0));

        //System.out.println("Shuffled Deck:");
        //
        //}
    }
}
