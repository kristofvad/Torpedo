package hu.nye.progtech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class checkCoordinatesTest {
    Map test = new Map();

    @Test
    void checkCoordinatesTest(){

        //Given
        Ship[] hajo = new Ship[0];
        char[][] player2Map = new char[10][10];

        //When
        boolean result = test.checkCoordinates(1,1,1,6, hajo, player2Map);

        //Then
        Assertions.assertTrue(result);

    }




}
