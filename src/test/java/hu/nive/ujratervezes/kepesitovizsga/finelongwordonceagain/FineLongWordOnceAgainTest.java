package hu.nive.ujratervezes.kepesitovizsga.finelongwordonceagain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FineLongWordOnceAgainTest {

    @Test
    public void testGetFineLongWordOnceAgainButNowInAReverseWay() {
        char[][] fineLongWordInAnArrayOfArrays = new FineLongWordOnceAgain().getFineLongWordOnceAgainButNowInAReverseWay("IllegalArgumentException", 6);

        assertEquals(19, fineLongWordInAnArrayOfArrays.length);
        assertEquals('G', fineLongWordInAnArrayOfArrays[2][2]);
        assertEquals('X', fineLongWordInAnArrayOfArrays[12][4]);
    }

    @Test
    public void testGetFineLongWordOnceAgainButNowInAReverseWayWithIllegalParameter() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new FineLongWordOnceAgain().getFineLongWordOnceAgainButNowInAReverseWay("IllegalArgumentException", 100));
        assertEquals("Number of letters cannot be more than length of the word!", ex.getMessage());
    }

}