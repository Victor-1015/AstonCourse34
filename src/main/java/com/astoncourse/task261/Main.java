package com.astoncourse.task261;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<com.astoncource.task1.Student> students = new HashSet<>();
        students.add(new com.astoncource.task1.Student("Аня", "A-01", 1, List.of(4, 5, 3)));
        students.add(new com.astoncource.task1.Student("Борис", "B-02", 2, List.of(2, 2, 3)));
        students.add(new com.astoncource.task1.Student("Вика", "C-03", 1, List.of(5, 4, 5)));

        System.out.println("Изначальный список:");
        students.forEach(System.out::println);

        com.astoncource.task1.StudentUtils.removeUnderperforming(students);
        com.astoncource.task1.StudentUtils.promoteStudents(students);

        System.out.println("\nПосле удаления и перевода:");
        students.forEach(System.out::println);

        System.out.println();
        com.astoncource.task1.StudentUtils.printStudents(students, 2);
    }
}
