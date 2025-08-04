package com.astoncourse.task262;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        com.astoncourse.task262.PhoneBook book = new com.astoncourse.task262.PhoneBook();

        book.add("Иванов", "123456");
        book.add("Петров", "654321");
        book.add("Иванов", "111111");

        System.out.println("Телефоны Иванова: " + book.get("Иванов"));
        System.out.println("Телефоны Петрова: " + book.get("Петров"));
        System.out.println("Телефоны Сидорова: " + book.get("Сидоров"));
    }
}
