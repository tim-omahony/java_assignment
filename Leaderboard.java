package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Leaderboard {
    private static final String fileName = "leaderboard.txt";
    public static void createOrUpdate(ArrayList<Player> players){
        createFile();
        ArrayList<Player> existingPlayers = readFile();
        existingPlayers.addAll(players);
        Collections.sort(existingPlayers);
        update(existingPlayers);
    }

//method creates the file "leaderboard.txt" if it doesn't exist
    private static void createFile() {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File "  + fileName + " already exists. File has been updated.");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }
    }

//method updates leaderboard.txt when the player exits the program
    private static void update(ArrayList<Player> players){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("");
            for (Player player: players) {
                myWriter.write(player.toString());
            }
            myWriter.close();
        }catch (IOException e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }
    }

//method reads the file and adds the new players onto leaderboard.txt
    private static ArrayList<Player> readFile(){
        ArrayList<Player> players = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] playerArray = data.split("'s points: ", 2);
                Player player = new Player(playerArray[0],Integer.parseInt(playerArray[1]));
                players.add(player);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }
        return players;
    }
}

