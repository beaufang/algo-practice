package com.beau;

import com.beau.common.ListNode;

public class Main {

    public static void main(String[] args) {
        // [1,2,4]
        //[1,3,4]
        ListNode l1 = ListNode.composeListNode(1, 2, 4);
        ListNode l2 = ListNode.composeListNode(1, 3, 4);
        ListNode l3 = mergeTwoLists(l1, l2);
        ListNode.printListNode(l3);

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(); // 哨兵
        ListNode tail = sentinel;
        ListNode i = l1, j = l2;
        while (i != null || j != null) {
            if (i != null && (j == null ||  i.val <= j.val)) {
                tail.next = i;
                tail = i;
                i = i.next;
            } else {
                tail.next = j;
                tail = tail.next;
                j = j.next;
            }
        }
        return sentinel.next;
    }

}
