package com.lian.myObject.controller;

import java.util.HashMap;

/**
 * @author Ted
 * @version 1.0
 * @date 2021/9/15 11:08
 */
public class TestHashMap2 {


        public static void main(String[] args) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(4,0.75f);
            map.put(3, 3);
            map.put(7, 7);
            map.put(15, 15);
            new Thread(new myThread(map, 22)).start();
            new Thread(new myThread(map, 18)).start();
            System.out.println(map); }
}


class myThread implements Runnable {
    private HashMap<Integer, Integer> map;
    private Integer key;
    public myThread(HashMap<Integer, Integer> map, Integer key) {
        this.map = map; this.key = key;
    }

    @Override
    public void run() {
        map.put(key, key);
    }
}
