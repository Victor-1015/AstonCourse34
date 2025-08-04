package com.astoncourse.lesson4;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Жёлтый", "Красный");
        Shape rectangle = new Rectangle(4, 6, "Зелёный", "Чёрный");
        Shape triangle = new Triangle(3, 4, 5, "Голубой", "Синий");

        ((BaseShape) circle).printFullDetails();
        ((BaseShape) rectangle).printFullDetails();
        ((BaseShape) triangle).printFullDetails();
    }
}
