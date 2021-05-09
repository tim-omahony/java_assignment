package assignment;

import java.util.Scanner;

public class Game {
    //method prompts the user for an input and calls different functions depending on the input
    public static void gameChoice(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n===== Enter the game you would like to play ('1', '2', or '3' to quit) we only have rock paper scissors or flipping a coin atm sorry ===== \n1. Rock paper scissors \n2. Coin flip \n3. Main Menu");
        String gameNo = in.next();
        switch (gameNo) {
            case "1":
                rockPaperScissors(player);
                break;
            case "2":
                coinFlip(player);
                break;
            case "3":
                System.out.println("See you next time " + player.getName() + " :)");
                Menu.mainMenu();
                break;
            default:
                System.out.println("Please enter either 1, 2, or 3");
                gameChoice(player);
        }
    }


    public static void rockPaperScissors(Player player) {
        int totalPlayed = 0;
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
                System.out.println("I don't think that's a move you can make in rock paper scissors my guy :/ (please enter either 'rock', 'paper', 'scissors' or 'quit')");
            }else {
                //Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2 (rock, paper or scissors)
                int randRPS = (int)(Math.random()*3);
                //Convert the random number to a string using conditionals and print the computer's move
                String computerMoveRPS;
                if(randRPS == 0) {
                    computerMoveRPS = "rock";
                } else if(randRPS == 1) {
                    computerMoveRPS = "paper";
                } else {
                    computerMoveRPS = "scissors";
                }
                System.out.println("Computer's move was " + computerMoveRPS);
                if (playerMoveRps.equals(computerMoveRPS)){
                    System.out.println("It's a tie :o");
                }
                else if((playerMoveRps.equals("rock") && computerMoveRPS.equals("scissors")) ||
                        (playerMoveRps.equals("scissors") && computerMoveRPS.equals("paper")) ||
                        (playerMoveRps.equals("paper") && computerMoveRPS.equals("rock"))) {
                    System.out.println("You win! +10 points :)");
                    player.setPoints(10);
                } else {
                    System.out.println("You lost, -5 points :(");
                    player.setPoints(-5);
                //if the player is a limited player they are set a limit of 5 games for each round, after which they are sent back to the main menu
                }if (player instanceof LimitedPlayer){
                    totalPlayed += 1;
                    System.out.println("Games played: " + totalPlayed);
                    if (totalPlayed == 5) {
                        System.out.println("You're a limited player :( you've reached your game limit for this round sorry :(");
                        Menu.mainMenu();
                        break;
                    }
                }
            }
        }
    }


    public static void coinFlip(Player player) {
        int totalPlayed = 0;
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
                System.out.println("pretty sure you can't do that in a coin flip, try again pal :/ (please enter either 'heads', 'tails', or 'quit')");
            }else {
                //Get a random number in between 0 and 2 and convert it to an integer so that the possibilities are 0, or 1 (heads or tails)
                int randCoin = (int)(Math.random()*2);
                //Convert the random number to a string using conditionals and print the result of the flip
                String computerMoveCoin = null;
                if(randCoin == 0) {
                    computerMoveCoin = "heads";
                } else if(randCoin == 1) {
                    computerMoveCoin = "tails";
                }
                System.out.println("The coin landed on ..... *drumroll* ..... " + computerMoveCoin + "!");
                if (playerMoveCoin.equals(computerMoveCoin)){
                    System.out.println("You win! +6 points :)");
                    player.setPoints(6);
                } else {
                    System.out.println("You lost, -2 points :(");
                    player.setPoints(-2);
                }if (player instanceof LimitedPlayer){
                    totalPlayed += 1;
                    System.out.println("Games played: " + totalPlayed);
                    if (totalPlayed == 5) {
                        System.out.println("You're a limited player :( you've reached your game limit for this round sorry :(");
                        Menu.mainMenu();
                        break;
                    }
                }
            }
        }
    }
}
