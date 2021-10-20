package com.lian.myObject.collection;

import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/27 18:22
 */
public class MyQueue {

    Object[]  elements = new Object[100];

    public  static AtomicInteger integer = new AtomicInteger(0);

    int tail = 0;
    int head = 0;

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        for (int i=0;i<5;i++){
            new Thread(()->{
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myQueue.add(integer);
                    integer.addAndGet(1);
                }
            }).start();
        }

        for (int i=0;i<5;i++){
            new Thread(()->{
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Object poll = myQueue.poll();
                }
            }).start();
        }
    }

    /**
     * 入队
     * @param o
     * @return
     */
    public synchronized int add(Object o){
        if(elements.length-1 >= tail){
            if(tail == elements.length-1){
                elements[tail] = o;
                return tail;
            }
            elements[tail++] = o;
            return tail;
        }else {
            return -1;
        }
    }

    /**
     * 出队
     * @return
     */
    public synchronized Object poll(){
        if(tail>=head){
            Object element = elements[head];
            for (int i=head;i<elements.length-2;i++){
                elements[i] = elements[i+1];
            }
            if(tail>0){
                tail--;
            }
            return element;
        }else {
            return -1;
        }


    }
}
