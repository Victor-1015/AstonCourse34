package com.astoncourse.lesson7.testngtests;

import com.astoncourse.lesson7.ArithmeticOperations;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {

    @Test void testAddition() {
        assertEquals(ArithmeticOperations.add(4, 5), 9);
    }

    @Test void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(5, 4), 1);
    }

    @Test void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(4, 5), 20);
    }

    @Test void testDivision() {
        assertEquals(ArithmeticOperations.divide(10, 5), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    void testDivisionByZero() {
        ArithmeticOperations.divide(10, 0);
    }
}
