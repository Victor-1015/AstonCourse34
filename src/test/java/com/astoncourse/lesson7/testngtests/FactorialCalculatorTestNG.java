package com.astoncourse.lesson7.testngtests;

import com.astoncourse.lesson7.FactorialCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {

    @Test void testFactorialPositive() {
        assertEquals(FactorialCalculator.calculate(5), 120L);
    }

    @Test void testFactorialZero() {
        assertEquals(FactorialCalculator.calculate(0), 1L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialNegative() {
        FactorialCalculator.calculate(-1);
    }
}
