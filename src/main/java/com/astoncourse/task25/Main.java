package com.astoncourse.task25;

public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "x"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"}
        };

        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Сумма всех чисел в массиве: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Произошла ошибка при обработке массива: " + e.getMessage());
        }

        try {
            int[] массив = new int[3];
            int число = массив[5]; // Здесь будет исключение
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: выход за пределы массива — " + e.getMessage());
        }
    }
}
