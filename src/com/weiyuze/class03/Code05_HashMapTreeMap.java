package com.weiyuze.class03;

import java.util.HashMap;
import java.util.TreeMap;

public class Code05_HashMapTreeMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("weiyuze", "我是魏宇泽");
        System.out.println(map.containsKey("weiyuze"));
        System.out.println(map.containsKey("wei"));
        System.out.println(map.get("weiyuze"));
        map.put("weiyuze", "他是魏宇泽");
//        map.remove("weiyuze");
//        System.out.println(map.containsKey("weiyuze"));
//        System.out.println(map.get("weiyuze"));

        //按值传递
        String test1 = "weiyuze";
        String test2 = "weiyuze";
        System.out.println(map.containsKey(test1));
        System.out.println(map.containsKey(test2));

        HashMap<Integer,String> map2 = new HashMap<>();
        map2.put(1234567,"我是1234567");
        Integer a = 1234567;
        Integer b = 1234567;
        System.out.println(a==b);
        System.out.println(map2.containsKey(a));
        System.out.println(map2.containsKey(b));

        System.out.println("========================");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        HashMap<Node,String> map3 = new HashMap<>();
        map3.put(n1,"我来了");
        System.out.println(map3.containsKey(n1));
        System.out.println(map3.containsKey(n2));

        System.out.println("========================");
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(4,"我是4");
        treeMap.put(6,"我是6");
        treeMap.put(8,"我是8");
        treeMap.put(9,"我是9");
        treeMap.put(2,"我是2");
        treeMap.put(1,"我是1");

        System.out.println(treeMap.containsKey(4));
        System.out.println(treeMap.get(4));
        treeMap.put(4,"他是4");
        System.out.println(treeMap.get(4));

        treeMap.remove(4);
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.get(4));
        System.out.println(treeMap.floorKey(6));
        System.out.println(treeMap.floorKey(7));
        System.out.println(treeMap.ceilingKey(8));
        System.out.println(treeMap.ceilingKey(7));

//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        TreeMap<Node,String> treeMap1 = new TreeMap<>();
//        treeMap1.put(node3,"333");
//        treeMap1.put(node4,"444");



    }
    static class Node{
        int Value;

        public Node(int value) {
            Value = value;
        }
    }
}
