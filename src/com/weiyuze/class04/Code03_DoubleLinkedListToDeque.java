package com.weiyuze.class04;

import java.util.Deque;
import java.util.LinkedList;

public class Code03_DoubleLinkedListToDeque {
    static class Node<V> {
        V value;
        Node<V> next;
        Node<V> last;

        public Node(V value) {
            this.value = value;
            this.next = null;
            this.last = null;
        }
    }

    static class MyDeque<V> {
        Node<V> head;
        Node<V> tail;
        int size;

        public MyDeque() {
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

        void pushHead(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        void pushTail(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        V pollHead() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        V pollTail() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        V peekHead() {
            return head == null ? null : head.value;
        }

        V peekTail() {
            return head == null ? null : tail.value;
        }
    }

    static void testDeque() {
        MyDeque<Integer> myDeque = new MyDeque<>();
        Deque<Integer> deque = new LinkedList<>();
        int testTime = 1000000;
        int maxValue = 100000;
        System.out.println("测试开始");
        for (int i = 1; i < testTime; i++) {
            if (myDeque.isEmpty() != deque.isEmpty()) {
                System.out.println("isEmpty");
            }
            if (myDeque.size() != deque.size()) {
                System.out.println("size1");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.pushHead(num);
                    deque.addFirst(num);
                } else {
                    myDeque.pushTail(num);
                    deque.addLast(num);
                }
            }
            if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.pollHead();
                        num2 = deque.pollFirst();
                    } else {
                        num1 = myDeque.pollTail();
                        num2 = deque.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("poll");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = deque.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = deque.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("peek");
                    }
                }
            }
        }
        if (myDeque.size() != deque.size()) {
            System.out.println("size2");
        }
        if (!myDeque.isEmpty()) {
            int num1 = myDeque.peekHead();
            int num2 = deque.peekFirst();
            if (num1 != num2) {
                System.out.println("peek2");
            }
        }
        System.out.println("测试结束");
    }

    public static void main(String[] args) {
        testDeque();
    }
}
