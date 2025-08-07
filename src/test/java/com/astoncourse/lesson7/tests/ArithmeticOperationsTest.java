package com.astoncourse.lesson7.tests;

import com.astoncourse.lesson7.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    @Test
    void testAddition() {
        assertEquals(9, ArithmeticOperations.add(4, 5));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, ArithmeticOperations.subtract(5, 4));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, ArithmeticOperations.multiply(4, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, ArithmeticOperations.divide(10, 5));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}
