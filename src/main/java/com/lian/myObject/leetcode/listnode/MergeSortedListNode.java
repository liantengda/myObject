package com.lian.myObject.leetcode.listnode;


/**
 * 合并有序单链表
 * @author Ted
 * @version 1.0
 * @date 2021/10/20 10:37
 */
public class MergeSortedListNode {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        head1.next = node11;

        ListNode node12 = new ListNode(2);
        node11.next = node12;
        ListNode node13 = new ListNode(3);
        node12.next = node13;
        ListNode node14 = new ListNode(4);
        node13.next = node14;
        ListNode node15 = new ListNode(4);
        node14.next = node15;
        ListNode node16 = new ListNode(6);
        node15.next = node16;
        ListNode node17 = new ListNode(8);
        node16.next = node17;
        ListNode node18 = new ListNode(9);
        node17.next = node18;

        ListNode next1 = head1;
        do {
            System.out.print(next1.val+" ");
        }while ((next1 = next1.next)!=null);

        System.out.println('\n'+"--------------");

        ListNode head2 = new ListNode(2);
        ListNode head21 = new ListNode(5);
        head2.next = head21;
        ListNode head22 = new ListNode(7);
        head21.next = head22;
        ListNode head23 = new ListNode(11);
        head22.next = head23;
        ListNode head24 = new ListNode(12);
        head23.next = head24;

        ListNode next2 = head2;
        do {
            System.out.print(next2.val + " ");
        }while ((next2 = next2.next)!=null);

        System.out.println('\n'+"--------------");

        ListNode newHead = mergeSortedListNode(head1, head2);
        ListNode next3 = newHead;
        do {
            System.out.print(next3.val+" ");
        }while ((next3 = next3.next)!=null);
    }

    /**
     * 合并有序链表
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode mergeSortedListNode(ListNode head1,ListNode head2){
        ListNode index1 = head1;
        ListNode index2 = head2;
        ListNode newHead = new ListNode(-1);
        ListNode index3 = newHead;
        do {
            if( index1!=null && index1.val<index2.val){
                index3.next = index1;
                index1 = index1.next;
            }else{
                index3.next = index2;
                index2 = index2.next;
            }
            index3 = index3.next;
        }while (index1!=null||index2!=null);

        return newHead.next;
    }
}
