package com.astoncourse.lesson3;

public class Cat extends Animal {
    private static final int MAX_RUN = 200;

    private static int catCount = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println(name + " не будет бегать на " + distance + " м.");
            return;
        }

        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Plate plate, int foodAmount) {
        if (foodAmount <= 0) {
            System.out.println(name + " не может есть " + foodAmount + " еды.");
            return;
        }

        if (plate.takeFood(foodAmount)) {
            isFull = true;
            System.out.println(name + " покушал " + foodAmount + " еды.");
        } else {
            System.out.println(name + " не поел — еды не хватило.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}
