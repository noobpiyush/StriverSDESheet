package com.Striver_SDE_Sheet.LinkedLists1;

public class RemoveNthNodeFromEndofList {

    public ReverseLinkedList.ListNode removeNthFromEndBrute(ReverseLinkedList.ListNode head, int n) {

        if (head == null) return head;

        int cnt = 0; //cant will be the total len
        ReverseLinkedList.ListNode temp = head;

        while (temp != null){
            cnt++;
            temp = temp.next;
        }

        //we have to ddelete head as we have to delete from the back
        if (cnt == n){
            ReverseLinkedList.ListNode newHead = head.next;
            head = null;
            return newHead;
        }

        //go till cnt - n;

        int dist = cnt - n;

        temp = head;

        while (temp != null){
            dist--;

            if (dist == 0) break;

            temp = temp.next;
        }

        ReverseLinkedList.ListNode delete = temp.next;

        temp.next = temp.next.next;

        delete = null;

        return head;

    }

    public ReverseLinkedList.ListNode removeNthFromEndOptimal(ReverseLinkedList.ListNode head, int n) {

        if (head == null) return head;

        ReverseLinkedList.ListNode fast = head;
        ReverseLinkedList.ListNode slow = head;

        for (int i = 0; i<n;i++){
            fast = fast.next;
        }

        //we had to delete head from back
        if (fast == null){
            return head.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ReverseLinkedList.ListNode toDelete = slow.next;
        slow.next = slow.next.next;
        toDelete = null;
        return head;

    }

    public static void main(String[] args) {
        System.out.println(7/10);
    }
}
