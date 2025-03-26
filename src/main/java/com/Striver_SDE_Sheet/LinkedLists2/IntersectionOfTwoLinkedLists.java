package com.Striver_SDE_Sheet.LinkedLists2;

import com.Striver_SDE_Sheet.common.ListNode;

import java.util.HashSet;


public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        ListNode curA = headA;

        while (curA != null) {
            ListNode curB = headB;

            while (curB != null) {

                if (curA == curB) {
                    return curA;
                }

                curB = curB.next;
            }

            curA = curA.next;
        }

        return curA;
    }

    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode curA = headA;

        while (curA != null) {
            set.add(curA);
            curA = curA.next;
        }

        ListNode curB = headB;

        while (curB != null) {

            if (set.contains(curB)) {
                return curB;
            }

            curB = curB.next;
        }

        return curA;
    }

    public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return headA;

        ListNode curA = headA;

        ListNode curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }


}
