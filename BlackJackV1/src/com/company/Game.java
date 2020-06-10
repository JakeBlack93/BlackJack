package com.company;

import java.util.Scanner;

public class Game {

    public void newGame(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + "Welcome to Blackjack. Please enter your name: ");
        String PlayerName = scan.nextLine();


        //Start Game logic
        Dealer dealer = new Dealer();
        Player player = new Player();
        CardDeck cardDeck = new CardDeck();

        player.setName(PlayerName); //Set Player Name
        player.setMoney(5000); //Set starting money
        player.setScore(0); //Set Player score
        dealer.setScore(0); //Set Dealer score


        System.out.println(PlayerName + " draws: ");

        player.setScore(cardDeck.Draw()); //Sets the player score to the card value returned from card draw
        player.setScore(player.getScore() + cardDeck.Draw()); // Sets the player score to whatever the current score is plus value returned from new draw.

        System.out.println("Current Score: " + player.getScore());


        while (player.getScore() < 22 ){

            System.out.println("Would you like to twist or stick?: ");
            String Choice = scan.nextLine();
            if (Choice.equals("twist")) {

                player.setScore(player.getScore() + cardDeck.Draw());
                System.out.println("Current Score: " + player.getScore());

            }

            if(Choice.equals("stick")) {

                break;

            }

        }

        if (player.getScore() >= 22) {

            System.out.println("BUST! Game Over. ");

            System.out.println("Would you like to play again? Yes or No ");
            String PlayAgainOption = scan.nextLine();

            if (PlayAgainOption.equals("Yes")){

                newGame();
            }
            System.out.println("Thank you for playing! :) ");
            System.exit(0);


        }



        while (dealer.getScore() < 22) {

            dealer.setScore(dealer.getScore() + cardDeck.Draw());
            System.out.println("Dealer Score: " + dealer.getScore());

            if (dealer.getScore() >= player.getScore() & dealer.getScore() < 22 ) {

                System.out.println("Dealer Wins!");

                System.out.println("Would you like to play again? Yes or No ");
                String PlayAgainOption = scan.nextLine();

                if (PlayAgainOption.equals("Yes")){

                    newGame();
                }
                System.out.println("Thank you for playing! :) ");
                System.exit(0);

            }

        }


        System.out.println("Player Wins!");

        System.out.println("Would you like to play again? Yes or No ");
        String PlayAgainOption = scan.nextLine();

        if (PlayAgainOption.equals("Yes")){

            newGame();
        }

        System.out.println("Thank you for playing! :) ");

    }
}
