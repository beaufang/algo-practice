package com.beau.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode composeListNode(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode cur = head;
        for (int i = 1; i< values.length; i++) {
            cur.next = new ListNode(values[i]);
            cur = cur.next;
        }
        return head;
    }

    public static String getListNodesString(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    public static void printListNode(ListNode head) {
        System.out.println(getListNodesString(head));
    }

}
