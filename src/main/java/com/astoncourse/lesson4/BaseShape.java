package com.astoncourse.lesson4;

public abstract class BaseShape implements Shape {
    protected String fillColor;
    protected String borderColor;

    public BaseShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printColors() {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }

    public void printFullDetails() {
        printDetails();
        printColors();
        System.out.println();
    }
}
