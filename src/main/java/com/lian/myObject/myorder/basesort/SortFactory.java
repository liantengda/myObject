package com.lian.myObject.myorder.basesort;

import com.lian.myObject.common.utils.ReflectUtil;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ted
 * @version 1.0
 * @date 2020/7/19 16:19
 */
public class SortFactory {

    private static List<Sort> sortList = new ArrayList<>();

    static {
        List<Class> sortClazzList = ReflectUtil.getAllClassByInterface(Sort.class);
        for (Class sort:sortClazzList){
            try {
                if(sort.getSimpleName().equals("BucketSort")){
                    System.out.println(sort.getSimpleName());
                    Constructor constructor = sort.getConstructor(Integer.class);
                    sortList.add((Sort) constructor.newInstance(4));
                    continue;
                }
               sortList.add((Sort)sort.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static Sort create(int i){
        return sortList.get(i);
    }

    public static int size(){
        return sortList.size();
    }
}
