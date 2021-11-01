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

    @Test public void MoneyCheckWithGambler()
    {
        Game G = new Game();
        int Money = 100;
        Assertions.assertEquals(Money, G.getGamblerMoney());
    }

    @Test public void GamblerWin()
    {
        Game G = new Game();
        int GBet = 10;
        Assertions.assertEquals(GBet, G.getGamblerBet());

    }

}