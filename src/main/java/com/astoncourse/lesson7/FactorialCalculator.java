package com.astoncourse.lesson7;

public class FactorialCalculator {
    public static long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative input");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
