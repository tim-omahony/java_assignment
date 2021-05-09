package assignment;

import java.util.Scanner;

public class PlayerFactory {
// class PlayerFactory generates new players and specifies whether they are VIP or Limited players
    public static Player build() {
        Scanner playerIn = new Scanner(System.in);
        System.out.print("Enter your name to start playing: ");
        String name = playerIn.next();
        System.out.println("\nHello " + name);
        return construct(name);
    }


    private static Player construct(String name){
        if (name.equals("tim") || name.equals("Tim") || name.equals("paul") || name.equals("Paul")){
            return  new VIPPlayer(name);
        }else{
            return new LimitedPlayer(name);
        }
    }
}

