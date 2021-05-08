package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
//    ArrayList is created in order to sort the players when the program finishes
    public static ArrayList<Player> players=new ArrayList<Player>();

//method prompts the user for an input and calls different functions depending on the input
    public static void gameChoice(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println(" ===== Enter the game you would like to play (we only have rock paper scissors or flipping a coin atm sorry) ===== \n1. Rock paper scissors \n2. Coin flip \n3. Main Menu");
        int gameNo = in.nextInt();
        if (gameNo == 1){
            Game.rockPaperScissors(player);
        }
        else if (gameNo == 2) {
            Game.coinFlip(player);
        }
        else if (gameNo == 3) {
            System.out.println("See you next time " + player.getName() + " :)");
            mainMenu();
        }
    }

//method prompts user for an input and calls different functions depending on their selection
    private static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! \n 1. New player \n 2. Quit ");
        int start = input.nextInt();
        if (start == 1){
            Player player = PlayerFactory.build();
//            adds the new player to the ArrayList of players
            players.add(player);
            gameChoice(player);
        }
        else if (start == 2) {
            System.out.println("Thanks for playing :)");
            printScores();
        }
        else {
            System.out.println("Please enter either '1' for start or '2' for quit");
            mainMenu();
        }
    }

//method calls the toString() method of the Player class
    private static void printScores(){
        Collections.sort(players);
        for (Player player: players) {
            System.out.println(player.toString());
        }
        Leaderboard.createOrUpdate(players);
    }


    public static void main(String[] args) {
        mainMenu();
    }
}
