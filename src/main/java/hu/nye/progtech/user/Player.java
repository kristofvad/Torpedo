package hu.nye.progtech.user;

/**
 * Player's property.
 */
public class Player {

    public String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player name: " + this.name + "\n";
    }
}

