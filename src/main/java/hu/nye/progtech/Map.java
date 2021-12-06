package hu.nye.progtech;

import java.util.Scanner;

public class Map {

    char[][] playerMap;
    char[][] player2Map;
    Ship[] playerShips;
    Ship[] player2Ships;

    public Map() {
        this.playerMap = new char[10][10];
        this.player2Map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.playerMap[i][j] = '#';
                this.player2Map[i][j] = '#';
            }
        }
    }

    void printplayerMap() {
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

    void printplayer2Map() {
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

    void PlayerMap() {
        Scanner scanner = new Scanner(System.in);

        playerShips = new Ship[5];
        playerShips[0] = new Ship("Carrier", 5);
        playerShips[1] = new Ship("Battleship", 4);
        playerShips[2] = new Ship("Submarine", 3);
        playerShips[3] = new Ship("Cruiser", 3);
        playerShips[4] = new Ship("Destroyer", 2);

        for (Ship ship : playerShips) {
            System.out.printf("Adja meg a koordinátáját a %s-nek (%d cella):\n", ship.getName(), ship.getSize());
            while (true) {
                String[] coordinates = scanner.nextLine().split(" ");
                int rowBegin = coordinates[0].charAt(0) - 65;
                int columnBegin = Integer.parseInt(coordinates[0].substring(1))-1;
                int rowEnd = coordinates[1].charAt(0) - 65;
                int columnEnd = Integer.parseInt(coordinates[1].substring(1))-1;

                if (rowBegin > rowEnd) {
                    int temp = rowBegin;
                    rowBegin = rowEnd;
                    rowEnd = temp;
                }
                if (columnBegin > columnEnd) {
                    int temp = columnBegin;
                    columnBegin = columnEnd;
                    columnEnd = temp;
                }

                if (rowBegin == rowEnd || columnBegin == columnEnd) {
                    if (checkSize(rowBegin, columnBegin, rowEnd, columnEnd, ship.getSize())) {
                        if (checkCoordinates(rowBegin, columnBegin, rowEnd, columnEnd, playerShips, playerMap)) {
                            placeShip(rowBegin, columnBegin, rowEnd, columnEnd, ship, playerMap);
                            printplayerMap();
                            break;
                        } else {
                            System.out.println("Error! Túl közel helyezted egy másikhoz. Probáld újra:");
                        }
                    } else {
                        System.out.printf("Error! Rossz hossz a %s-hez! Próbáld újra:\n", ship.getName());
                    }
                } else {
                    System.out.println("Error! Rossz hajó elhelyezés! Próbáld újra:");
                }
            }
        }

    }


    void player2Map(){
        Scanner scanner = new Scanner(System.in);

        player2Ships = new Ship[5];
        player2Ships[0] = new Ship("Carrier", 5);
        player2Ships[1] = new Ship("Battleship", 4);
        player2Ships[2] = new Ship("Submarine", 3);
        player2Ships[3] = new Ship("Cruiser", 3);
        player2Ships[4] = new Ship("Destroyer", 2);

        for (Ship ship : player2Ships) {
            System.out.printf("Adja meg a coordinatajat a %s (%d cella)-nak:\n", ship.getName(), ship.getSize());
            while (true) {
                String[] coordinates = scanner.nextLine().split(" ");
                int rowBegin = coordinates[0].charAt(0) - 65;
                int columnBegin = Integer.parseInt(coordinates[0].substring(1)) - 1;
                int rowEnd = coordinates[1].charAt(0) - 65;
                int columnEnd = Integer.parseInt(coordinates[1].substring(1)) - 1;

                if (rowBegin > rowEnd) {
                    int temp = rowBegin;
                    rowBegin = rowEnd;
                    rowEnd = temp;
                }
                if (columnBegin > columnEnd) {
                    int temp = columnBegin;
                    columnBegin = columnEnd;
                    columnEnd = temp;
                }

                if (rowBegin == rowEnd || columnBegin == columnEnd) {
                    if (checkSize(rowBegin, columnBegin, rowEnd, columnEnd, ship.getSize())) {
                        if (checkCoordinates(rowBegin, columnBegin, rowEnd, columnEnd, player2Ships, player2Map)) {
                            placeShip(rowBegin, columnBegin, rowEnd, columnEnd, ship, player2Map);
                            printplayer2Map();
                            break;
                        } else {
                            System.out.println("Error! Túl közel helyezted egy másikhoz. Probáld újra:");
                        }
                    } else {
                        System.out.printf("Error! Rossz hossz a %s-hez! Próbáld újra:\n", ship.getName());
                    }
                } else {
                    System.out.println("Error! Rossz hajó elhelyezés! Próbáld újra:");
                }
            }
        }

    }


    private void placeShip(int rowBegin, int columnBegin, int rowEnd, int columnEnd, Ship ship, char[][] map) {
        if (rowBegin == rowEnd) {
            for (int i = columnBegin; i <= columnEnd; i++) {
                map[rowBegin][i] = 'O';
            }
        } else {
            for (int i = rowBegin; i <= rowEnd; i++) {
                map[i][columnBegin] = 'O';
            }
        }
        ship.place(rowBegin, columnBegin, rowEnd, columnEnd);
    }


    public boolean checkSize(int rowBegin, int columnBegin, int rowEnd, int columnEnd, int size) {
        if (rowBegin == rowEnd || columnBegin == columnEnd) {
            return rowEnd - rowBegin + 1 == size || columnEnd - columnBegin + 1 == size;
        } else {
            return false;
        }
    }

    public boolean checkCoordinates(int rowBegin, int columnBegin, int rowEnd, int columnEnd, Ship[] ships, char[][] map) {
        for (Ship ship : ships) {
            if (ship.isPlaced()) {
                for (int i = rowBegin - 1; i <= rowEnd + 1; i++) {
                    for (int j = columnBegin - 1; j <= columnEnd + 1; j++) {
                        if (Occupied(i, j, map)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean Occupied(int i, int j, char[][] map) {
        i = Math.min(i, 9);
        i = Math.max(i, 0);
        j = Math.min(j, 9);
        j = Math.max(j, 0);

        return map[i][j] == 'O';
    }

    boolean GameEnd(char[][] map) {
        for (char[] row : map) {
            for (char element : row) {
                if (element == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean playerShot(int x, int y) {
        if (player2Map[x][y] == 'O' || player2Map[x][y] == '+') {
            player2Map[x][y] = '+';
            return true;
        } else {
            player2Map[x][y] = 'X';
            return false;
        }
    }

    boolean player2Shot(int x, int y) {
        if (playerMap[x][y] == 'O' || playerMap[x][y] == '+') {
            playerMap[x][y] = '+';
            return true;
        } else {
            playerMap[x][y] = 'X';
            return false;
        }
    }

    boolean isAlive(int x, int y, Ship[] ships) {
        for  (Ship ship : ships) {
            if (ship.getRowBegin() == ship.getRowEnd() && x == ship.getRowBegin()) {
                if (ship.getColumnBegin() <= y && ship.getColumnEnd() >= y) {
                    if (ship.getLives() == 1) {
                        return false;
                    } else {
                        ship.hit();
                    }
                }
            } else if (ship.getColumnBegin() == ship.getColumnEnd() && y == ship.getColumnBegin()) {
                if (ship.getRowBegin() <= x && ship.getRowEnd() >= x) {
                    return false;
                } else {
                    ship.hit();
                }
            }
        } return true;
    }

}
