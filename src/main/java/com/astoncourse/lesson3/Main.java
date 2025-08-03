package com.astoncourse.lesson3;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Барон");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Пушок");

        dog.run(300);
        dog.swim(12);

        cat1.run(150);
        cat2.swim(5);

        System.out.println();

        Plate plate = new Plate(25);

        Cat[] cats = {cat1, cat2};
        int foodPerCat = 15;

        for (Cat cat : cats) {
            cat.eat(plate, foodPerCat);
        }

        System.out.println("\nСытость котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        plate.addFood(20);

        System.out.println("\nПовторная попытка покормить:");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(plate, foodPerCat);
            }
        }

        System.out.println("\nИтог:");
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Всего животных: " + Animal.getAnimalCount());
    }
}
