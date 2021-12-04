package hu.nye.progtech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoordinateTest {

    private Map test = new Map();


    @Test
    public void testcheckSize() {

    Assertions.assertTrue(test.checkSize(1,3,1,3,1));

    }


}
