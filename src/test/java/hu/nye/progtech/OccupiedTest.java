package hu.nye.progtech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OccupiedTest {

    private Map test = new Map();

    @Test

    void OccupiedTest() {

        char[][] playerMap = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerMap[i][j] = '#';

            }
        }

        char[][] exception = new char[5][5];
        exception[4][4] = playerMap[4][4];
        exception[4][4] = 'O';



        char[][] result = new char[5][5];
        result[4][4] = playerMap[4][4];
        result[4][4] = 'O';



        Assertions.assertEquals(test.Occupied(4,4,exception),test.Occupied(4,4,result));

    }

    @Test
    void OccupiedFalseTest() {

        char[][] map = new char[10][10];
        char[][] ship = new char[5][5];
        ship[4][4] = map[5][5];
        ship[4][4] = 'O';

        Assertions.assertFalse(test.Occupied(3,3,ship));

    }

    //char[][] playerMap = new char[10][10];
    //        char[][] map = new char[5][5];
    //        map[4][4] = playerMap[4][4];
    //        map[4][4] = 'O';
    //
    //        Assertions.assertTrue(test.Occupied(4,4,map));

}
