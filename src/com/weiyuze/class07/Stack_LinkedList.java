package com.weiyuze.class07;

import java.util.LinkedList;
import java.util.Stack;

public class Stack_LinkedList {
    public static void main(String[] args) {
        System.out.println("测试开始");
        int testTime = 10000000;
        long start;
        long end;
        Stack<Integer> stack = new Stack<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("=======================");

        LinkedList<Integer> list = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            list.addLast(i);
        }
        while (!list.isEmpty()) {
            list.pollLast();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("=======================");

        int[] arr = new int[testTime];
        start = System.currentTimeMillis();
        /*for (int i = 0; i < testTime; i++) {
            arr[i] = i;
        }
        for (int i = testTime - 1; i >= 0; i--) {
            int a = arr[i];
        }*/
        int index = 0;
        for (int i = 0; i < testTime; i++) {
            arr[index++] = i;
        }
        while (index != 0) {
            int a = arr[--index];
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);

    }


}
