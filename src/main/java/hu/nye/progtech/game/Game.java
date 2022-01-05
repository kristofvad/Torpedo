package hu.nye.progtech.game;

import java.util.Scanner;

import hu.nye.progtech.service.command.InputHandler;
import hu.nye.progtech.service.db.Database;
import hu.nye.progtech.user.Player;

/**
 * Controller for the Torpedo game.
 */
public class Game {

    Map torpedo;

    InputHandler put;

    public Game() {
        torpedo = new Map();
    }

    public static String playerName;

    public static String player2Name;

    void game() {



        Scanner scanner = new Scanner(System.in);
        System.out.println("Elso jatekos adja meg a nevet:");
        Player player = new Player(scanner.nextLine());
        playerName = player.name;
        torpedo.printplayerMap();
        torpedo.playerMap();
        String playerTurn = "player";

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Masodik jatekos adja meg a nevet:");
        Player player2 = new Player(scanner2.nextLine());
        player2Name = player2.name;
        torpedo.printplayer2Map();
        torpedo.player2Map();

        while (true) {

            System.out.println();
            torpedo.printplayer2Map();
            System.out.println("-----------------------");
            torpedo.printplayerMap();


            if (playerTurn.equals("player")) {
                System.out.println(player + "következik:\n");
                    String coordinates = scanner.nextLine();
                    int x = coordinates.charAt(0) - 65;
                    int y = Integer.parseInt(coordinates.substring(1)) - 1;
                    while ((x < 0 || x > 9) || (y < 0 || y > 9) || torpedo.player2Map[x][y] == 'X'
                            || torpedo.player2Map[x][y] == '+') {
                        System.out.println("Error! Rossz koordinátákat adtál meg. Próbálkozz újra:");
                        coordinates = scanner.nextLine();
                        x = coordinates.charAt(0) - 65;
                        y = Integer.parseInt(coordinates.substring(1)) - 1;
                    }

                    if (torpedo.playerShot(x, y)) {
                        torpedo.printplayer2Map();
                        System.out.println("-----------------------");
                        torpedo.printplayerMap();
                        if (torpedo.isAlive(x, y, torpedo.player2Ships)) {
                            System.out.println("Találat!");
                        } else {
                            System.out.println("Elsüllyesztettél egy hajót!");
                        }
                        if (torpedo.gameEnd(torpedo.player2Map)) {
                            System.out.println("Elsüllyesztetted az utolsó hajót! Nyertél!");
                            Database database = new Database();

                            Database.playerWin();
                            Database.player2Lose();

                            Database.highscore();
                            System.exit(0);

                        }


                    } else {
                        {
                            torpedo.printplayer2Map();
                            System.out.println("-----------------------");
                            torpedo.printplayerMap();
                        }
                        System.out.println("Nem talált");
                        playerTurn = "player2";

                    }

                } else {

                    System.out.println(player2 + "következik:\n");
                    String coordinates = scanner2.nextLine();
                    int x = coordinates.charAt(0) - 65;
                    int y = Integer.parseInt(coordinates.substring(1)) - 1;
                    while ((x < 0 || x > 9) || (y < 0 || y > 9) || torpedo.playerMap[x][y] == 'X'
                            || torpedo.playerMap[x][y] == '+') {
                        System.out.println("Error! Rossz koordinátákat adtál meg. Próbálkozz újra:");
                        coordinates = scanner2.nextLine();
                        x = coordinates.charAt(0) - 65;
                        y = Integer.parseInt(coordinates.substring(1)) - 1;

                    }
                    if (torpedo.player2Shot(x, y)) {
                        torpedo.printplayerMap();
                        System.out.println("-----------------------");
                        torpedo.printplayer2Map();
                        if (torpedo.isAlive(x, y, torpedo.playerShips)) {
                            System.out.println("Találat!");
                        } else {
                            System.out.println("Elsüllyesztettél egy hajót!");
                        }
                        if (torpedo.gameEnd(torpedo.playerMap)) {
                            System.out.println("Elsüllyesztetted az utolsó hajót! Nyertél!");
                            Database database = new Database();

                            Database.player2Win();
                            Database.playerLose();

                            Database.highscore();
                            System.exit(0);
                        }

                    } else {

                        torpedo.printplayerMap();
                        System.out.println("-----------------------");
                        torpedo.printplayer2Map();
                        System.out.println("Nem talált");
                        playerTurn = "player";
                    }
            }
        }
    }
}
