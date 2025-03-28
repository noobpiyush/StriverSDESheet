package com.Striver_SDE_Sheet.LinkedLists2;

import com.Striver_SDE_Sheet.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlatteningALinkedList {

    class Node {
        int data;
        Node next;
        Node bottom;

        public Node(int x){
            this.data = x;
            next = null;
            bottom = null;
        }
    }

    Node convertArrToLinkedList(List<Integer> list){

        Node dummy = new Node(-1);

        Node temp = dummy;


        for (int i =0;i<list.size();i++){
            temp.bottom = new Node(list.get(i));

            temp = temp.bottom;
        }

        return dummy.bottom;
    }

    Node flattenBrute(Node root) {
        // code here
        List<Integer> list = new ArrayList<>();
        while (root != null){
            Node t2 = root;

            while (t2 != null){

                list.add(t2.data);

                t2 = t2.bottom;
            }

            root = root.next;

        }

        Collections.sort(list);

        return convertArrToLinkedList(list);
    }

    Node flattenOptimal(Node root){

        if (root == null || root.next == null){
            return root;
        }

        Node mergedHead = flattenOptimal(root.next);
        root = merge(root,mergedHead);

        return root;
    }

    Node merge(Node l1, Node l2){
        Node dummy = new Node(-1);

        Node temp = dummy;


        while (l1 != null && l2 != null){

            if (l1.data <= l2.data){
                temp.bottom = l1;
                temp = temp.bottom;
                l1 = l1.bottom;
            }else {
                temp.bottom = l2;
                temp = temp.bottom;
                l2 = l2.bottom;
            }

            temp.next = null;
        }

        if (l1 != null){
            temp.bottom = l1;
        }
        else {
            temp.bottom = l2;
        }

        if (dummy.bottom != null){
            dummy.bottom.next = null;
        }

        return dummy.bottom;
    }
}
