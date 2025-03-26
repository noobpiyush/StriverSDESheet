package com.Striver_SDE_Sheet.LinkedLists2;

import com.Striver_SDE_Sheet.common.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public boolean isPalindromeBrute(ListNode head) {

        Stack<Integer> st = new Stack<>();

        ListNode cur = head;

        while (cur != null){

            st.add(cur.val);

            cur = cur.next;
        }

        cur = head;

        while (cur != null){

            if (st.peek() != cur.val) return false;

            st.pop();

            cur = cur.next;
        }

        return  true;
    }
    public boolean isPalindromeOptimal(ListNode head) {

        //3 steps

        if (head == null || head.next == null) return true;

        //step1 finding the middle

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //step2 rev

        ListNode newHead = rev(slow.next);
        ListNode second = newHead;

        ListNode first = head;
        //step3 comparing

        while (second!= null){

            if (second.val != first.val){
                rev(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        rev(newHead);

        return true;
    }

    public ListNode rev(ListNode head){

        if (head ==null) return head;

        ListNode cur  = head;
        ListNode prev = null;

        while (cur != null){
            ListNode next  = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
