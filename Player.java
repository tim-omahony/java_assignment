package assignment;
public class Player implements Comparable<Player>{
    public int points;
    public String name;

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

//    this Player constructor is used so that scores in leaderboard.txt are not reset to 0 after every run of the program
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +"'s points: " + points + "\n";
    }

    @Override
    public int compareTo(Player comparePlayer) {
        int compareScore=(comparePlayer).getPoints();
        return compareScore-this.points;
    }
}


class VIPPlayer extends Player {
    public VIPPlayer(String name) {
        super(name + " (VIP)");
//      VIP players start with 10 points
        this.points = 10;
    }
}


class LimitedPlayer extends Player {
    public LimitedPlayer(String name) {
        super(name + " (Limited)");
    }
}
