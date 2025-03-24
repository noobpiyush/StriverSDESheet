package com.Striver_SDE_Sheet.LinkedLists1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {

    public ReverseLinkedList.ListNode mergeTwoListsBrute(ReverseLinkedList.ListNode list1, ReverseLinkedList.ListNode list2) {

        List<ReverseLinkedList.ListNode> list = new ArrayList<>();

        ReverseLinkedList.ListNode temp = list1;

        while (temp != null){
            list.add(temp);

            temp = temp.next;
        }

        temp = list2;

        while (temp != null){
            list.add(temp);

            temp = temp.next;
        }

        Collections.sort(list, (a,b) -> a.val - b.val);

        ReverseLinkedList.ListNode dummy = new ReverseLinkedList.ListNode(-1);
        temp = dummy;

        for (ReverseLinkedList.ListNode node : list){
            temp.next = node;
            temp = temp.next;
        }

        temp.next = null;

        return dummy.next;
    }

    public ReverseLinkedList.ListNode mergeTwoListsOptimal(ReverseLinkedList.ListNode list1, ReverseLinkedList.ListNode list2) {

        ReverseLinkedList.ListNode dummy = new ReverseLinkedList.ListNode(-1);

        ReverseLinkedList.ListNode temp = dummy;

        while (list1 != null && list2 != null){

            if (list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }


        if (list1 != null){
            temp.next = list1;
        }
        else {
            temp.next = list2;
        }

        return dummy.next;
    }
}
