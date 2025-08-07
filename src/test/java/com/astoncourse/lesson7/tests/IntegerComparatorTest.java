package com.astoncourse.lesson7.tests;

import com.astoncourse.lesson7.IntegerComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerComparatorTest {

    @Test
    void testEqualNumbers() {
        assertTrue(IntegerComparator.areEqual(5, 5));
    }

    @Test
    void testIsGreater() {
        assertTrue(IntegerComparator.isGreater(10, 5));
    }

    @Test
    void testIsLess() {
        assertTrue(IntegerComparator.isLess(3, 7));
    }
}
