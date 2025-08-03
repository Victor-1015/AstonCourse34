package com.astoncourse.lesson2;

import java.time.LocalDate;

public class MainTask1 {
    public static void main(String[] args) {
        Tovar phone = new Tovar(
                "Смартфон",
                LocalDate.of(2024, 12, 10),
                "Samsung",
                "Южная Корея",
                1299.99,
                true
        );

        phone.printInfo();
    }
}
