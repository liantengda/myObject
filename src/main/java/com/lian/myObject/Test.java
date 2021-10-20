package com.lian.myObject;

import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.HashMap;

/**
 * @author Ted
 * @version 1.0
 * @date 2020/7/24 7:05
 */
public class Test {
    private final static Integer number = 4;
    public int inc(){
        return number+1;
    }

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1",1);
        for (int i=2;i<20;i++){
            hashMap.put(i+"",i);
        }
        hashMap.put("1",1111111);

    }
}
