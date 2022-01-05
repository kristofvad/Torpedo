package hu.nye.progtech.service.game;

import hu.nye.progtech.game.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerShotTest {

    Map test = new Map();
    char[][] player2Map;



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


    @Test
    void PlayerShotTest() {

       //Given
        this.player2Map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.player2Map[i][j] = '#';

            }
        }

        player2Map[5][1] = 'O';
       //When

        boolean expected = test.playerShot(5,1);

       //Then
       Assertions.assertTrue(expected);

    }


}
