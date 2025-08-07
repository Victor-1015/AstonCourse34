package com.astoncourse.lesson7.tests;

import com.astoncourse.lesson7.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {

    @Test void testArea() {
        assertEquals(25.0, TriangleAreaCalculator.calculateArea(10, 5));
    }

    @Test void testAreaWithZeroBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(0, 5));
    }
}
