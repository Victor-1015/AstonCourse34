package com.astoncourse.lesson4;

public interface Shape {
    double getArea();
    double getPerimeter();

    default void printDetails() {
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }
}
