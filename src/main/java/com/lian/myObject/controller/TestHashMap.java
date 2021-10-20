package com.lian.myObject.controller;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/15 10:53
 */
public class TestHashMap {


    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Integer> singleMap = new HashMap<String, Integer>(4, 0.75f);
        singleMap.put("1",1);
        singleMap.put("2",2);
        singleMap.put("7",7);
        singleMap.put("8",8);
        System.out.println(singleMap);


        HashMap<String, Integer> multiMap = new HashMap<>(4, 0.75f);

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.put(1);
        queue.put(2);
        queue.put(7);
        queue.put(8);

        for (int i=0;i<4;i++){
            Integer poll = queue.poll();
            new Thread(()->{
               multiMap.put(poll+"",poll);
            }).start();
        }
        System.out.println(multiMap);

        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());

    }
}


