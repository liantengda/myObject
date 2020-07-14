package com.lian.myObject.myorder;

/**
 * 归并排序
 * @author Ted
 * @version 1.0
 * @date 2020/7/14 21:15
 */
public class RecurOrder {
    private Integer[] halfOneArray = {3,6,8,9};
    private Integer[] halfTwoArray = {1,4,11,17,23};

    public Integer[] recurOrder(){
        Integer[] totalArray = new Integer[halfOneArray.length+halfTwoArray.length];
        int i=0,j=halfTwoArray.length,k=0;
        while (i+k<totalArray.length-1){
            if(k<=halfTwoArray.length-1&&i<=halfOneArray.length-1){
                if(halfOneArray[i]<halfTwoArray[k]){
                    totalArray[i+k] = halfOneArray[i];
                    i++;
                }else if(halfTwoArray[k]<halfOneArray[i]) {
                    totalArray[i+k] = halfTwoArray[k];
                    k++;
                }
            }else if(i>halfOneArray.length-1){
                while (k<=halfTwoArray.length-1){
                    totalArray[i+k] = halfTwoArray[k];
                    k++;
                }
            }else if(k>halfTwoArray.length-1){
                while (i<=halfOneArray.length-1){
                    totalArray[i+k] = halfOneArray[i];
                }
            }

            System.out.println(i+k);
        }
        return totalArray;
    }


    public static void main(String[] args) {
        RecurOrder recurOrder = new RecurOrder();
        Integer[] integers = recurOrder.recurOrder();
        for (Integer integer : integers) {
            System.out.print(integer+" ");
        }
    }
}
