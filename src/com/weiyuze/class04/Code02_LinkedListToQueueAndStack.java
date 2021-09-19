package com.weiyuze.class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code02_LinkedListToQueueAndStack {
    static class Node<V> {
        Node next;
        V value;

        public Node(V value) {
            this.next = null;
            this.value = value;
        }
    }

    static class MyQueue<V> {
        Node<V> head;
        Node<V> tail;
        int size;

        public MyQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }

        void offer(V value) {
            Node<V> cur = new Node<V>(value);
            if (size == 0) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            } else {
                tail = null;
            }
            return ans;
        }

        V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    static class MyStack<V> {
        Node<V> head;
        int size;

        public MyStack() {
            this.head = null;
            this.size = 0;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }

        void push(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;//
        }

        V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

        V peek() {
            return head != null ? head.value : null;
        }
    }

    static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        int testTime = 100000;
        int maxValue = 1000000;
        System.out.println("测试开始1");
        for (int i = 1; i < testTime; i++) {
            if (queue.isEmpty() != myQueue.isEmpty()) {
                System.out.println("isEmpty()!");
            }
            if (myQueue.size() != queue.size()) {
                System.out.println("size1");
            }
            Double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) Math.random() * maxValue;
                myQueue.offer(num);
                queue.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = queue.poll();
                    if (num1 != num2) {
                        System.out.println("0.66");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = queue.peek();
                    if (num1 != num2) {
                        System.out.println("1");
                    }
                }
            }
            if (myQueue.size != queue.size()) {
                System.out.println("size2");
            }
            while (!myQueue.isEmpty()) {
                int num1 = myQueue.poll();
                int num2 = queue.poll();
                if (num1 != num2) {
                    System.out.println("循环");
                }
            }
        }
        System.out.println("测试结束1");
    }

    static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();
        int testTime = 100000;
        int maxValue = 10000;
        System.out.println("测试开始2");
        for (int i =1;i<testTime;i++){
            if (myStack.isEmpty() != stack.isEmpty()){
                System.out.println("isEmpty");
            }
            if (myStack.size()!=stack.size()){
                System.out.println("size1");
            }
            Double decide = Math.random();
            if (decide<0.33){
                int num = (int) (Math.random()*maxValue);
                myStack.push(num);
                stack.push(num);
            }
            if (decide<0.66){
                if (!myStack.isEmpty()){
                    int num1 = myStack.pop();
                    int num2 = stack.pop();
                    if (num1!=num2){
                        System.out.println("0.66");
                    }
                }
            }else {
                if (!myStack.isEmpty()){
                    int num1 = myStack.peek();
                    int num2 = myStack.peek();
                    if (num1!=num2){
                        System.out.println("1");
                    }
                }
            }
            if (myStack.size()!=myStack.size()){
                System.out.println("size2");
            }
            if (!myStack.isEmpty()){
                int num1 = myStack.pop();
                int num2 = stack.pop();
                if (num1!=num2){
                    System.out.println("pop2");
                }
            }
        }
        System.out.println("测试结束2");
    }

    public static void main(String[] args) {
        testQueue();
        testStack();
    }
}
