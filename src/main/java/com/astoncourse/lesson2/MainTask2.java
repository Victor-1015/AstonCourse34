package com.astoncourse.lesson2;

import java.time.LocalDate;

public class MainTask2 {
    public static void main(String[] args) {
        Tovar[] products = new Tovar[5];

        products[0] = new Tovar("Samsung S25 Ultra", LocalDate.of(2025, 2, 1), "Samsung", "Корея", 5599, true);
        products[1] = new Tovar("iPhone 16", LocalDate.of(2025, 5, 5), "Apple", "США", 6999, false);
        products[2] = new Tovar("Xiaomi Mi 14", LocalDate.of(2025, 1, 10), "Xiaomi", "Китай", 3499, true);
        products[3] = new Tovar("LG TV", LocalDate.of(2024, 11, 30), "LG", "Корея", 4599, false);
        products[4] = new Tovar("Sony Headphones", LocalDate.of(2025, 3, 18), "Sony", "Япония", 1299, true);

        for (Tovar product : products) {
            System.out.println("------------");
            product.printInfo();
        }
    }
}
