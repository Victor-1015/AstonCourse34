package com.astoncourse.task25;

import java.util.Arrays;

public class ArrayProcessor {
    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || !Arrays.stream(arr).allMatch(row -> row.length == 4)) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке: [" + i + "][" + j + "] -> '" + arr[i][j] + "'");
                }
            }
        }
        return sum;
    }
}
