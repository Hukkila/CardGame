package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {


    @Test public void testPlayersStartValueZero()
    {
        Deck d = new Deck();
        int zero = 0;
        Assertions.assertEquals(zero, d.cardsValue());
    }


    @Test public void cheatCheck()
    {
        Game G = new Game();
        G.setGamblerMoney(100);
        G.setGamblerBet(115);

        if (G.getGamblerBet() > G.getGamblerMoney())
        {
            System.out.println("Are you trying to cheat? Get out of my Casino your useless scum!");
        }
    }


    @Test public void MoneyCheckWithGambler()
    {
        Game G = new Game();
        int Money = 100;
        Assertions.assertEquals(Money, G.getGamblerMoney());
    }


    @Test public void outOfMoney()
    {
        Game G = new Game();
        int data = 0;
        G.setGamblerMoney(0);
        Assertions.assertEquals(data, G.getGamblerMoney());

        if (G.getGamblerMoney() <= 0)
        {
            System.out.println("No Money left! Go to bank and get a loan so we can continue");
        }
    }


    @Test public void GamblerWin()
    {
        Game G = new Game();
        int GBet = 0;
        Assertions.assertEquals(GBet, G.getGamblerBet());
    }




}