package com.weiyuze.class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ShowComparator {
    static class Student {
        int id;
        String name;
        int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class IdComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return -1;
            } else if (o1.id > o2.id) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age) {
                return -1;
            } else if (o1.age > o2.age) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 1, 4, 8, 6, 3, 2};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        System.out.println("============================");

        Student s1 = new Student(5, "张三", 61);
        Student s2 = new Student(3, "赵四", 35);
        Student s3 = new Student(1, "王五", 2);
        Student s4 = new Student(2, "李六", 17);
        Student s5 = new Student(4, "魏七", 94);

        Student[] students = {s1, s2, s3, s4, s5};
        printStudents(students);
        System.out.println("****************************");
        Arrays.sort(students, new IdComparator());
        printStudents(students);
        System.out.println("============================");

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        for (Student s : list) {
            System.out.println(s.toString());
        }
        System.out.println("****************************");
        list.sort(new AgeComparator());
        for (Student s : list) {
            System.out.println(s.toString());
        }

    }
}
