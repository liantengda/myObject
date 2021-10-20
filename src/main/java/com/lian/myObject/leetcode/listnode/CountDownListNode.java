package com.lian.myObject.leetcode.listnode;

/**
 * 输入单链表倒数第K个节点
 * @author Ted
 * @version 1.0
 * @date 2021/10/19 18:25
 */
public class CountDownListNode {

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

        int k = 4;
        ListNode listNode = outputCountDownK(head, k);
        System.out.printf("倒数第%d个节点是:%d",k,listNode.val);
    }

    /**
     * 输出单链表倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    private static ListNode outputCountDownK(ListNode head,int k){
        ListNode pre = head;
        ListNode behind = head;
        do {
            if(k==0){
                behind = behind.next;
            }else {
                k--;
            }
        }while ((pre = pre.next)!=null);

        return behind;
    }
}
