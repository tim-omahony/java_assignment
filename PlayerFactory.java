package assignment;
import java.util.Scanner;
public class PlayerFactory {
    public static Player build() {
        Scanner playerIn = new Scanner(System.in);
        System.out.print("Enter your name to start playing: ");
        String name = playerIn.next();
        System.out.println("Hello " + name);
        return construct(name);
    }


    private static Player construct(String name){
        if (name.equals("tim")){
            return  new VIPPlayer(name);
        }else{
            return new LimitedPlayer(name);
        }
    }
}
