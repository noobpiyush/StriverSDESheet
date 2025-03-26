package com.Striver_SDE_Sheet.LinkedLists2;

import com.Striver_SDE_Sheet.common.ListNode;


import java.util.HashSet;

public class LinkedListCycle {

    public boolean hasCycleBrute(ListNode head) {
        if (head == null) return false;

        HashSet<ListNode> set = new HashSet<>();

        ListNode cur = head;

        while (cur != null){

            if (set.contains(cur)) return true;
            set.add(cur);
            cur = cur.next;
        }

        return false;
    }

    public boolean hasCycleOptimal(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

//    variant 2 if we have to return the st pt of the cycle

    public ListNode hasCycleOptimalV2(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            //step2
            if (slow == fast){
                slow = head;

                while (slow != fast){
                    slow = slow.next;
                    fast= fast.next;

                }

                return slow;
            }
        }

        return null; //no cycle detected
    }



}
