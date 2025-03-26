package com.Striver_SDE_Sheet.LinkedLists2;

import com.Striver_SDE_Sheet.common.ListNode;

public class ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        ListNode prev = null;

        while (temp != null){
            ListNode kthNode = getKthNode(temp,k);

            if (kthNode == null){

                if (prev != null){
                    prev.next = temp;
                }

                break;
            }

            //store the next node

            ListNode nextNode = kthNode.next;

            kthNode.next = null;

            //rev
            rev(temp);

            if (head == temp){
                head = kthNode;
            }
            else {
                prev.next = kthNode;
            }


            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    public static ListNode getKthNode(ListNode head, int k){
       k = k-1;

       ListNode temp = head;

       while (temp != null && k > 0){
           k--;

           temp = temp.next;
       }

       return temp;
    }

    public static ListNode rev(ListNode head){

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null ){
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return temp;
    }
}
