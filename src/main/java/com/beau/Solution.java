package com.beau;

import com.beau.common.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(); // 哨兵
        ListNode tail = sentinel;
        ListNode i = l1, j = l2;
        while (i != null || j != null) {
            if (i != null && i.val < j.val) {
                tail.next = i;
                tail = i;
                i = i.next;
            } else if (i == null || j.val < i.val) {
                tail.next = j;
                tail = tail.next;
                j = j.next;
            }
        }
        return sentinel.next;
    }
}
