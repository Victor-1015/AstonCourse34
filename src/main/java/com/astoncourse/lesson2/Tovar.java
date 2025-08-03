package com.astoncourse.lesson2;

import java.time.LocalDate;

public class Tovar {
    private String name;
    private LocalDate manufactureDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Tovar(String name, LocalDate manufactureDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + manufactureDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Забронирован покупателем: " + (isReserved ? "Да" : "Нет"));
    }
}
