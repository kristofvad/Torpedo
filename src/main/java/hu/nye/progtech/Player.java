package hu.nye.progtech;

public class Player {

    String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player name: " + this.name + "\n";
    }
}

