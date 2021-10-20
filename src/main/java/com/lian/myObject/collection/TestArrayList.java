package com.lian.myObject.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/22 16:46
 */
public class TestArrayList {

    private static final int CAPACITY = 100000;

    public static void getByForTest(){
        ArrayList<String> strings = new ArrayList<>();
        int i=0;
        while (i<CAPACITY){
            strings.add(i+"落叶");
            i++;
        }

        long timeStart = System.currentTimeMillis();

        for (int j=0;j<CAPACITY;j++){
            strings.get(j);
        }

        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList 的 for 循环 花费的时间："+(timeEnd-timeStart));
    }


    public static void getByIteratorTest(){
        ArrayList<String> strings = new ArrayList<>();
        int i =0;
        while (i<CAPACITY){
            strings.add(i+"落叶");
            i++;
        }

        long timeStart = System.currentTimeMillis();

        for (Iterator<String> it = strings.iterator();it.hasNext();){
            it.next();
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList迭代器花费时间 "+(timeEnd-timeStart));
    }



    public static void main(String[] args) {
        getByForTest();
        getByIteratorTest();
        getLinkedByForTest();
        getLinkedByIteratorTest();

        new ConcurrentHashMap<>();
    }


    public static void getLinkedByForTest(){
        LinkedList<String> strings = new LinkedList<>();
        int i=0;
        while (i<CAPACITY){
            strings.add(i+"落叶");
            i++;
        }

        long timeStart = System.currentTimeMillis();

        for (int j=0;j<CAPACITY;j++){
            strings.get(j);
        }

        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList 的 for 循环 花费的时间："+(timeEnd-timeStart));
    }


    public static void getLinkedByIteratorTest(){
        LinkedList<String> strings = new LinkedList<>();
        int i =0;
        while (i<CAPACITY){
            strings.add(i+"落叶");
            i++;
        }

        long timeStart = System.currentTimeMillis();

        for (Iterator<String> it = strings.iterator();it.hasNext();){
            it.next();
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList迭代器花费时间 "+(timeEnd-timeStart));
    }

}
