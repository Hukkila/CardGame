package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {


    @Test public void testPlayersStartValueZero(){
        Deck d = new Deck();
        int zero = 0;
        Assertions.assertEquals(zero, d.cardsValue());
    }

    @Test public void testIfDealerGetsFat()
    {
    //Deck d = new Deck();
    //Game game = new Game(gamblerBet);
    //game.getDealerDeck();

    }
    @Test public void main()
    {
        Main main = new Main();
        Deck d = new Deck();
        int cardsValue = 22;
        Boolean endround = false;
        if(cardsValue > 21){

        endround = true;
        }
    }

}