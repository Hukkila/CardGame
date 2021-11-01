package com.company;

import java.util.Scanner;

public class Game {
    private Deck Cards;
    private Deck GamblerDeck;
    private Deck DealerDeck;
    private int GamblerBet;
    private int GamblerMoney;
    private Scanner userInput;



    public Game()
    {
        System.out.println("Welcome to Blackjack");
        Cards = new Deck();
        Cards.createFullDeck();
        Cards.shuffle();
        GamblerDeck = new Deck();
        DealerDeck = new Deck();
        GamblerMoney = 100;
        userInput = new Scanner(System.in);

    }


    public void run()
    {
        while (GamblerMoney > 0)
        {
            paus(2000);
            int GamblerBet = playerInfo();
            if (GamblerBet < 0)
            {
                break;
            }
            dealCards();
            playRound();
            winOrLoose();
        }
    }

    private void playRound()
    {
        while (true)
        {
            System.out.println("Your hand");
            paus(1000);
            System.out.println(GamblerDeck.toString());
            paus(1500);
            System.out.println("Your deck is valued at: " + GamblerDeck.cardsValue());
            paus(1500);
            System.out.println("Would you like to (1)Hit or (2)Stand?");
            int response = userInput.nextInt();
            paus(1000);
            hitOrStand(response);
//            GamblerGetsFat();
            paus(1000);
            System.out.println("Your deck is valued at: " + GamblerDeck.cardsValue());
            paus(1000);
            hitOrBust();
            paus(1500);
            response = userInput.nextInt();
            GamblerLowCards(response);
            paus(1500);
            System.out.println("Dealer Cards: " + DealerDeck.toString());
            paus(1500);
            System.out.println("Dealer's Hand is valued at: " + DealerDeck.cardsValue());
            paus(1500);
            break;
        }
    }


    public void winOrLoose()
    {
        while (true)
        {
            DealerSmallValue();
            DealerGetsFat();
            GamblerGetsFat();
            TieGame();
            bothHigh();
            GamblerOrDealerWin();
            outOfMoney();
            GamblerDeck.moveAllToDeck(Cards);
            DealerDeck.moveAllToDeck(Cards);
            break;
        }
    }


    public static void paus(int time)
    {
        try {
            Thread.sleep(time);
        } catch (Exception e) {}
    }



    private void hitOrBust()
    {
        if (GamblerDeck.cardsValue() >21)
        {
            System.out.println("You bust. Type(2) to continue");
        }
        if (GamblerDeck.cardsValue()<= 21)
        {
            System.out.println("Would you like to (1)Hit or (2)Stand?");
        }
    }


    private void outOfMoney()
    {
        if (GamblerMoney <= 0)
        {
            System.out.println("No Money left! Go to bank and get a loan so we can continue");
        }
    }


    private void hitOrStand(int response)
    {

        if (response == 1)
        {
            GamblerDeck.draw(Cards);
            System.out.println("You draw a: " + GamblerDeck.getCard(GamblerDeck.deckSize() - 1).toString());
            System.out.println("Currently valued at: " + GamblerDeck.cardsValue());
        }
        if (response == 2)
        {
            System.out.println("Are You sure that you want to stand?");
        }
    }


    private void GamblerLowCards(int response)
    {
        if (response == 1) {
            paus(1000);
            GamblerDeck.draw(Cards);
            paus(1000);
            System.out.println("You draw a: " + GamblerDeck.getCard(GamblerDeck.deckSize() - 1).toString());
            paus(1000);
            System.out.println("Currently valued at: " + GamblerDeck.cardsValue());
        }
        if (response == 2) {
            System.out.println("Ok lets see the Dealers Cards");
        }
    }


    private void GamblerGetsFat(){
        if (GamblerDeck.cardsValue() > 21)
        {
            paus(1000);
            System.out.println("You Bust at Value: " + GamblerDeck.cardsValue() + " ,Dealer Win");
            GamblerMoney -= GamblerBet;
        }
    }


    private void DealerSmallValue()
    {
        while ((DealerDeck.cardsValue() < 17))
        {
            paus(1000);
            DealerDeck.draw(Cards);
            paus(1000);
            System.out.println("Dealer Draws: " + DealerDeck.getCard(DealerDeck.deckSize() - 1).toString());
            paus(1000);
            System.out.println("Dealer's Hand is valued at: " + DealerDeck.cardsValue());
        }
    }


    private void DealerGetsFat()
    {
        if ((DealerDeck.cardsValue() > 21))
        {
            paus(1000);
            System.out.println("Dealer Busts!");
            GamblerMoney += GamblerBet;
        }
    }


    private void bothHigh()
    {
        if (GamblerDeck.cardsValue() > 21 && DealerDeck.cardsValue() >21) {
            paus(1000);
            System.out.println("No one wins");
        }
    }


    private void TieGame()
    {
        if (GamblerDeck.cardsValue() == DealerDeck.cardsValue())
        {
            paus(1000);
            System.out.println("Tie Game, Play Again");

        }
    }


    private void GamblerOrDealerWin()
    {
        if (GamblerDeck.cardsValue() > DealerDeck.cardsValue() && GamblerDeck.cardsValue() < 22)
        {
            paus(1000);
            System.out.println("You win the hand!");
            GamblerMoney += GamblerBet;

        }
        else if (DealerDeck.cardsValue() > GamblerDeck.cardsValue() && DealerDeck.cardsValue() <22)
        {
            paus(1000);
            System.out.println("You lose the hand");
            GamblerMoney -= GamblerBet;
        }
        GamblerDeck.moveAllToDeck(Cards);
        DealerDeck.moveAllToDeck(Cards);
        paus(1000);
        System.out.println("Round over");
    }


    private void dealCards()
    {
        GamblerDeck.draw(Cards);
        GamblerDeck.draw(Cards);

        DealerDeck.draw(Cards);
        DealerDeck.draw(Cards);
    }


    private int playerInfo()
    {
        System.out.println("You have $" + GamblerMoney + ",how much would you like to bet?");
        GamblerBet = userInput.nextInt();
        if (GamblerBet > GamblerMoney)
        {
            System.out.println("Are you trying to cheat? Get out of my Casino your useless scum!");
            return 0;
        }
        return GamblerBet;
    }


    public Deck getCards()
    {
        return Cards;
    }


    public void setCards(Deck cards)
    {
        Cards = cards;
    }


    public Deck getGamblerDeck()
    {
        return GamblerDeck;
    }


    public void setGamblerDeck(Deck gamblerDeck)
    {
        GamblerDeck = gamblerDeck;
    }


    public Deck getDealerDeck()
    {
        return DealerDeck;
    }


    public void setDealerDeck(Deck dealerDeck)
    {
        DealerDeck = dealerDeck;
    }


    public double getGamblerMoney()
    {
        return GamblerMoney;
    }


    public void setGamblerMoney(int gamblerMoney)
    {
        GamblerMoney = gamblerMoney;
    }


    public int getGamblerBet()
    {
        return GamblerBet;
    }
}