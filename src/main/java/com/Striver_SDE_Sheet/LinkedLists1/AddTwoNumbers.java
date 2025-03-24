package com.Striver_SDE_Sheet.LinkedLists1;

public class AddTwoNumbers {

    //gfg version
    static ReverseLinkedList.ListNode addTwoListsBrute(ReverseLinkedList.ListNode num1, ReverseLinkedList.ListNode num2) {
        // code here

        ReverseLinkedList.ListNode dummy = new ReverseLinkedList.ListNode(-1);
        ReverseLinkedList.ListNode temp = dummy;

        num1 = trimZeros(num1);

        num2 = trimZeros(num2);

        num1 = rev(num1);
        num2 = rev(num2);


        int carry = 0;

        while (num1 != null || num2 != null || carry == 1) {
            int sum = 0;
            if (num1 != null) {
                sum += num1.val;
                num1 = num1.next;
            }

            if (num2 != null) {
                sum += num2.val;
                num2 = num2.next;
            }

            sum += carry;

            carry = sum / 10;

            ReverseLinkedList.ListNode newNode = new ReverseLinkedList.ListNode(sum % 10);

            temp.next = newNode;
            temp = temp.next;
        }

        return rev(dummy.next);
    }

    public static int len(ReverseLinkedList.ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }

        return cnt;
    }

//    static ReverseLinkedList.ListNode addTwoListsOptimal(ReverseLinkedList.ListNode num1, ReverseLinkedList.ListNode num2) {
//        // code here
//        num1 = trimZeros(num1);
//
//        num2 = trimZeros(num2);
//
//        num1 = rev(num1);
//        num2 = rev(num2);
//
//        int len1 = len(num1);
//        int len2 = len(num2);
//
//        if (len1 < len2) {
//            return addTwoListsOptimal(num2, num1);
//        }
//
//
//        int carry = 0;
//
//        while (num1 != null || num2 != null || carry == 1) {
//
//            num1.val += carry;
//
//            if (num2 != null) {
//                num1.val += num2.val;
//            }
//
//            carry = num1.val/10;
//
//            num1.val = num1.val%10;
//
//        }
//
//        return rev(dummy.next);
//    }

    public static ReverseLinkedList.ListNode trimZeros(ReverseLinkedList.ListNode head) {
        while (head != null && head.val == 0) {
            head = head.next;
        }

        return head;
    }

    public static ReverseLinkedList.ListNode rev(ReverseLinkedList.ListNode head) {
        ReverseLinkedList.ListNode prev = null;
        ReverseLinkedList.ListNode cur = head;

        while (cur != null) {
            ReverseLinkedList.ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ReverseLinkedList.ListNode addTwoNumbers(ReverseLinkedList.ListNode l1, ReverseLinkedList.ListNode l2) {

        ReverseLinkedList.ListNode dummy = new ReverseLinkedList.ListNode(-1);
        ReverseLinkedList.ListNode temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            ReverseLinkedList.ListNode newNode = new ReverseLinkedList.ListNode(sum % 10);

            temp.next = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }

}
