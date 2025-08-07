package com.astoncourse.lesson7;

public class TriangleAreaCalculator {
    public static double calculate(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными");
        }
        return 0.5 * base * height;
    }
}
