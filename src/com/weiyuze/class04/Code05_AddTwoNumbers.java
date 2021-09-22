package com.weiyuze.class04;

public class Code05_AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = listLength(l1);
        int len2 = listLength(l2);
        ListNode l = len1 >= len2 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;
        ListNode curL = l;
        ListNode curS = s;
        int curNum = 0;
        int carry = 0;
        ListNode last = null;
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
