package com.company;

import java.util.Random;

public class CardDeck {

    static int[] cards = {

            1, 2, 3, 4, 5, 6, 7, 8, 9, 10

    };


    public static int Draw(){
        int rnd1 = new Random().nextInt(cards.length);

        while(rnd1 < 1) { //This while loop will prevent rnd1 being 0

            rnd1 = new Random().nextInt(cards.length);
        }

        System.out.println(rnd1);
        return rnd1;



    }

}
