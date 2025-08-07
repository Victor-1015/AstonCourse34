package com.astoncourse.lesson7.testngtests;

import com.astoncourse.lesson7.IntegerComparator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class IntegerComparatorTestNG {

    @Test void testEqual() {
        assertEquals(IntegerComparator.compare(3, 3), 0);
    }

    @Test void testGreaterThan() {
        assertTrue(IntegerComparator.compare(10, 5) > 0);
    }

    @Test void testLessThan() {
        assertTrue(IntegerComparator.compare(5, 10) < 0);
    }
}
