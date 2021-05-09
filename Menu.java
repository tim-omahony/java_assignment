package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
//    ArrayList is created in order to sort the players when the program finishes
    public static ArrayList<Player> players=new ArrayList<>();

//method prompts user for an input and calls different functions depending on their selection
    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to  \n 1. New player \n 2. Quit ");
//      using a string rather than int for start as it will allow for other inputs that are strings to be caught rather than only catching incorrect integer inputs
        String start = input.next();
        if (start.equals("1")){
            Player player = PlayerFactory.build();
//          adds the new player to the ArrayList of players
            players.add(player);
            Game.gameChoice(player);
        }
        else if (start.equals("2")) {
            System.out.println("\nThanks for playing :)");
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
