package com.Striver_SDE_Sheet.LinkedListsNArrays;

import com.Striver_SDE_Sheet.common.ListNode;

public class RotateList {

    //Leet code version right rotation k times
    public ListNode rotateRight(ListNode head, int k) {

      if (head == null || head.next == null || k == 0) return head;

      ListNode tail = head;
      int len = 1;

      while (tail.next != null) {
          tail = tail.next;
          len = len + 1;
      }

      if (k % len == 0) return head;

      k = k % len;

//      k = len - k; for left roataion

      ListNode newLastNode = findKthNode(head, len - k);

      ListNode newHead = newLastNode.next;

      newLastNode.next = null;

      tail.next = head;

      head = newHead;

      return head;
    }

    // 6%4 is 6 divided by 4 's remainder that is 2
    //left roation = len - k right's roataion

    public ListNode findKthNode(ListNode head, int k){
        ListNode temp = head;
        int cnt = 1;

        while (temp != null){
            if (cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }

        return temp;
    }
}
