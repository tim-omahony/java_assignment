package assignment;
import java.util.*;
public class Game {
    public static void coinFlip(Player player) {
        Scanner CFin = new Scanner(System.in);
        System.out.println(" ===== Welcome to Coin Flip! ===== ");
        while (true) {
            //Get the user's move through user input
            System.out.println("Please enter either:\nheads \ntails \nquit");
            String playerMoveCoin = CFin.next();
            if (playerMoveCoin.equals("quit")) {
                System.out.println("Thanks for playing rock paper scissors :)");
                Menu.gameChoice(player);
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
                    System.out.println("You lost, -10 points :(");
                    player.setPoints(-10);
                }
            }
        }
    }


    public static void rockPaperScissors(Player player) {
        Scanner RPSin = new Scanner(System.in);
        System.out.println(" ===== Welcome to Rock Paper Scissors! ===== ");
        //Use a while(true) loop and only break the loop if the user wants to quit
        while(true) {
            //Get the user's move through user input
            System.out.println("Please enter either:\nrock \npaper \nscissors \nquit");
            String playerMoveRps = RPSin.next();
            if (playerMoveRps.equals("quit")) {
                System.out.println("Thanks for playing rock paper scissors :)");
                Menu.gameChoice(player);
                break;
            }
//            //Check if the user's move is valid (rock, paper, or scissors)
//            if(!(playerMove == 1) && !(playerMove == 2) && !(playerMove == 3)){
            if (!playerMoveRps.equals("rock") && !playerMoveRps.equals("paper") && !playerMoveRps.equals("scissors")){
                System.out.println("I don't think that's a move you can make in rock paper scissors my guy :/");
            }else {
                //Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2
                int rand = (int)(Math.random()*3);
                //Convert the random number to a string using conditionals and print the opponent's move
                String computerMove = " ";
                if(rand == 0) {
                    computerMove = "rock";
                } else if(rand == 1) {
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
                    System.out.println("You lost, -10 points :(");
                    player.setPoints(-10);
                }
            }
        }
    }
}
