package com.astoncourse.lesson7.tests;

import com.astoncourse.lesson7.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {

    @Test
    void testArea() {
        assertEquals(6.0, TriangleAreaCalculator.calculate(4, 3));
    }

    @Test
    void testZeroBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculate(0, 3));
    }

    @Test
    void testNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculate(4, -2));
    }
}
