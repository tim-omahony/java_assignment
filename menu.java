package assignment;
import java.util.*;
public class menu {
    public static boolean mainMenu(int start){
        if (start == 1){
            return true;
        }
        else if (start == 2) {
            return false;
        }
        else {
            System.out.println("Please enter either '1' for start or '2' for quit");
            return false;
        }
    }


    public static void coinFlip(int game){
        Scanner CFin = new Scanner(System.in);
        System.out.println("Welcome to Coin Flip!");
    }


    public static void rockPaperScissors(int start) {
        Scanner RPSin = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");
        //Use a while(true) loop and only break the loop if the user wants to quit
        while(true) {
            //Get the user's move through user input
            System.out.println("Please enter either:\nrock \npaper \nscissors \nquit");
            String playerMove = RPSin.next();
            if (playerMove.equals("quit")) {
                System.out.println("Thanks for playing rock paper scissors :)");
                gameChoice();
                break;
            }
//            //Check if the user's move is valid (rock, paper, or scissors)
//            if(!(playerMove == 1) && !(playerMove == 2) && !(playerMove == 3)){
            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")){
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
                if (playerMove.equals(computerMove)){
                    System.out.println("It's a tie :o");
                }
                else if((playerMove.equals("rock") && computerMove.equals("scissors")) || (playerMove.equals("scissors") && computerMove.equals("paper")) || (playerMove.equals("paper") && computerMove.equals("rock"))) {
                    System.out.println("You won :)");
                } else {
                    System.out.println("You lost :(");
                }
            }
        }
    }


    public static void gameChoice() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the game you would like to play (we only have rock paper scissors or flipping a coin atm sorry) \n1. Rock paper scissors \n2. Coin flip \n3. Quit");
        int gameNo = in.nextInt();
        if (gameNo == 1){
            rockPaperScissors(gameNo);
        }
        else if (gameNo == 2) {
            coinFlip(gameNo);
        }
        else if (gameNo == 3) {
            System.out.println("See you next time :)");
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! \n 1. Start \n 2. Quit ");
        int start = input.nextInt();
        if (mainMenu(start)) {
            gameChoice();
        }else{
            System.out.println("See you next time :)");
        }
    }
}

