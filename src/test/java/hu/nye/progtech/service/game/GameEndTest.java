package hu.nye.progtech.service.game;

import hu.nye.progtech.game.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameEndTest {

    Map test = new Map();



//    @BeforeEach
//    public void setUp() {
//        underTest =
//    }

    @Test
    void GameEndTest(){

        char[][] playerMap = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerMap[i][j] = '#';

            }
        }

        playerMap[5][5] = 'X';

        Assertions.assertTrue(test.gameEnd(playerMap));

    }
}
