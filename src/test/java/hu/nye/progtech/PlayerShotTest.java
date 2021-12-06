package hu.nye.progtech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerShotTest {

    Map test = new Map();


    @Test
    void PlayerShotTest() {

       //Given

        char[][] player2Map = new char[10][10];
        player2Map[5][1] = 'O';
       //When

        boolean expected = test.playerShot(5,1);

       //Then
       Assertions.assertFalse(expected);

    }


}
