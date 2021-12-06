package hu.nye.progtech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameEndTest {

    Map test = new Map();

    @Test

    void GameEndTest(){

        char[][] playerMap = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerMap[i][j] = '#';

            }
        }

        char[][] map = new char[10][10];
        map[5][5] = playerMap[5][5];
        map[5][5] = 'X';

        Assertions.assertTrue(test.GameEnd(map));

    }

}
