package com.Striver_SDE_Sheet.LinkedListsNArrays;

import com.Striver_SDE_Sheet.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomListBrute(Node head) {
        Map<Node,Node> map = new HashMap<>();

        Node temp = head;
        //copy nodes and add in the map
        while (temp != null){

            Node newNode = new Node(temp.val);

            map.put(temp,newNode);

            temp = temp.next;
        }

        //now connect random & next ptr with the help of the map

        temp = head;

        while (temp != null){

            Node cpNode = map.get(temp);

            cpNode.next = map.get(temp.next);

            cpNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return  map.get(head);
    }

    public Node copyRandomList(Node head) {
        //3 steps problem

        if (head == null) return head;

        // Step 1: Insert copy of
        // nodes in between
        insertNodeInBetween(head);

        // Step 2: Connect random
        // pointers of copied nodes
        connectRandomPointers(head);

        // Step 3: Retrieve the deep
        // copy of the linked list
        return getDeepCopyList(head);
    }


    void insertNodeInBetween(Node head){
       Node temp = head;

       while (temp != null){
           //save the next Node
           Node nextNode = temp.next;

           //create a cpNode;
           Node cpNode = new Node(temp.val);

           //connect cpNode to nextNode;
           cpNode.next = nextNode;

           //connect temp.next to cpNode as we are inserting in between
           temp.next = cpNode;

           //move temp to the nextNode to repeat the same process
           temp = nextNode;
       }
    }

    void connectRandomPointers(Node head){
        Node temp = head;

        while (temp != null){

            //get the copied Node
            Node cpNode = temp.next;

            //check if temp.random is null or not

            if (temp.random != null){
                cpNode.random = temp.random.next; //connecting cp node random to capoied node
            }
            else {

                cpNode.random = null;
            }

            //move temp to the next node

            temp = temp.next.next;
        }
    }

    // Function to retrieve the
    // deep copy of the linked list //connecting th random ptrs

    Node getDeepCopyList(Node head){
        Node temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while (temp != null){
            //connect res.net to the cpNode
            res.next = temp.next;
            //make res to go to the 1st cpNode // dont explicitly need to break the cp and next ptr automaticcly gets breaked
            res = res.next;

            //break temp 1st ptr from the cpNode

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }


}
