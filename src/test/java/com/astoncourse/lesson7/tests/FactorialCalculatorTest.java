package com.astoncourse.lesson7.tests;

import com.astoncourse.lesson7.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculate(0));
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculate(5));
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculate(-1));
    }
}
