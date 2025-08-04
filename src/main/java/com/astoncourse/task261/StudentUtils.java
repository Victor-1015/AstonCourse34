package com.astoncource.task1;

import java.util.Iterator;
import java.util.Set;

public class StudentUtils {

    public static void removeUnderperforming(Set<com.astoncource.task1.Student> students) {
        Iterator<com.astoncource.task1.Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            com.astoncource.task1.Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(Set<com.astoncource.task1.Student> students) {
        for (com.astoncource.task1.Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.nextCourse();
            }
        }
    }

    public static void printStudents(Set<com.astoncource.task1.Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        for (com.astoncource.task1.Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
