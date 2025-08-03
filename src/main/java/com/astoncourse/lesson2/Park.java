package com.astoncourse.lesson2;

public class Park {

    public class Attraction {
        private String name;
        private String startTime;
        private String endTime;
        private double price;

        public Attraction(String name, String startTime, String endTime, double price) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Работает с " + startTime + " до " + endTime);
            System.out.println("Цена билета: " + price + " руб.");
        }
    }
}
