package com.astoncourse.lesson7.testngtests;

import com.astoncourse.lesson7.TriangleAreaCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaCalculatorTestNG {

    @Test void testArea() {
        assertEquals(TriangleAreaCalculator.calculateArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testInvalidInput() {
        TriangleAreaCalculator.calculateArea(0, 10);
    }
}
