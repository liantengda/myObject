package com.lian.myObject.leetcode.listnode;

/**
 * 链表排序 -- 归并
 * @author Ted
 * @version 1.0
 * @date 2021/10/15 17:37
 */
public class SortListNode {

    public static void main(String[] args) {
        SortListNode sortListNode = new SortListNode();
        //[1,4,8,6,2,5,7]
        ListNode head = new ListNode(8);
        ListNode node2 = new ListNode(4);
        head.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        ListNode node4 = new ListNode(7);
        node3.next = node4;
        ListNode node5 = new ListNode(1);
        node4.next = node5;
        ListNode node6 = new ListNode(3);
        node5.next = node6;
        ListNode node7 = new ListNode(6);
        node6.next = node7;
        ListNode node8 = new ListNode(2);
        node7.next = node8;
        ListNode listNode = sortListNode.sortList(head);

        ListNode temp = listNode;
        do {
            System.out.print(temp.val+" ");
        } while ((temp = temp.next)!=null);
    }


    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}


