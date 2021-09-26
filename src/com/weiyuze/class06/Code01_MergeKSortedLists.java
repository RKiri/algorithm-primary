package com.weiyuze.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //定义一个优先级队列
    class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());

    public ListNode mergeKLists(ListNode[] lists) {
        //空 返回
        if (lists == null) {
            return null;
        }
        //将链表数组头节点的值添加到队列里
        for (int i = 0; i < lists.length; i++) {
            //当链表不为空是添加 否则空指针异常
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        //判断队列是否为空
        if (heap.isEmpty()) {
            return null;
        }
        //将最小的弹出 作为头节点
        ListNode head = heap.poll();
        //定义pre为该节点 判断next是否为空 不为空将next add进队列
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        //循环
        while (!heap.isEmpty()) {
            //将最小的弹出 定义cur为该节点 判断next是否为空 不为空将next add进队列
            ListNode cur = heap.poll();
            if (cur.next != null) {
                heap.add(cur.next);
            }
            //pre指向cur pre移动到next
            pre.next = cur;
            pre = pre.next;
        }
        return head;
    }

}
