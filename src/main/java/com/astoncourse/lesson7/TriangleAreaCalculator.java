package com.astoncourse.lesson7;

public class TriangleAreaCalculator {
    public static double calculateArea(int base, int height) {
        if (base <= 0 || height <= 0)
            throw new IllegalArgumentException("Base and height must be positive");
        return 0.5 * base * height;
    }
}
