package com.lian.myObject.myorder;

import java.util.Iterator;

/**
 * 插入排序
 *
 * 基本有序，或者规模较小的时候有用
 * @author Ted
 * @date 2020/7/14 14:56
 */
public class InsertOrder {

    private  Integer[] orderArray;


    public InsertOrder(Integer[] orderArray){
        this.orderArray = orderArray;
    }

    public Integer[] order(){
        if(orderArray==null){
            return null;
        }
        int i,k,x;
        Integer[] orderedArray = new Integer[orderArray.length];
        for (i=0;i<orderArray.length;i++){
            System.out.println(orderArray[i]);
            for (k = i;k>0;k--){
                if(orderedArray[k-1]>orderArray[i]){
                    orderedArray[k] = orderedArray[k-1];
                }else {
                    break;
                }
            }
            orderedArray[k] = orderArray[i];
        }
        return orderedArray;
    }

    public static void main(String[] args) {
        InsertOrder insertOrder = new InsertOrder(new Integer[]{8, 4, 5, 6, 9, 0, 2, 1, 7});
        Integer[] order = insertOrder.order();
        for (Integer integer : order) {
            System.out.print(integer+" ");
        }
    }
}
