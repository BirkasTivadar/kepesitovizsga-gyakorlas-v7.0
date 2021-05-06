package hu.nive.ujratervezes.kepesitovizsga.fractionreduction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionReductionTest {

    @Test
    void testGetNumberOfNotReductiveFractions() {
        assertEquals(48, new FractionReduction().getNumberOfNotReductiveFractions());

    }

}