package com.weiyuze.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShowComparator2 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "b";
        System.out.println(str1.compareTo(str2));
        System.out.println("============================");

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        Student s1 = new Student(5, "张三", 61);
        Student s2 = new Student(3, "赵四", 35);
        Student s3 = new Student(1, "王五", 2);
        Student s4 = new Student(2, "李六", 17);
        Student s5 = new Student(4, "魏七", 94);
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println(s.toString());
        }

    }

    static class IdComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id > o2.id) {
                return -1;
            } else if (o1.id < o2.id) {
                return 1;
            } else {
                return 0;
            }
        }
    }

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

}
