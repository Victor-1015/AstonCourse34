package com.astoncourse.lesson3;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = Math.max(food, 0); // чтобы еда не была отрицательной
    }

    public boolean takeFood(int amount) {
        if (amount <= 0) return false;
        if (amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды. Теперь в тарелке: " + food);
        } else {
            System.out.println("Нельзя добавить " + amount + " еды.");
        }
    }

    public int getFood() {
        return food;
    }
}
