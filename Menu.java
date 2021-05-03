package assignment;
import java.util.*;
import assignment.Game.*;
public class Menu {
    public static ArrayList<Player> players=new ArrayList<Player>();

    private static void printScores(){
        Collections.sort(players);
        for (Player player: players) {
            System.out.println(player.toString());
        }
    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to the game house thing place! Enter a selection! \n 1. Start \n 2. Quit ");
        int start = input.nextInt();
        if (start == 1){
            Player player = newPlayer();
            gameChoice(player);
        }
        else if (start == 2) {
            System.out.println("bvye");
            printScores();
        }
        else {
            System.out.println("Please enter either '1' for start or '2' for quit");
            mainMenu();
        }
  }

    public static void gameChoice(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("! Enter the game you would like to play (we only have rock paper scissors or flipping a coin atm sorry) ===== \n1. Rock paper scissors \n2. Coin flip \n3. Quit");
        int gameNo = in.nextInt();
        if (gameNo == 1){
            Game.rockPaperScissors(player);
        }
        else if (gameNo == 2) {
            Game.coinFlip(player);
        }
        else if (gameNo == 3) {
            System.out.println("See you next time :)");
            mainMenu();
        }
    }

    public static Player newPlayer() {
        Scanner playerIn = new Scanner(System.in);
        System.out.print("Enter your name to start playing: ");
        String name = playerIn.next();
        System.out.print("===== Hello " + name);
        Player player = new Player(name);
        players.add(player);
        return player;
    }

//        public int getRandArray(){
//            return options[rand.nextInt(options.length)];
//        }

    public static void main(String[] args) {
        mainMenu();
    }
}