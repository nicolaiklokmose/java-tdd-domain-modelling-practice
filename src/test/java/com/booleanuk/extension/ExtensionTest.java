package com.booleanuk.extension;

import com.booleanuk.PlayingCards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class ExtensionTest {

    @Test
    public void testInitializeCards() {
        PlayingCards pc = new PlayingCards();
        Assertions.assertNotNull(pc.cards);
        Assertions.assertEquals(pc.cards.size(), 52);
        Assertions.assertEquals(pc.cards.size(), new HashSet<>(pc.cards).size());
    }

    @Test
    public void testShuffleCards() {
        PlayingCards pc = new PlayingCards();
        // Don't know how to test this
    }

    @Test
    public void testCurrentState() {
        PlayingCards pc = new PlayingCards();
        // Don't know how to test this
    }

    @Test
    public void testCreateHand() {
        PlayingCards pc = new PlayingCards();
        // Don't know how to test this, weird error with Card
    }

    @Test
    public void testDealFourHandsFiveCards() {
        PlayingCards pc = new PlayingCards();
    }

    @Test
    public void testViewTopCard() {
        PlayingCards pc = new PlayingCards();
    }

    @Test
    public void testCutCards() {
        PlayingCards pc = new PlayingCards();
    }




}
