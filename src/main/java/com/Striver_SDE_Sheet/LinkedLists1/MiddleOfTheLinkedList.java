package com.Striver_SDE_Sheet.LinkedLists1;

public class MiddleOfTheLinkedList {


    public ReverseLinkedList.ListNode middleNodeBrute(ReverseLinkedList.ListNode head) {

        if (head == null) return head;

        int cnt = 0;
        ReverseLinkedList.ListNode temp = head;

        while (temp != null){
            cnt++;
            temp = temp.next;
        }

        int middle = cnt/2;

        temp = head;

        for (int i =0;i<middle;i++){
            temp = temp.next;
        }

        return temp;
    }

    public ReverseLinkedList.ListNode middleNodeOptimal(ReverseLinkedList.ListNode head) {

        if (head == null) return head;

        ReverseLinkedList.ListNode slow = head;
        ReverseLinkedList.ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}
