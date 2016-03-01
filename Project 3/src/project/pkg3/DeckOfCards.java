package project.pkg3;

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

    static Random rng = new Random();

    static private String suites[] =
    {
        "Clubs", "Hearts", "Spades", "Diamonds"
    };
    static private int values[] =
    {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };
    static private ArrayList<String> discardPile = new ArrayList<String>();

    static public boolean remove = false;
    final static short PAIR = 2;
    final static short SET = 4;
    final static short BOUNDS = 1;
    public static int draws = 0;

    //Get a single random card
    static public String[] getCard()
    {
        String card[] = new String[PAIR];
        card[0] = suites[rng.nextInt(suites.length)];
        card[1] = Integer.toString(values[rng.nextInt(values.length)]);

        return card;
    }

    static public String[] getSet()
    {

        String pick1[] = new String[PAIR];
        String pick2[] = new String[PAIR];
        String pick3[] = new String[PAIR];
        String pick4[] = new String[PAIR];

        String cards[] = new String[SET];

        pick1 = DeckOfCards.getCard();
        draws++;

        do
        {
            do
            {
                if (pick1[0].equalsIgnoreCase(pick2[0]))
                {
                    discardPile.add(pick2[0] + pick2[1]);
                }
                pick2 = DeckOfCards.getCard();
                draws++;
            } while (pick1[0].equalsIgnoreCase(pick2[0]));
        } while (remove && discardPile.contains(pick2[0] + pick2[1]));

        do
        {
            do
            {
                if (pick1[0].equalsIgnoreCase(pick3[0])
                        || pick2[0].equalsIgnoreCase(pick3[0]))
                {
                    discardPile.add(pick3[0] + pick3[1]);
                }
                pick3 = DeckOfCards.getCard();
                draws++;
            } while (pick1[0].equalsIgnoreCase(pick3[0])
                    || pick2[0].equalsIgnoreCase(pick3[0]));
        } while (remove && discardPile.contains(pick3[0] + pick3[1]));

        do
        {
            do
            {
                if (pick1[0].equalsIgnoreCase(pick4[0])
                        || pick2[0].equalsIgnoreCase(pick4[0])
                        || pick3[0].equalsIgnoreCase(pick4[0]))
                {
                    discardPile.add(pick3[0] + pick3[1]);
                }
                pick4 = DeckOfCards.getCard();
                draws++;
            } while (pick1[0].equalsIgnoreCase(pick4[0])
                    || pick2[0].equalsIgnoreCase(pick4[0])
                    || pick3[0].equalsIgnoreCase(pick4[0]));
        } while (remove && discardPile.contains(pick3[0] + pick3[1]));

        cards[0] = pick1[0] + "_" + pick1[1];
        cards[1] = pick2[0] + "_" + pick2[1];
        cards[2] = pick3[0] + "_" + pick3[1];
        cards[3] = pick4[0] + "_" + pick4[1];

        return cards;
    }

    static public boolean checkMultiple(String pick1[], String pick2[], String pick3[], String pick4[])
    {
        if (pick1[0].equalsIgnoreCase(pick2[0]))
        {
            return true;
        } else if (pick1[0].equalsIgnoreCase(pick3[0]))
        {
            return true;
        } else if (pick1[0].equalsIgnoreCase(pick4[0]))
        {
            return true;
        } else if (pick2[0].equalsIgnoreCase(pick3[0]))
        {
            return true;
        } else if (pick2[0].equalsIgnoreCase(pick4[0]))
        {
            return true;
        } else if (pick3[0].equalsIgnoreCase(pick4[0]))
        {
            return true;
        } else
        {
            return false;
        }
    }

    static public void reset()
    {
        draws = 0;
        discardPile.clear();
    }
}