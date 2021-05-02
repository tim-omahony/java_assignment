package assignment;
import java.util.*;
public class menu {
    public static boolean mainMenu(int start) throws Exception{
        if (start == 1){
            System.out.println("Let's get started :)");
            return true;
        }
        else if (start == 2) {
            System.out.println("See you next time!");
            return false;
        }
        else {
            throw new Exception("Please enter either 'start' or 'quit'");
        }
    }
    public static void coinFlip(int game){
        Scanner CFin = new Scanner(System.in);
        System.out.println("Welcome to Coin Flip!");
    }
    public static void rockPaperScissors(int game){
        //Initialize the Scanner and print a welcome message
        Scanner RPSin = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");
        //Use a while(true) loop and only break the loop if the user wants to quit
        while(true) {
            //Get the user's move through user input
            System.out.println("1. Rock \n 2. Paper \n 3. Scissors \n -1. Quit");
            int playerMove = RPSin.nextInt();
            if(playerMove == -1) {
                break;
            }
            //Check if the user's move is valid (rock, paper, or scissors)
            if(!(playerMove == 1) && !(playerMove == 2) && !(playerMove == 3)){
                System.out.println("I don't think that's a move you can make in rock paper scissors my guy :/");
            } else {
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

                //Print the results of the game: tie, lose, win
                if(playerMove = computerMove) {
                    System.out.println("It's a tie!");
                } else if((playerMove == 1 && computerMove.equals("scissors")) || (playerMove == 2 && computerMove.equals("paper")) || (playerMove == 3 && computerMove.equals("rock"))) {
                    System.out.println("You won!");
                } else {
                    System.out.println("You lost!");
                }
            }
        }
        System.out.println("Thanks for playing rock paper scissors :)");
    }


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! \n 1. Start \n 2. Quit ");
        int start = input.nextInt();
        if (mainMenu(start)) {
            System.out.println("Enter the game you would like to play (we only have rock paper scissors or flipping a coin atm sorry) \n 1. Rock paper scissors \n 2. Coin flip");
            int gameChoice = input.nextInt();
            if (gameChoice == 1){
                rockPaperScissors(gameChoice);
            }
            else if (gameChoice == 2) {
                coinFlip(gameChoice);
            }
        }
    }
}

