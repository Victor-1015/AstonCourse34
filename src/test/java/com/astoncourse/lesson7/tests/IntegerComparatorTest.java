package com.astoncourse.lesson7.tests;

import com.astoncourse.lesson7.IntegerComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerComparatorTest {

    @Test void testEqual() {
        assertEquals(0, IntegerComparator.compare(5, 5));
    }

    @Test void testGreaterThan() {
        assertTrue(IntegerComparator.compare(10, 5) > 0);
    }

    @Test void testLessThan() {
        assertTrue(IntegerComparator.compare(3, 5) < 0);
    }
}
