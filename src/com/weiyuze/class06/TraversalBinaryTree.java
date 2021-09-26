package com.weiyuze.class06;

public class TraversalBinaryTree {
    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    static void f(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        f(node.left);
        System.out.print(node.val + " ");
        f(node.right);
        System.out.print(node.val + " ");
    }

    static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }

    static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.println(node.val);
        in(node.right);
    }

    static void pos(Node node) {
        if (node == null) {
            return;
        }
        pos(node.left);
        pos(node.right);
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        pre(node);
        System.out.println("================");
        in(node);
        System.out.println("================");
        pos(node);
        System.out.println("================");
        f(node);

    }
}
