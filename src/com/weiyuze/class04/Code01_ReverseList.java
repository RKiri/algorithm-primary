package com.weiyuze.class04;

import java.util.ArrayList;
import java.util.List;

public class Code01_ReverseList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    static Node reverseLinkedList(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode last = null;
        while (head != null) {
            next = head.next;
            head.next = last;
            head.last = next;
            last = head;
            head = next;
        }
        return last;
    }

    static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        size--;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        size--;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        int size = origin.size();
        for (int i = size - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        int size = origin.size();
        DoubleNode last = null;
        for (int i = size - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            last = head;
            head = head.next;
        }
        for (int i = 0; i < size; i++) {
            if (!origin.get(i).equals(last.value)) {
                return false;
            }
            last = last.last;
        }
        return true;
    }

    public static void main(String[] args) {
        int len = 20;
        int value = 100;
        int testTime = 100000;
        Node node1 = generateRandomLinkedList(len, value);
        List<Integer> list1 = getLinkedListOriginOrder(node1);
        node1 = reverseLinkedList(node1);
        System.out.println("测试开始1");
        for (int i = 0; i < testTime; i++) {
            while (!checkLinkedListReverse(list1, node1)) {
                System.out.println("异常1");
                break;
            }
        }
        DoubleNode node2 = generateRandomDoubleList(len, value);
        List<Integer> list2 = getDoubleListOriginOrder(node2);
        node2 = reverseDoubleList(node2);
        System.out.println("测试开始2");
        for (int i = 0; i < testTime; i++) {
            while (!checkDoubleListReverse(list2, node2)) {
                System.out.println("异常2");
                break;
            }
        }

        System.out.println("测试结束");
    }

}
