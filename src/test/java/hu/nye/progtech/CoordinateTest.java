package hu.nye.progtech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoordinateTest {

    private Map test = new Map();


    @Test
    public void testFalsecheckSize() {

    Assertions.assertFalse(test.checkSize(5 ,2,1,3,1));

    }

    @Test

    public void testTruecheckSize() {



        Assertions.assertTrue(test.checkSize(1 ,3,1,3,1));

    }

}
