package hu.nye.progtech.persistence;

import hu.nye.progtech.game.Ship;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
 * Map clone for XmlElement.
 */
@XmlRootElement(name = "game_state")
public class PersistableMap {

    char[][] playerMap;
    char[][] player2Map;
    Ship[] playerShips;
    Ship[] player2Ships;

    /**
     * Empty Constructor for Xml.
     */
    public PersistableMap() {
    }

    public PersistableMap(char[][] playerMap, char[][] player2Map, Ship[] playerShips, Ship[] player2Ships) {
        this.playerMap = playerMap;
        this.player2Map = player2Map;
        this.playerShips = playerShips;
        this.player2Ships = player2Ships;
    }

    public char[][] getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(char[][] playerMap) {
        this.playerMap = playerMap;
    }

    public char[][] getPlayer2Map() {
        return player2Map;
    }

    public void setPlayer2Map(char[][] player2Map) {
        this.player2Map = player2Map;
    }

    public Ship[] getPlayerShips() {
        return playerShips;
    }

    public void setPlayerShips(Ship[] playerShips) {
        this.playerShips = playerShips;
    }

    public Ship[] getPlayer2Ships() {
        return player2Ships;
    }

    public void setPlayer2Ships(Ship[] player2Ships) {
        this.player2Ships = player2Ships;
    }

    void printplayerPersistableMap() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) (i + 65));
            System.out.print("  ");
            for (int j = 0; j < 10; j++) {
                System.out.print(playerMap[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    void printplayer2PersistableMap() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) (i + 65));
            System.out.print("  ");
            for (int j = 0; j < 10; j++) {
                System.out.print(player2Map[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

}
