package project.crdpk;

import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class DeckOfCards
{

    //random number generator
    static Random rng = new Random();

    //array of suite names
    final static private String SUITES[] =
    {
        "Clubs", "Hearts", "Spades", "Diamonds"
    };
    //array of card values
    final static private int VALUES[] =
    {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };
    //Storage for already selected cards to prevent them from being redrawn
    static private ArrayList<String> discardPile = new ArrayList<String>();

    //Constants used in the array defintions and logic
    final public static short PAIR = 2;
    final static short SET = 4;
    final static short BOUNDS = 1;

    //counter for cards drawn; publicly exposed
    public static int draws = 0;

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DeckOfCards
     * @File: DeckOfCards.java
     *
     * @author: Kevin Manning
     *
     * @Function: getCard
     * @Title: Get Card
     *
     * @Description: Produces a single random card by calling a random index
     * from the suit and value arrays
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters:n/a
     * @Return: String[] card; one value from each array, as a string
     *
     * @CalledBy: getSet();
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/4/2016
     * @version 1.0
     * @HistoryLog: 3/4/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public String[] getCard()
    {
        String card[] = new String[PAIR];
        card[0] = SUITES[rng.nextInt(SUITES.length)];
        card[1] = Integer.toString(VALUES[rng.nextInt(VALUES.length)]);

        return card;
    }//end getCard

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DeckOfCards
     * @File: DeckOfCards.java
     *
     * @author: Kevin Manning
     *
     * @Function: getSet
     * @Title: Get set
     *
     * @Description: pulls a random card 4 times, each time checking if a card
     * of the same suite has already been pulled. If remove game mode is chosen,
     * also checks if card is a discarded card.
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters:blloean remove; game mode selection
     * @Return: String[] cards;four cards, verified of differing suites
     *
     * @CalledBy: PickCardsGui.go();
     * @Calls: getCard();
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/4/2016
     * @version 1.0
     * @HistoryLog: 3/4/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public String[] getSet(boolean remove)
    {
        //the four cards to be selected
        String pick1[] = new String[PAIR];
        String pick2[] = new String[PAIR];
        String pick3[] = new String[PAIR];
        String pick4[] = new String[PAIR];

        //The set to be returned
        String cards[] = new String[SET];

        //picks the first card, and advances the draw count
        pick1 = getCard();
        draws++;

        //This loop draws a card once, checks if the card is valid, and proceeds accordingly
        do
        {
            //Checks game mode, and if true checks the cards are matching suite
            if (remove && pick1[0].equalsIgnoreCase(pick2[0]))
            {
                //adds card to discard pile
                discardPile.add(pick2[0] + pick2[1]);
            }
            //Grabs a random card
            pick2 = getCard();
            //Only if BOTH remove and discard pile are true is the draw skipped
            if (!remove || !discardPile.contains(pick2[0] + pick2[1]))
            {
                draws++;
            }
            //verifies the card's suite does not match a previously drawn card
        } while (pick1[0].equalsIgnoreCase(pick2[0]));

        //see above
        do
        {
            if (remove && pick1[0].equalsIgnoreCase(pick3[0])
                    || pick2[0].equalsIgnoreCase(pick3[0]))
            {
                discardPile.add(pick3[0] + pick3[1]);
            }
            pick3 = getCard();
            if (!remove || !discardPile.contains(pick3[0] + pick3[1]))
            {
                draws++;
            }
        } while (pick1[0].equalsIgnoreCase(pick3[0])
                || pick2[0].equalsIgnoreCase(pick3[0]));

        //see above
        do
        {
            if (remove && pick1[0].equalsIgnoreCase(pick4[0])
                    || pick2[0].equalsIgnoreCase(pick4[0])
                    || pick3[0].equalsIgnoreCase(pick4[0]))
            {
                discardPile.add(pick3[0] + pick3[1]);
            }
            pick4 = getCard();
            if (!remove || !discardPile.contains(pick3[0] + pick3[1]))
            {
                draws++;
            }
        } while (pick1[0].equalsIgnoreCase(pick4[0])
                || pick2[0].equalsIgnoreCase(pick4[0])
                || pick3[0].equalsIgnoreCase(pick4[0]));

        //Casts all 4 cards to an array to be returned, formatting them to match file structure
        cards[0] = pick1[0] + "_" + pick1[1];
        cards[1] = pick2[0] + "_" + pick2[1];
        cards[2] = pick3[0] + "_" + pick3[1];
        cards[3] = pick4[0] + "_" + pick4[1];

        return cards;
    }//end getSet

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DeckOfCards
     * @File: DeckOfCards.java
     *
     * @author: Kevin Manning
     *
     * @Function: reset
     * @Title: reset
     *
     * @Description: clears the draw counter and discard pile
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return: n/a
     *
     * @CalledBy: PickCardsGui.go();
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/4/2016
     * @version 1.0
     * @HistoryLog: 3/4/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public void reset()
    {
        draws = 0;
        discardPile.clear();
    }//end reset
}//end class