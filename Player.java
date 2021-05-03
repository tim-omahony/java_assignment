package assignment;
public class Player implements Comparable<Player>{
    public int points;
    public String name;

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name +"'s points: " + points;
    }

    @Override
    public int compareTo(Player comparePlayer) {
        int compareScore=((Player)comparePlayer).getPoints();
        return compareScore-this.points;
    }
}
