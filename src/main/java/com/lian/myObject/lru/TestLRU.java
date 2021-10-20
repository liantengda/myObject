package com.lian.myObject.lru;

import com.lian.myObject.model.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * @author Ted
 * @date 2020/7/14 10:58
 */
public class TestLRU {

    public static void main(String[] args) throws InterruptedException {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1","1");
        linkedHashMap.put("3","3");
        linkedHashMap.put("10","10");
        linkedHashMap.put("2","2");
        linkedHashMap.put("7","7");
        System.out.println(linkedHashMap);


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1","1");
        hashMap.put("3","3");
        hashMap.put("10","10");
        hashMap.put("2","2");
        hashMap.put("7","7");
        System.out.println(hashMap);

        MyLRU<String, Object> myLRU = new MyLRU<String, Object>(10);
        myLRU.load("1","1");
        myLRU.load("3","3");
        myLRU.load("10","10");
        myLRU.load("2","2");
        myLRU.load("7","7");

        System.out.println(myLRU);
    }
}
