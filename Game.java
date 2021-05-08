package assignment;

import java.util.Random;
import java.util.Scanner;

public class Game {
    //method prompts the user for an input and calls different functions depending on the input
    public static void gameChoice(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println(" ===== Enter the game you would like to play (we only have rock paper scissors or flipping a coin atm sorry) ===== \n1. Rock paper scissors \n2. Coin flip \n3. Main Menu");
        int gameNo = in.nextInt();
        if (gameNo == 1){
            rockPaperScissors(player);
        }
        else if (gameNo == 2) {
            coinFlip(player);
        }
        else if (gameNo == 3) {
            System.out.println("See you next time " + player.getName() + " :)");
            Menu.mainMenu();
        }
    }

    public static void coinFlip(Player player) {
        Scanner CFin = new Scanner(System.in);
        System.out.println(" ===== Welcome to Coin Flip! ===== ");
        //Use a while loop and only exit the loop if the user wants to quit
        while (true) {
            //Get the user's move through user input
            System.out.println("Please enter either:\nheads \ntails \nquit");
            String playerMoveCoin = CFin.next();
            if (playerMoveCoin.equals("quit")) {
                System.out.println("Thanks for playing rock paper scissors :)");
                gameChoice(player);
                break;
            }
            if (!playerMoveCoin.equals("heads") && !playerMoveCoin.equals("tails")){
                System.out.println("pretty sure you can't do that in a coin flip, try again pal :/");
            }else {
                //Get a random number in between 0 and 2 and convert it to an integer so that the possibilities are 0, or 1 (heads or tails)
                int randCoin = (int)(Math.random()*2);
                //Convert the random number to a string using conditionals and print the result of the flip
                String[] options = new String[]{"heads", "tails"};
                Random rand = new Random();
                String computerMoveCoin = " ";
                if(randCoin == 0) {
                    computerMoveCoin = "heads";
                } else if(randCoin == 1) {
                    computerMoveCoin = "tails";
                }
                System.out.println("The coin landed on ..... *drumroll* ..... " + computerMoveCoin + "!");
                if (playerMoveCoin.equals(computerMoveCoin)){
                    System.out.println("You win! +10 points :)");
                    player.setPoints(10);
                } else {
                    System.out.println("You lost, -2 points :(");
                    player.setPoints(-2);
                }
            }
        }
    }


    public static void rockPaperScissors(Player player) {
        Scanner RPSin = new Scanner(System.in);
        System.out.println(" ===== Welcome to Rock Paper Scissors! ===== ");
        while(true) {
            //Get the user's move through user input
            System.out.println("Please enter either:\nrock \npaper \nscissors \nquit");
            String playerMoveRps = RPSin.next();
            if (playerMoveRps.equals("quit")) {
                System.out.println("Thanks for playing rock paper scissors :)");
                gameChoice(player);
                break;
            }
//            //Check if the user's move is valid (rock, paper, or scissors)
            if (!playerMoveRps.equals("rock") && !playerMoveRps.equals("paper") && !playerMoveRps.equals("scissors")){
                System.out.println("I don't think that's a move you can make in rock paper scissors my guy :/");
            }else {
                //Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2 (rock, paper or scissors)
                int randRPS = (int)(Math.random()*3);
                //Convert the random number to a string using conditionals and print the computer's move
                String computerMove = " ";
                if(randRPS == 0) {
                    computerMove = "rock";
                } else if(randRPS == 1) {
                    computerMove = "paper";
                } else {
                    computerMove = "scissors";
                }
                System.out.println("Computer's move was " + computerMove);
                if (playerMoveRps.equals(computerMove)){
                    System.out.println("It's a tie :o");
                }
                else if((playerMoveRps.equals("rock") && computerMove.equals("scissors")) || (playerMoveRps.equals("scissors") && computerMove.equals("paper")) || (playerMoveRps.equals("paper") && computerMove.equals("rock"))) {
                    System.out.println("You win! +10 points :)");
                    player.setPoints(10);
                } else {
                    System.out.println("You lost, -5 points :(");
                    player.setPoints(-5);
                }
            }
        }
    }
}
