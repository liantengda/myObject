package com.lian.myObject.leetcode.listnode;

/**
 * 找到链表的中间节点
 * @author Ted
 * @version 1.0
 * @date 2021/10/20 10:01
 */
public class FindMiddleNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        ListNode next = head;
        do {
            System.out.print(next.val+" ");
        }while ((next = next.next)!=null);

        System.out.println();

        ListNode middleNode = findMiddleNode(head);
        System.out.println("链表的中间节点："+middleNode.val);
    }

    /**
     * 找到链表的中间节点
     * @param head
     * @return
     */
    private static ListNode findMiddleNode(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while ((slow = slow.next)!=null&&fast.next!=null&&(fast = fast.next.next)!=null){

        }

        return slow;
    }
}
