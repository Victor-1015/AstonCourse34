package com.astoncourse.lesson2;

public class MainTask3 {
    public static void main(String[] args) {
        Park park = new Park();

        Park.Attraction wheel = park.new Attraction("Колесо обозрения", "10:00", "22:00", 5.0);
        Park.Attraction coaster = park.new Attraction("Американские горки", "12:00", "20:00", 10.0);
        Park.Attraction carousel = park.new Attraction("Карусель", "09:00", "21:00", 3.5);

        wheel.printInfo();
        System.out.println("-----");
        coaster.printInfo();
        System.out.println("-----");
        carousel.printInfo();
    }
}
