package com.company;

import java.util.Scanner;

public class Game {
    private Deck Cards;
    private Deck GamblerDeck;
    private Deck DealerDeck;
    private int GamblerBet;
    private int GamblerMoney;
    private Scanner userInput;


    public Game() {
        System.out.println("Welcome to Blackjack");
        Cards = new Deck();
        Cards.createFullDeck();
        Cards.shuffle();
        GamblerBet = 10;
        GamblerDeck = new Deck();
        DealerDeck = new Deck();
        DealerDeck.cardsValue();

        GamblerMoney = 100;

        userInput = new Scanner(System.in);
    }

    public byte run() {
        while (GamblerMoney > 0) {
            //boolean endRound = false;
            int GamblerBet = playerInfo();
            int cardsValue = DealerDeck.cardsValue();
            if (GamblerBet < 0) {
                break;
            }
            dealCards();
            playRound();
        }
        return 0;
    }

    private void playRound() {
        while (true) {
            System.out.println("Your hand");
            System.out.println(GamblerDeck.toString());
            System.out.println("Your deck is valued at: " + GamblerDeck.cardsValue());
            System.out.println("Would you like to (1)Hit or (2)Stand?");
            int response = userInput.nextInt();
            hitOrStand(response);
            lowCards(response);
            System.out.println("Dealer Cards: " + DealerDeck.toString());
            DealerSmallValue();
            System.out.println("Dealer's Hand is valued at: " + DealerDeck.cardsValue());
            DealerGetsFat();
            DealerWin();
            tieCards();
            GamblerWinOrLose();
            GamblerDeck.moveAllToDeck(Cards);
            DealerDeck.moveAllToDeck(Cards);
            break;
        }
    }
    private void hitOrStand(int response) {
        if (response == 1) {
            GamblerDeck.draw(Cards);
            System.out.println("You draw a: " + GamblerDeck.getCard(GamblerDeck.deckSize() - 1).toString());
            System.out.println("Currently valued at: " + GamblerDeck.cardsValue());
            if (GamblerDeck.cardsValue() > 21) {
                System.out.println("Bust. Currently valued at: " + GamblerDeck.cardsValue());
                GamblerMoney -= GamblerBet;
            }
        }
    }
    private void lowCards(int response){
        if ((GamblerDeck.cardsValue() < 21)) {
            System.out.println("Would you like one more card?");
            if (response == 1) {
                GamblerDeck.draw(Cards);
                System.out.println("You draw a: " + GamblerDeck.getCard(GamblerDeck.deckSize() - 1).toString());
                System.out.println("Currently valued at: " + GamblerDeck.cardsValue());
            }
        }
    }

    private void DealerSmallValue() {
        while ((DealerDeck.cardsValue() < 17)) {
            DealerDeck.draw(Cards);
            System.out.println("Dealer Draws: " + DealerDeck.getCard(DealerDeck.deckSize() - 1).toString());
        }
    }

    private void DealerGetsFat() {
        if ((DealerDeck.cardsValue() > 21)) {
            System.out.println("Dealer Busts! You win");
            GamblerMoney += GamblerBet;
        }
    }

    private void DealerWin() {
        if ((DealerDeck.cardsValue() > GamblerDeck.cardsValue())) {
                System.out.println("Dealer Beats you!");
                GamblerMoney -= GamblerBet;
        }
    }

    private void tieCards() {
        if ((GamblerDeck.cardsValue() == DealerDeck.cardsValue())) {
            System.out.println("TieGame, you get your money back");
        }
    }

    private void GamblerWinOrLose() {
        if ((GamblerDeck.cardsValue() > DealerDeck.cardsValue())) {
            System.out.println("You win the hand!");
            GamblerMoney += GamblerBet;
        }
        else if ((GamblerDeck.cardsValue() < DealerDeck.cardsValue())) {
            System.out.println("You lose the hand");
            GamblerMoney -= GamblerBet;
        }
        GamblerDeck.moveAllToDeck(Cards);
        DealerDeck.moveAllToDeck(Cards);
        System.out.println("End of hand");
    }

    private void dealCards() {
        GamblerDeck.draw(Cards);
        GamblerDeck.draw(Cards);

        DealerDeck.draw(Cards);
        DealerDeck.draw(Cards);
    }

    private int playerInfo() {
        System.out.println("You have $" + GamblerMoney + ",how much would you like to bet?");
        int GamblerBet = userInput.nextInt();
        if (GamblerBet > GamblerMoney) {
            System.out.println("Are you trying to cheat? Get out of my Casino your useless scum!");
            return 0;
        }
        return GamblerBet;
    }

    public Deck getCards() {
        return Cards;
    }

    public void setCards(Deck cards) {
        Cards = cards;
    }

    public Deck getGamblerDeck() {
        return GamblerDeck;
    }

    public void setGamblerDeck(Deck gamblerDeck) {
        GamblerDeck = gamblerDeck;
    }

    public Deck getDealerDeck() {
        return DealerDeck;
    }

    public void setDealerDeck(Deck dealerDeck) {
        DealerDeck = dealerDeck;
    }

    public double getGamblerMoney() {
        return GamblerMoney;
    }

    public void setGamblerMoney(int gamblerMoney) {
        GamblerMoney = gamblerMoney;
    }

    public int getGamblerBet() {
        return GamblerBet;
    }
}