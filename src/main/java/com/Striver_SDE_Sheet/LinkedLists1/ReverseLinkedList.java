package com.Striver_SDE_Sheet.LinkedLists1;

import java.util.List;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseListRec(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseListRec(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode temp = head;

        ListNode prev = null;

        while (temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev =  temp;

            temp = front;
        }

        return prev;
    }

}
